package main.items_b;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import main.TWInfo;
import main.pattern.Pattern;
import main.shot.BasicShooter;
import main.stage.Stage;
import main.supers.GameItem;

public class Takoyaki extends GameChara_B {
	private final int MAX_LIFE=100;
	private int life;
	public boolean isAlive;

	private EnemyLife lifeMeter =new EnemyLife(this.MAX_LIFE);

	private ArrayList<Pattern> patternList=new ArrayList<Pattern>();
	private Pattern curpat;


	public Takoyaki() {
		this.size=25;

		this.patternList.add(new PatternT1());
		this.curpat=this.patternList.get(0);
		this.patternlist_addlast(new PatternBasicShoot(20000));
	}

	//最後の要素と連結して追加
	void patternlist_addlast(Pattern pt) {
		int s=this.patternList.size();
		this.patternList.get(s-1).setNext(pt);
		this.patternList.add(pt);
	}

	@Override
	public void first() {
		this.life=this.MAX_LIFE;
		this.isAlive=true;
		this.setVisible(0, true);
		this.position=new Point2D.Double(400, 50);

		this.lifeMeter.first();
		this.lifeMeter.position.x=this.position.x-this.center.x;
		this.lifeMeter.position.y=this.position.y-50;

		this.curpat=this.patternList.get(0);
	}


	public GameItem draw(TWInfo tInfo,Stage stage) {
		this.lifeMeter.draw(tInfo);

		if(this.curpat==null) return super.draw(tInfo);

		if(this.curpat.isFinished(tInfo)==false) {
			if(this.isMenuTime==false) {
				this.curpat.move(tInfo, stage);
			}
		}else {
			this.curpat=curpat.getNext();
			if(this.curpat!=null)this.curpat.start(tInfo);
		}

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

	public void hitAttack(int num) {
		if(this.life>0) {
			this.life-=num;
			this.lifeMeter.life=this.life;
		}
		if(this.life<=0) {
			this.setVisible(0, false);
			this.isAlive=false;
		}

	}


	////////////////////PATTERN///////////////
	class PatternT1 extends Pattern{

		@Override
		public boolean isFinished(TWInfo tInfo) {
			if(Takoyaki.this.position.y>100) return true;
			return false;
		}

		@Override
		public void move(TWInfo tInfo, Stage stage) {
			Takoyaki.this.position.y+=120*tInfo.frameTime;

		}

	}

	class PatternBasicShoot extends Pattern{
		private long lastShooting=0;

		public PatternBasicShoot(long l) {
			this.limit=l;
		}

		@Override
		public boolean isFinished(TWInfo tInfo) {
			if(tInfo.currentTime-this.starttime>this.limit) {
				return true;
			}
			return false;
		}

		@Override
		public void move(TWInfo tInfo, Stage stage) {

			if(tInfo.currentTime-this.lastShooting-Takoyaki.this.menuTime>600) {
				BasicShooter.singleton.shoot(tInfo, stage);
				this.lastShooting=tInfo.currentTime;
				Takoyaki.this.menuTime=0;
			}

		}

	}


}
