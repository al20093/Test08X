/****************************************/ 
/*author:西村美玖 6/27更新 
/*C7:服装情報設定処理部所属 
/*DataSettingClothing: 
/*服装設定情報処理部でのデータ処理を記述する
/****************************************/

package application;

import java.util.List;
import java.util.ArrayList;

class DataSettingClothing
{	
	//-------------------------------------------- 
	//List<Clothes> getClothes()
	//ユーザ情報管理部から全ての服装データを取ってくる
	//--------------------------------------------
	List<Clothes> getClothes()
	{
		List<Clothes> clothes;
		//取得する
		clothes = new UserData().clothesRead();
		return clothes;
	}
	
	
	//-------------------------------------------- 
	//void addClothes(List<Clothes> clothes)
	//追加した服装情報をファイルに書き込む
	//--------------------------------------------
	void addClothes(Clothes clothes)
	{
		//ユーザ情報処理部の書き込むメソッドを呼び出す
		new UserData().clothesWrite(clothes);
	}
	
	
	//-------------------------------------------- 
	//Clothes matching(String clothesName)
	//リストビューで選択された服装名称と
	//削除した服装情報をファイルから削除する
	//--------------------------------------------
	Clothes matching(String clothesName)
	{
		Clothes clothes = new Clothes();
		List<Clothes> allClothes = getClothes();
		//全ての服装データnameに会うデータを持ってくる
		for(int i = 0; i < allClothes.size(); i++ )
		{
			if(clothesName == allClothes.get(i).name)
				{
					clothes = allClothes.get(i);
					break;
				}
		}
		return clothes;
	}
	
	//-------------------------------------------- 
	//void deleteClothes(String clothes)
	//削除した服装情報をファイルから削除する
	//--------------------------------------------
	void deleteClothes(Clothes clothes)
	{
		new UserData().clothesDelete(clothes);
	}
}