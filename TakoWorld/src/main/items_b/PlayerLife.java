package main.items_b;

import java.awt.Color;
import java.awt.geom.Point2D;

import main.TWFrame;
import main.TWInfo;
import main.supers.GameItem;

public class PlayerLife extends GameChara_B {
	private int MAX_LIFE=4;
	public int life;

	public PlayerLife() {
		this.position=new Point2D.Double(684,528);
	}

	@Override
	public void first() {
		this.life=this.MAX_LIFE;
	}

	@Override
	public GameItem draw(TWInfo tInfo) {
		tInfo.g.setColor(Color.BLUE);
		for(int i=0;i<this.life-1;i++) {
			tInfo.g.fillOval((int)(this.position.x+i*35), (int)this.position.y+TWFrame.title_bar_height, 20, 20);
		}
		tInfo.g.setColor(Color.BLACK);
		for(int i=0;i<this.MAX_LIFE-1;i++) {
			tInfo.g.drawOval((int)(this.position.x+i*35), (int)this.position.y+TWFrame.title_bar_height, 20, 20);
		}
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
