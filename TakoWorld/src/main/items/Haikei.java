package main.items;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.supers.GameItem;

public class Haikei extends GameItem {
	public static final int BLUE=1;
	public static final int PURPLE=2;

	//初期画像設定
	@Override
	public void first() {
		this.nowState=Haikei.BLUE;
		this.isChange=false;
		this.setVisible(0, true);
		this.setVisible(1, false);
		return;
	}

	//毎回呼び出される
	@Override
	public void control(TWInfo tInfo) {
		if(this.isChange==true) {
			if(this.nowState==Haikei.BLUE) {
				this.setVisible(0, true);
				this.setVisible(1, false);
			}else if(this.nowState==Haikei.PURPLE) {
				this.setVisible(0, false);
				this.setVisible(1, true);
			}
			this.isChange=false;
		}
		return;
	}

	//キーが押された時の処理
	@Override
	public void keyControl(TWInfo tInfo,int key,int action) {
		if(key==KEY_STATE.Z) {
			this.nowState=action;
			this.isChange=true;
		}
		return;
	}


}
