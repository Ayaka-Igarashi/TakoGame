package main.items;

import main.KEY_STATE;
import main.TWInfo;
import main.supers.GameItem;

public class Haikei extends GameItem {

	//初期画像設定
	@Override
	public void first() {
		this.setVisible(0, true);
		return;
	}

	//毎回呼び出される
	@Override
	public void control(TWInfo tInfo) {
		return;
	}

	//キーが押された時の処理
	@Override
	public void keyControl(TWInfo tInfo) {
		if(tInfo.keyState[KEY_STATE.Z]) {
			this.setVisible(0, false);
			this.setVisible(1, true);
		}
		return;
	}


}
