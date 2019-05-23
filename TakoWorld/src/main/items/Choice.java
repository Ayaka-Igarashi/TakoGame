package main.items;

import main.TWInfo;
import main.supers.GameItem;

//選択肢
public class Choice extends GameItem{

	//初期画像設定
	@Override
	public void first() {
		// TODO 自動生成されたメソッド・スタブ
		super.first();
	}

	//毎回呼び出される
	@Override
	public void control(TWInfo tInfo) {
		// TODO 自動生成されたメソッド・スタブ
		super.control(tInfo);
	}

	//キーが押された時の処理
	@Override
	public void keyControl(TWInfo tInfo, int key,int action) {
		// TODO 自動生成されたメソッド・スタブ
		super.keyControl(tInfo, key,action);
	}

}
