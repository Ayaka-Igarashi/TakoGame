package main.items;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.supers.GameChara;

public class Enemy extends GameChara {
	public static final int REMOVE=0;
	public static final int TAKOYAKI_L=1;
	public static final int TAKOYAKI_R=2;

	@Override
	public void first() {
		this.nowState=Enemy.REMOVE;
		this.isChange=false;
		for(int i=0;i<this.imgList.size();i++) {
			this.setVisible(i, false);
		}
		return;
	}

	@Override
	public void control(TWInfo tInfo) {
		if(this.isChange==true) {
			if(this.nowState==Enemy.REMOVE) {
				for(int i=0;i<this.imgList.size();i++) {
					this.setVisible(i, false);
				}
			}else {
				for(int i=0;i<this.imgList.size();i++) {
					if(i==this.nowState-1) {this.setVisible(i, true);}
					else {this.setVisible(i, false);}
				}
			}

			this.isChange=false;
		}
		return;

	}

	@Override
	public void keyControl(TWInfo tInfo, int key, int action) {
		if(key==KEY_STATE.Z) {
			this.nowState=action;
			this.isChange=true;
		}
		return;

	}

}
