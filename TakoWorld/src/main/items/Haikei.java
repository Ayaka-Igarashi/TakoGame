package main.items;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.supers.GameItem;

public class Haikei extends GameItem {
	public static final int BLUE=1;
	public static final int CASTLE=2;

	//初期画像設定
	@Override
	public void first() {
		this.setVisible(0, true);
		this.setVisible(1, false);
		return;
	}

	//毎回呼び出される
	@Override
	public void control(TWInfo tInfo) {
		return;
	}

	//キーが押された時の処理
	@Override
	public void keyControl(TWInfo tInfo,int key,int action) {
		if(key==KEY_STATE.Z) {
			if(action==Haikei.BLUE) {
				this.setVisible(0, true);
				this.setVisible(1, false);
			}else if(action==Haikei.CASTLE) {
				this.setVisible(0, false);
				this.setVisible(1, true);
			}
		}
		return;
	}


}
