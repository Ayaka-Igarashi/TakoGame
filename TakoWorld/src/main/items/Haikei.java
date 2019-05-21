package main.items;

import main.KEY_STATE;
import main.TWInfo;
import main.supers.GameItem;

public class Haikei extends GameItem {

	@Override
	public void control(TWInfo tInfo) {
		this.setVisible(0, true);
		return;
	}

	@Override
	public void keyControl(TWInfo tInfo) {
		if(tInfo.keyState[KEY_STATE.Z]) {
			this.setVisible(0, false);
			this.setVisible(1, true);
		}
		return;
	}


}
