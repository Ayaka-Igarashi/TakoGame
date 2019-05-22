package main.items;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.supers.GameChara;

//ホタテ
public class Hotate extends GameChara{

	//初期設定
	@Override
	public void first() {
		this.setVisible(0, true);
		this.setVisible(1, false);
		return;
	}

	@Override
	public void control(TWInfo tInfo) {
		return;
	}

	//キーが押された瞬間の画像処理
	@Override
	public void keyControl(TWInfo tInfo,int key) {
		if(key==KEY_STATE.Z) {
			this.setVisible(0, false);
			this.setVisible(1, true);
		}
		if(key==KEY_STATE.X) {
			this.setVisible(0, true);
			this.setVisible(1, false);
		}
		return;
	}

}
