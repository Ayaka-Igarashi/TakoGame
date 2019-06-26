package main.items_b;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import main.TWInfo;
import main.pattern.Pattern;
import main.shot.CrossShooter;
import main.shot.RollingShooter;
import main.shot.SplatterShooter;
import main.shot.TargetShooter;
import main.stage.Stage;
import main.supers.GameItem;

public class Takoyaki extends GameChara_B {
	private final int MAX_LIFE = 100;
	private double life;
	private long lastDecrese;
	public boolean isAlive;

	private EnemyLife lifeMeter = new EnemyLife(this.MAX_LIFE);

	private ArrayList<Pattern> patternList = new ArrayList<Pattern>();
	private Pattern curpat;

	public Takoyaki() {
		this.size = 30;

		this.patternList.add(new PatternT1());
		this.curpat = this.patternList.get(0);
		this.patternlist_addlast(new PatternT2(20000));
		this.patternlist_addlast(new PatternT3(10000));
		this.patternList.get(2).setNext(this.patternList.get(1));
	}

	//最後の要素と連結して追加
	void patternlist_addlast(Pattern pt) {
		int s = this.patternList.size();
		this.patternList.get(s - 1).setNext(pt);
		this.patternList.add(pt);
	}

	@Override
	public void first() {
		this.life = this.MAX_LIFE;
		this.isAlive = true;
		this.setVisible(0, true);
		this.setVisible(1, false);
		this.setVisible(2, false);
		this.position = new Point2D.Double(400, 50);

		this.lifeMeter.first();
		this.lifeMeter.position.x = this.position.x - this.center.x;
		this.lifeMeter.position.y = this.position.y - 50;

		this.curpat = this.patternList.get(0);
	}

	public GameItem draw(TWInfo tInfo, Stage stage) {
		this.lifeMeter.draw(tInfo);
		if (this.isMenuTime == false) {
			this.decreseLife(tInfo, 0.5);

			if (this.life > 0) {
				if (this.curpat != null) {
					if (this.curpat.isFinished(tInfo) == false) {
							this.curpat.move(tInfo, stage);
					} else {
						this.curpat = curpat.getNext();
						if (this.curpat != null)
							this.curpat.start(tInfo);
					}
				}
			}
		}


		super.draw(tInfo);
		/*
		tInfo.g.setColor(Color.CYAN);
		tInfo.g.fillOval((int)(this.position.x)-(int)this.size, (int)(this.position.y)-(int)this.size+TWFrame.title_bar_height,
				(int)this.size*2, (int)this.size*2);
		tInfo.g.setColor(Color.BLACK);
		*/
		return this;
	}

	@Override
	public void control(TWInfo tInfo) {
		this.lifeMeter.position.x = this.position.x - this.center.x;
		this.lifeMeter.position.y = this.position.y - 80;
		if(this.imgList.get(0).visible==true&&this.life<=0) {
			this.setVisible(0, false);
			this.setVisible(1, true);
		}
	}

	@Override
	public void keyControl(TWInfo tInfo, int key, int action) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void hitAttack(int num) {
		if (this.life > 0) {
			this.life -= num;
			this.lifeMeter.life = this.life;
		}else if (this.life <= 0) {
			this.setVisible(0, false);
			this.setVisible(1, false);
			this.setVisible(2, false);
			this.isAlive = false;
		}

	}

	public void decreseLife(TWInfo tInfo,double num) {

		if(tInfo.currentTime_withoutMenu-this.lastDecrese>500) {
			this.life-=num;
			this.lifeMeter.life=this.life;
			this.lastDecrese=tInfo.currentTime_withoutMenu;
		}

	}


	////////////////////PATTERN///////////////
	class PatternT1 extends Pattern {

		@Override
		public boolean isFinished(TWInfo tInfo) {
			if (Takoyaki.this.position.y > 100)
				return true;
			return false;
		}

		@Override
		public void move(TWInfo tInfo, Stage stage) {
			Takoyaki.this.position.y += 120 * tInfo.frameTime;

		}

	}

	class PatternT2 extends Pattern {
		private long lastShooting1 = 0;
		private long lastShooting2 = 0;

		public PatternT2(long l) {
			this.limit = l;
		}

		@Override
		public boolean isFinished(TWInfo tInfo) {
			if (tInfo.currentTime_withoutMenu - this.starttime > this.limit) {
				return true;
			}
			return false;
		}

		@Override
		public void move(TWInfo tInfo, Stage stage) {

			if (tInfo.currentTime_withoutMenu - this.lastShooting1  > 100) {
				SplatterShooter.singleton.shoot(tInfo, stage, Takoyaki.this.position);
				CrossShooter.singleton.shoot(tInfo, stage, Takoyaki.this.position);

				this.lastShooting1 = tInfo.currentTime_withoutMenu;
			}
			if (tInfo.currentTime_withoutMenu - this.lastShooting2 > 600) {
				TargetShooter.singleton.shoot(tInfo, stage, Takoyaki.this.position);
				this.lastShooting2 = tInfo.currentTime_withoutMenu;
			}

		}

	}

	class PatternT3 extends Pattern {
		private long lastShooting1 = 0;
		private long lastShooting2 = 0;

		public PatternT3(long l) {
			this.limit = l;
		}

		@Override
		public boolean isFinished(TWInfo tInfo) {
			if (tInfo.currentTime_withoutMenu - this.starttime > this.limit) {
				return true;
			}
			return false;
		}

		@Override
		public void move(TWInfo tInfo, Stage stage) {

			if (tInfo.currentTime_withoutMenu - this.lastShooting1  > 100) {
				SplatterShooter.singleton.shoot(tInfo, stage, Takoyaki.this.position);
				RollingShooter.singleton.shoot(tInfo, stage, Takoyaki.this.position);
				CrossShooter.singleton.shoot(tInfo, stage, Takoyaki.this.position);

				this.lastShooting1 = tInfo.currentTime_withoutMenu;
			}
			if (tInfo.currentTime_withoutMenu - this.lastShooting2  > 600) {
				TargetShooter.singleton.shoot(tInfo, stage, Takoyaki.this.position);
				this.lastShooting2 = tInfo.currentTime_withoutMenu;
			}

		}

	}

}
