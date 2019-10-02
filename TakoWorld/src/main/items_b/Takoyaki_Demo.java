package main.items_b;

import java.awt.AlphaComposite;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import main.TWInfo;
import main.pattern.Pattern;
import main.shot.CircleShooter;
import main.shot.CrossShooter;
import main.shot.RollingShooter;
import main.shot.SplatterShooter;
import main.shot.TargetShooter;
import main.stage.Stage;
import main.supers.GameItem;

public class Takoyaki_Demo extends GameChara_B {
	private final int MAX_LIFE = 100;
	private double life;
	private long lastDecrese;

	private int remainLife;//残機的な
	public boolean isAlive;

	private boolean isInvincible;
	private long invincibleStop;

	private EnemyLife lifeMeter = new EnemyLife(this.MAX_LIFE);

	private ArrayList<Pattern> patternList = new ArrayList<Pattern>();
	private Pattern curpat;

	public Takoyaki_Demo() {
		this.size = 30;

		this.patternList.add(new PatternT1());
		this.curpat = this.patternList.get(0);
		this.patternlist_addlast(new PatternT2(12000));
		this.patternlist_addlast(new PatternT3(15000));
		this.patternlist_addlast(new PatternT4(30000));
		this.patternList.get(3).setNext(this.patternList.get(1));

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

		this.remainLife=0;
		this.isInvincible=false;

		this.lifeMeter.first();
		this.lifeMeter.position.x = this.position.x - this.center.x;
		this.lifeMeter.position.y = this.position.y - 50;

		this.curpat = this.patternList.get(0);
	}

	public GameItem draw(TWInfo tInfo, Stage stage) {
		this.lifeMeter.draw(tInfo);
		if (this.isMenuTime == false) {
			this.decreseLife(tInfo, 1.8);

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
		if((this.imgList.get(0).visible==true||this.imgList.get(2).visible==true)&&this.life<=0) {
			this.setVisible(0, false);
			this.setVisible(1, true);
			this.setVisible(2, false);
		}
		if(this.invincibleStop-tInfo.currentTime_withoutMenu<=0) {
			this.isInvincible=false;
		}
	}

	@Override
	public void keyControl(TWInfo tInfo, int key, int action) {
		// TODO 自動生成されたメソッド・スタブ

	}


	@Override
	public void drawOne(TWInfo tInfo, int idx) {
		float alpha=1.0f;
		if(this.isInvincible==true) {
			alpha=0.7f;
			if((this.invincibleStop-tInfo.currentTime_withoutMenu)%130<30) {
				alpha=0.3f;
			}
		}
		AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		tInfo.g.setComposite(ac);
		super.drawOne(tInfo, idx);
		ac=AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
		tInfo.g.setComposite(ac);
	}



	public void hitAttack(int num,TWInfo tInfo) {
		if(this.isInvincible==true)return;

		if (this.life > 0) {
			if(this.life-num<0) {
				this.life=0;
			}else {
				this.life -= num;
			}
			this.lifeMeter.life = this.life;
		}else if (this.life <= 0) {
			if(this.remainLife<=0) {
				this.setVisible(0, false);
				this.setVisible(1, false);
				this.setVisible(2, false);
				this.isAlive = false;
			}else {
				this.setVisible(0, false);
				this.setVisible(1, false);
				this.setVisible(2, true);
				this.remainLife-=1;
				this.life=this.MAX_LIFE;
				this.lifeMeter.life = this.life;
				this.isInvincible=true;
				this.invincibleStop=tInfo.currentTime_withoutMenu+2000;

				if(this.remainLife==0) {
					this.curpat=this.patternList.get(4);
					this.curpat.start(tInfo);
				}
			}


		}

	}

	public void decreseLife(TWInfo tInfo,double num) {
		this.life-=num*tInfo.frameTime;
		this.lifeMeter.life=this.life;
		this.lastDecrese=tInfo.currentTime_withoutMenu;
		/*
		if(tInfo.currentTime_withoutMenu-this.lastDecrese>100) {
			this.life-=num/10;
			this.lifeMeter.life=this.life;
			this.lastDecrese=tInfo.currentTime_withoutMenu;
		}*/

	}


	////////////////////PATTERN///////////////
	class PatternT1 extends Pattern {

		@Override
		public boolean isFinished(TWInfo tInfo) {
			if (Takoyaki_Demo.this.position.y > 100)
				return true;
			return false;
		}

		@Override
		public void move(TWInfo tInfo, Stage stage) {
			Takoyaki_Demo.this.position.y += 120 * tInfo.frameTime;

		}

	}

	class PatternT2 extends Pattern {
		private long lastShooting1 = 0;
		//private long lastShooting2 = 0;

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

			if (tInfo.currentTime_withoutMenu - this.lastShooting1  > 170) {//70
				SplatterShooter.singleton.shoot(tInfo, stage, Takoyaki_Demo.this.position,0);
				CrossShooter.singleton.shoot(tInfo, stage, Takoyaki_Demo.this.position,0);

				this.lastShooting1 = tInfo.currentTime_withoutMenu;
			}
			/*
			if (tInfo.currentTime_withoutMenu - this.lastShooting2 > 600) {
				this.lastShooting2 = tInfo.currentTime_withoutMenu;
			}
			*/

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

			if (tInfo.currentTime_withoutMenu - this.lastShooting1  > 150) {//100
				SplatterShooter.singleton.shoot(tInfo, stage, Takoyaki_Demo.this.position,0);
				CrossShooter.singleton.shoot(tInfo, stage, Takoyaki_Demo.this.position,0);

				this.lastShooting1 = tInfo.currentTime_withoutMenu;
			}
			if (tInfo.currentTime_withoutMenu - this.lastShooting2  > 800) {//600
				TargetShooter.singleton.shoot(tInfo, stage, Takoyaki_Demo.this.position,0);
				this.lastShooting2 = tInfo.currentTime_withoutMenu;
			}

		}

	}

