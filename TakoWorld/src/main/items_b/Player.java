package main.items_b;

import main.TWInfo;
import main.supers.GameItem;

public class Player extends GameItem{

	@Override
	public void first() {
		this.setVisible(0, true);

	}

	@Override
	public void control(TWInfo tInfo) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void keyControl(TWInfo tInfo, int key, int action) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void drawOne(TWInfo tInfo, int idx) {
		super.drawOne(tInfo, idx);
	}


}
