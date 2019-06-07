package main.items;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.supers.GameChara;

//ホタテ
public class Hotate extends GameChara{
	public static final int REMOVE=0;
	public static final int NORMAL=1;
	public static final int SWEATED=2;

	//初期設定
	@Override
	public void first() {
		this.nowState=Hotate.NORMAL;
		this.isChange=false;
		this.setVisible(0, true);
		this.setVisible(1, false);
		return;
	}

	@Override
	public void control(TWInfo tInfo) {
		if(this.isChange==true) {
			if(this.nowState==Hotate.REMOVE) {
				this.setVisible(0, false);
				this.setVisible(1, false);
			}else if(this.nowState==Hotate.NORMAL) {
				this.setVisible(0, true);
				this.setVisible(1, false);
			}else if(this.nowState==Hotate.SWEATED) {
				this.setVisible(0, false);
				this.setVisible(1, true);
			}
			this.isChange=false;
		}
		return;
	}

	//キーが押された瞬間の画像処理
	@Override
	public void keyControl(TWInfo tInfo,int key,int action) {
		if(key==KEY_STATE.Z) {
			this.nowState=action;
			this.isChange=true;
		}
		return;
	}

}
