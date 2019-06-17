package main.items_b;

import main.TWInfo;
import main.constant.KEY_STATE;

public class Player extends GameChara_B{
	private final int SPEED=300;

	@Override
	public void first() {
		this.setVisible(0, true);
	}

	@Override
	public void control(TWInfo tInfo) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void keyControl(TWInfo tInfo, int key, int action) {
		if(tInfo.keyState[KEY_STATE.RIGHT]) {
			this.position.x+=this.SPEED*tInfo.frameTime;
		}
		if(tInfo.keyState[KEY_STATE.LEFT]) {
			this.position.x-=this.SPEED*tInfo.frameTime;
		}
		if(tInfo.keyState[KEY_STATE.UP]) {
			this.position.y-=this.SPEED*tInfo.frameTime;
		}
		if(tInfo.keyState[KEY_STATE.DOWN]) {
			this.position.y+=this.SPEED*tInfo.frameTime;
		}

	}


}
