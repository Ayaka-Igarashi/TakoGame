package main.items;

import main.TWInfo;
import main.supers.GameItem;

public class TextBox extends GameItem {
	public int nowLeft;
	public int nowRight;

	@Override
	public void first() {
		this.setVisible(0, true);
		this.setVisible(1, false);
		this.setVisible(2, false);
		this.setVisible(3, true);
		this.setVisible(4, true);
		this.setVisible(5, false);
		this.setVisible(6, false);
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
