package main.items_b;

import java.awt.geom.Point2D;

import main.TWInfo;
import main.supers.GameItem;

public class Takoyaki extends GameChara_B {
	private final int MAX_LIFE=100;
	private int life;
	public boolean isAlive;

	private EnemyLife lifeMeter =new EnemyLife(this.MAX_LIFE);


	public Takoyaki() {
		this.size=25;
	}

	@Override
	public void first() {
		this.life=this.MAX_LIFE;
		this.isAlive=true;
		this.setVisible(0, true);
		this.position=new Point2D.Double(400, 100);

		this.lifeMeter.first();
		this.lifeMeter.position.x=this.position.x-this.center.x;
		this.lifeMeter.position.y=this.position.y-50;
	}

	@Override
	public GameItem draw(TWInfo tInfo) {
		this.lifeMeter.draw(tInfo);
		return super.draw(tInfo);
	}

	@Override
	public void control(TWInfo tInfo) {
		this.lifeMeter.position.x=this.position.x-this.center.x;
		this.lifeMeter.position.y=this.position.y-50;
	}

	@Override
	public void keyControl(TWInfo tInfo, int key, int action) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void hitAttack() {
		if(this.life>0) {
			this.life-=10;
			this.lifeMeter.life=this.life;
			//System.out.println(this.life);
		}
		if(this.life<=0) {
			this.setVisible(0, false);
			this.isAlive=false;
		}

	}

}