	class PatternT4 extends Pattern {
		private long lastShooting1 = 0;
		private long lastShooting2 = 0;

		public PatternT4(long l) {
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

			if (tInfo.currentTime_withoutMenu - this.lastShooting1  > 200) {//100
				SplatterShooter.singleton.shoot(tInfo, stage, Takoyaki_Demo.this.position,0);
				RollingShooter.singleton.shoot(tInfo, stage, Takoyaki_Demo.this.position,0);
				CrossShooter.singleton.shoot(tInfo, stage, Takoyaki_Demo.this.position,0);

				this.lastShooting1 = tInfo.currentTime_withoutMenu;
			}
			if (tInfo.currentTime_withoutMenu - this.lastShooting2  > 800) {//600
				TargetShooter.singleton.shoot(tInfo, stage, Takoyaki_Demo.this.position,0);
				this.lastShooting2 = tInfo.currentTime_withoutMenu;
			}

		}

	}

	class PatternT5 extends Pattern {
		public PatternT5(long l) {
			this.limit = l;
		}

		@Override
		public boolean isFinished(TWInfo tInfo) {
			if (Takoyaki_Demo.this.position.y < 90) {
				return true;
			}
			return false;
		}

		@Override
		public void move(TWInfo tInfo, Stage stage) {
			if(tInfo.currentTime_withoutMenu-this.starttime>1000) {
				Takoyaki_Demo.this.position.y -= 30 * tInfo.frameTime;
			}
		}

	}

	class PatternT6 extends Pattern {
		private long lastShooting1 = 0;
		private long lastShooting2 = 0;
		private long lastShooting3 = 0;

		public PatternT6(long l) {
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

			if (tInfo.currentTime_withoutMenu - this.lastShooting1  > 200) {//100
				SplatterShooter.singleton.shoot(tInfo, stage, Takoyaki_Demo.this.position,0);

				this.lastShooting1 = tInfo.currentTime_withoutMenu;
			}
			if (tInfo.currentTime_withoutMenu - this.lastShooting2  > 600) {

				this.lastShooting2 = tInfo.currentTime_withoutMenu;
			}
			if (tInfo.currentTime_withoutMenu - this.lastShooting3  > 1200) {//1200
				CircleShooter.singleton.shoot(tInfo, stage, Takoyaki_Demo.this.position,24);
				this.lastShooting3 = tInfo.currentTime_withoutMenu;
			}

		}

	}

	class PatternT7 extends Pattern {
		private long lastShooting1 = 0;
		private long lastShooting2 = 0;
		private long lastShooting3 = 0;

		private boolean goleft=false;

		public PatternT7(long l) {
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
			if(this.goleft==true) {
				if(Takoyaki_Demo.this.position.x<700) {
					Takoyaki_Demo.this.position.x+=120*tInfo.frameTime;
				}else {
					this.goleft=false;
				}
			}else {
				if(Takoyaki_Demo.this.position.x>100) {
					Takoyaki_Demo.this.position.x-=120*tInfo.frameTime;
				}else {
					this.goleft=true;
				}
			}


			if (tInfo.currentTime_withoutMenu - this.lastShooting1  > 200) {//100
				SplatterShooter.singleton.shoot(tInfo, stage, Takoyaki_Demo.this.position,0);

				this.lastShooting1 = tInfo.currentTime_withoutMenu;
			}
			if (tInfo.currentTime_withoutMenu - this.lastShooting2  > 600) {

				this.lastShooting2 = tInfo.currentTime_withoutMenu;
			}
			if (tInfo.currentTime_withoutMenu - this.lastShooting3  > 1500) {//1200
				CircleShooter.singleton.shoot(tInfo, stage, Takoyaki_Demo.this.position,24);
				this.lastShooting3 = tInfo.currentTime_withoutMenu;
			}

		}

	}

}
