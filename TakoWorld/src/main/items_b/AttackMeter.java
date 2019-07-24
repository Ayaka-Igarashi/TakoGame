package main.items_b;

import java.awt.geom.Point2D;

import main.TWInfo;
import main.supers.GameItem;

public class AttackMeter extends GameChara_B {
	private final int MAX=1;
	public int amount;

	public AttackMeter() {
		this.position=new Point2D.Double(625,560);

	}

	@Override
	public void first() {
		this.amount=0;
	}

	@Override
	public GameItem draw(TWInfo tInfo) {
		/*
		tInfo.g.setColor(Color.BLUE);
		tInfo.g.fillRect((int)this.position.x, (int)this.position.y+TWFrame.title_bar_height, (int)(this.amount*25), 5);
		tInfo.g.setColor(Color.BLACK);
		tInfo.g.drawRect((int)this.position.x, (int)this.position.y+TWFrame.title_bar_height, (int)(this.MAX*25), 5);
		tInfo.g.drawLine((int)(this.position.x+this.MAX*25/3), (int)this.position.y+8+TWFrame.title_bar_height,
				(int)(this.position.x+this.MAX*25/3), (int)this.position.y-3+TWFrame.title_bar_height);
		tInfo.g.drawLine((int)(this.position.x+this.MAX*25/3*2), (int)this.position.y+8+TWFrame.title_bar_height,
				(int)(this.position.x+this.MAX*25/3*2), (int)this.position.y-3+TWFrame.title_bar_height);
		*/
		return this;
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
