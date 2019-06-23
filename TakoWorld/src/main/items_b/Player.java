package main.items_b;

import java.awt.geom.Point2D;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.supers.GameItem;

public class Player extends GameChara_B{
	private int speed=300;
	public int life=4;//残機
	private int attackPoint;//攻撃ゲージ

	public AnimItem attackAnim=new AnimItem();
	private AttackMeter attackMeter=new AttackMeter();
	private PlayerLife lifeMeter=new PlayerLife();

	public Player() {
		this.size=20;
	}

	@Override
	public void first() {
		this.setVisible(0, true);
		this.position=new Point2D.Double(400, 650);
		this.life=4;
		this.attackPoint=0;
		this.attackAnim.first();
		this.attackMeter.first();
		this.lifeMeter.first();
	}

	//スタートで入ってくるモーション
	public void enter(TWInfo tInfo,int entrySpeed) {
		this.position.y-=entrySpeed*tInfo.frameTime;
	}

	@Override
	public void control(TWInfo tInfo) {
		if(this.attackAnim.isAnim==false) {
			this.attackAnim.position.x=this.position.x;
			this.attackAnim.position.y=this.position.y-80;
		}
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
			if(this.position.x+this.center.x<800) {
				this.position.x+=this.speed*tInfo.frameTime;
			}
		}
		if(tInfo.keyState[KEY_STATE.LEFT]) {
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
		if(tInfo.keyState[KEY_STATE.Z]&tInfo.keyReleased[KEY_STATE.Z]==true) {
			this.attackAnim.start(tInfo);
			tInfo.keyReleased[KEY_STATE.Z]=false;
		}else if(tInfo.keyState[KEY_STATE.Z]==false&&tInfo.keyReleased[KEY_STATE.Z]==false) {
			tInfo.keyReleased[KEY_STATE.Z]=true;//キーが放された状態にする
		}

	}

	@Override
	public GameItem draw(TWInfo tInfo) {
		this.attackAnim.draw(tInfo);
		this.attackMeter.draw(tInfo);
		this.lifeMeter.draw(tInfo);
		return super.draw(tInfo);
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
			//System.out.println(this.attackMeter);
		}
	}


}
