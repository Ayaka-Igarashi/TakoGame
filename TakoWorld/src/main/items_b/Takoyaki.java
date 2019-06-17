package main.items_b;

import java.awt.geom.Point2D;

import main.TWInfo;

public class Takoyaki extends GameChara_B {

	public Takoyaki() {
	}

	@Override
	public void first() {
		this.setVisible(0, true);
		this.position=new Point2D.Double(400, 100);
	}

	@Override
	public void control(TWInfo tInfo) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void keyControl(TWInfo tInfo, int key, int action) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
