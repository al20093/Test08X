/**********************************************/
/*author:西村　美玖 6/21更新
/*C7:服装設定処理部所属
/*EventSettingClothing:
/*服装設定モードのイベント処理を記述したクラス
/**********************************************/
package application;

import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class EventSettingClothing 
{
	SceneSettingClothing settingClothing;
	
	EventSettingClothing(SceneSettingClothing settingclothing)
	{
		this.settingClothing = settingclothing;
	}
	
	void clickCancel(Button cancel)
	{
		cancel.setOnAction((ActionEvent) ->
		{ settingClothing.assignSceneToStage("preference"); }); //キャンセルボタンを押したらW10画面へ遷移
	}
	
	void clickRegister1(Button register, List<TextField> tf)
	{
		register.setOnAction((ActionEvent) -> 
		{
			//String clothingName;
			//String clothingClass;
			//String bodyClass;
			//double clothingValue;
			
			Clothes clothes = new Clothes();
			
			clothes.name = tf.get(0).getText();
			clothes.kind = tf.get(1).getText();
			clothes.part = tf.get(2).getText();
			clothes.index = Double.parseDouble(tf.get(3).getText());
			
			//データ処理部の書き込みメソッドを呼び出す
			//new DataSettingClothing().addClothes(clothes);
			
			//確認用
			System.out.println(clothes.name);
			System.out.println(clothes.kind);
			System.out.println(clothes.part);
			System.out.println(clothes.index);
			
			//登録完了アラート画面表示
			new DataSettingClothing().addClothes(clothes);
			new CreateAlert().complete(Constant.REGISTERMESSAGE);
		}); 
	}
	
	void clickRegister2(Button register, ObservableList<String> ol, ListView<String> lv)
	{
		register.setOnAction((ActionEvent) -> 
		{
			String deleteClothing;
			String name;
			deleteClothing = lv.getSelectionModel().getSelectedItem();
			
			//名前を取り出す
			name = deleteClothing;
			//データ処理部を呼び出す,消すアイテムをclothesにいれる
			Clothes clothes = new DataSettingClothing().matching(name);
			for(int i = 0; i < ol.size(); i++)
			{
				if(ol.get(i).equals(clothes.name)) ol.remove(i);
			}
			
			//確認用
			System.out.println(deleteClothing);
			
			boolean check = new CreateAlert().confirm(Constant.DELETEMESSAGE); //登録完了アラート画面表示
			if(check == true)
			{
				System.out.println("true");
			}else{
				System.out.println("false");
			}
			
		}); 
	}
	
	void clickDelete(Button delete)
	{
		delete.setOnAction((ActionEvent) ->
		{settingClothing.assignSceneToStage("delete");}); //削除ボタンを押したらW9画面へ移動
	}
	
	void clickAddition(Button add)
	{
		add.setOnAction((ActionEvent) ->
		{settingClothing.assignSceneToStage("addition");}); //追加ボタンを押したらW9画面へ移動
	}
}

/*public class EventClothingList
{
	SceneClothingList clothinglist;
	
	EventClothingList(SceneInputClothing clothinglist)
	{
		this.clothinglist = clothinglist;
	}
	
	void clickRegister(Button register, ListView<String> lv)
	{
		register.setOnAction((ActionEvent) -> 
		{
			String deleteClothing;
			deleteClothing = lv.getSelectionModel().getSelectedItem();
			
			//確認用
			System.out.println(deleteClothing);
			
			boolean check = new CreateAlert().confirm("削除が完了しました。"); //登録完了アラート画面表示
			if(check == true)
			{
				System.out.println("true");
			}else{
				System.out.println("false");
			}
			
		}); 
	}
	
	void clickAdd(Button add)
	{
		add.setOnAction((ActionEvent) ->
		{clothinglist.assignSceneToStage("add");}); //追加ボタンを押したらW9画面へ移動
	}
}*/