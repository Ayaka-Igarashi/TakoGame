package main.items_b;

import java.awt.geom.Point2D;

import main.TWInfo;
import main.constant.KEY_STATE;

public class Player extends GameChara_B{
	private int speed=300;
	private boolean attackAnim;

	@Override
	public void first() {
		this.setVisible(0, true);
		this.position=new Point2D.Double(400, 500);
		this.attackAnim=false;
	}

	@Override
	public void control(TWInfo tInfo) {
		// TODO 自動生成されたメソッド・スタブ

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
			this.position.x+=this.speed*tInfo.frameTime;
		}
		if(tInfo.keyState[KEY_STATE.LEFT]) {
			this.position.x-=this.speed*tInfo.frameTime;
		}
		if(tInfo.keyState[KEY_STATE.UP]) {
			this.position.y-=this.speed*tInfo.frameTime;
		}
		if(tInfo.keyState[KEY_STATE.DOWN]) {
			this.position.y+=this.speed*tInfo.frameTime;
		}
		if(tInfo.keyState[KEY_STATE.Z]) {
			this.attackAnim=true;
		}

	}


}
