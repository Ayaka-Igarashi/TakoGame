package main.items_b;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.geom.Point2D;

import main.TWFrame;
import main.TWInfo;
import main.constant.KEY_STATE;
import main.supers.GameItem;

public class Player extends GameChara_B{
	private int speed=300;
	public int life=4;//残機
	private int attackPoint;//攻撃ゲージ
	public boolean isInvincible;
	private long invincibleStop;

	public AttackAnim attackAnim=new AttackAnim(50);
	public SpAttackAnim spAttackAnim =new SpAttackAnim(1000);

	private AttackMeter attackMeter=new AttackMeter();
	private PlayerLife lifeMeter=new PlayerLife();

	public Player() {
		this.size=8;
	}

	@Override
	public void first() {
		this.setVisible(0, true);
		this.setVisible(1, false);
		this.setVisible(2, false);
		this.position=new Point2D.Double(400, 650);
		this.life=4;
		this.attackPoint=0;
		this.isInvincible=false;
		this.invincibleStop=0;

		this.attackAnim.first();
		this.spAttackAnim.first();

		this.attackMeter.first();
		this.lifeMeter.first();
	}

	//スタートで入ってくるモーション
	public void enter(TWInfo tInfo,int entrySpeed,long invincibleTime) {
		this.position.y-=entrySpeed*tInfo.frameTime;
		this.isInvincible=true;
		this.invincibleStop=tInfo.currentTime_withoutMenu+invincibleTime;
	}

	@Override
	public void control(TWInfo tInfo) {
		if(this.attackAnim.isAnim==false) {
			this.attackAnim.position.x=this.position.x;
			this.attackAnim.position.y=this.position.y-150;
		}
		if(tInfo.currentTime_withoutMenu>=this.invincibleStop) {
			this.isInvincible=false;
		}
		this.setVisible(0, true);
		this.setVisible(1, false);
		this.setVisible(2, false);
	}

	@Override
	public void keyControl(TWInfo tInfo, int key, int action) {

		if(tInfo.keyState[KEY_STATE.SHIFT]&&tInfo.keyReleased[KEY_STATE.SHIFT]) {
			this.speed=150;
			tInfo.keyReleased[KEY_STATE.SHIFT]=false;
		}else if(tInfo.keyState[KEY_STATE.SHIFT]==false&&tInfo.keyReleased[KEY_STATE.SHIFT]==false) {
			this.speed=300;
			tInfo.keyReleased[KEY_STATE.SHIFT]=true;
		}


		if(tInfo.keyState[KEY_STATE.RIGHT]) {
			this.setVisible(0, false);
			this.setVisible(1, false);
			this.setVisible(2, true);

			if(this.position.x+this.center.x<800) {
				this.position.x+=this.speed*tInfo.frameTime;
			}
		}
		if(tInfo.keyState[KEY_STATE.LEFT]) {
			this.setVisible(0, false);
			this.setVisible(1, true);
			this.setVisible(2, false);

			if(this.position.x-this.center.x>0) {
				this.position.x-=this.speed*tInfo.frameTime;
			}
		}
		if(tInfo.keyState[KEY_STATE.UP]) {
			if(this.position.y-this.center.y>0) {
				this.position.y-=this.speed*tInfo.frameTime;
			}
		}
		if(tInfo.keyState[KEY_STATE.DOWN]) {
			if(this.position.y+this.center.y<600) {
				this.position.y+=this.speed*tInfo.frameTime;
			}
		}
		if(tInfo.keyState[KEY_STATE.Z]&&tInfo.keyReleased[KEY_STATE.Z]==true) {
			this.attackAnim.start(tInfo);
			tInfo.keyReleased[KEY_STATE.Z]=false;
		}else if(tInfo.keyState[KEY_STATE.Z]==false&&tInfo.keyReleased[KEY_STATE.Z]==false) {
			tInfo.keyReleased[KEY_STATE.Z]=true;//キーが放された状態にする
		}
		if(tInfo.keyState[KEY_STATE.A]&&tInfo.keyReleased[KEY_STATE.A]==true&&this.attackPoint>=2) {
			this.spAttackAnim.start(tInfo);
			this.attackPoint-=2;
			this.attackMeter.amount=this.attackPoint;
			tInfo.keyReleased[KEY_STATE.A]=false;
		}else if(tInfo.keyState[KEY_STATE.A]==false&&tInfo.keyReleased[KEY_STATE.A]==false) {
			tInfo.keyReleased[KEY_STATE.A]=true;//キーが放された状態にする
		}

	}

	@Override
	public GameItem draw(TWInfo tInfo) {
		this.attackAnim.draw(tInfo);
		this.spAttackAnim.draw(tInfo);
		this.attackMeter.draw(tInfo);
		this.lifeMeter.draw(tInfo);
		super.draw(tInfo);
		tInfo.g.setColor(new Color(0, 20, 200, 200));
		tInfo.g.fillOval((int)(this.position.x)-(int)this.size, (int)(this.position.y)-(int)this.size+TWFrame.title_bar_height,
				(int)this.size*2, (int)this.size*2);
		tInfo.g.setColor(Color.BLACK);
		return this;
	}



	@Override
	public void drawOne(TWInfo tInfo, int idx) {
		float alpha=1.0f;
		if(this.isInvincible==true) {
			alpha=0.6f;
			if((this.invincibleStop-tInfo.currentTime_withoutMenu)%130<30) {
				alpha=0.4f;
			}
		}
		AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		tInfo.g.setComposite(ac);
		super.drawOne(tInfo, idx);
		ac=AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
		tInfo.g.setComposite(ac);
	}


	//当たった時の処理
	public void hitBoss() {
		if(this.life>0) {
			this.life-=1;
			this.lifeMeter.life=this.life;
			if(this.life>0) {
				this.position.x=400;
				this.position.y=650;
			}
		}
	}

	//アイテム取得時の処理
	public void hitItem() {
		if(this.attackPoint<6) {
			this.attackPoint+=1;
			this.attackMeter.amount=this.attackPoint;
		}
	}



}
