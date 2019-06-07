package main.items;

import main.TWInfo;
import main.supers.GameItem;

public class TextBox extends GameItem {

	@Override
	public void first() {
		this.setVisible(0, true);
		//this.setVisible(1, true);
		//this.setVisible(2, true);
		this.setVisible(3, true);
		this.setVisible(4, true);
		return;
	}

	@Override
	public void control(TWInfo tInfo) {

	}

	@Override
	public void keyControl(TWInfo tInfo,int key,int action) {
		return;
	}

}
