package main.items_b;

import java.awt.geom.Point2D;

import main.TWInfo;

public class Takoyaki extends GameChara_B {
	private int life;
	public boolean isAlive;


	public Takoyaki() {
		this.size=40;
	}

	@Override
	public void first() {
		this.life=100;
		this.isAlive=true;
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

	public void hitAttack() {
		if(this.life>0) {
			this.life-=10;
			System.out.println(this.life);
			//SoundBox.singleton.playClip(MUSIC_NUM.HIT);
		}
		if(this.life<=0) {
			this.setVisible(0, false);
			this.isAlive=false;
		}

	}

}
