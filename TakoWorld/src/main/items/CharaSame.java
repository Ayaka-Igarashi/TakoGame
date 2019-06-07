package main.items;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.supers.GameChara;

public class CharaSame extends GameChara {
	public static final int REMOVE=0;
	public static final int NORMAL_L=1;
	public static final int NORMAL_R=2;

	@Override
	public void first() {
		this.nowState=CharaSame.REMOVE;
		this.setVisible(0, false);
		this.setVisible(1, false);
		this.setVisible(2, false);
		this.setVisible(3, false);
	}

	@Override
	public void control(TWInfo tInfo) {
		if(this.isChange==true) {
			if(this.nowState==CharaSame.REMOVE) {
				this.setVisible(0, false);
				this.setVisible(1, false);
				this.setVisible(2, false);
				this.setVisible(3, false);
			}else if(this.nowState==CharaSame.NORMAL_L) {
				this.setVisible(0, true);
				this.setVisible(1, false);
				this.setVisible(2, true);
				this.setVisible(3, false);
			}else if(this.nowState==CharaSame.NORMAL_R) {
				this.setVisible(0, false);
				this.setVisible(1, true);
				this.setVisible(2, false);
				this.setVisible(3, true);
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
