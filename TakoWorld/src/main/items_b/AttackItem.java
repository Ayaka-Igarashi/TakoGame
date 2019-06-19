package main.items_b;

import java.util.Random;

import main.TWInfo;

public class AttackItem extends GameChara_B {
	private Random random = new Random();
	private long lastJudgeTime;
	private final long AppearTime=20000;
	private final int probability=20;//出現確率

	@Override
	public void first() {

	}

	public void first(TWInfo tInfo) {
		this.setVisible(0, false);
		this.position.x = 100;
		this.position.y = 200;
		this.lastJudgeTime = tInfo.currentTime;
	}

	@Override
	public void control(TWInfo tInfo) {
		if (tInfo.currentTime - this.lastJudgeTime > 1000) {
			if (this.imgList.get(0).visible == false) {
				int randomValue = random.nextInt(100);
				//System.out.println(randomValue);
				if (randomValue < this.probability) {
					this.setVisible(0, true);
					this.position.x=random.nextInt(700)+50;
					this.position.y=random.nextInt(300)+200;
				}
				this.lastJudgeTime = tInfo.currentTime;
			}else if(this.imgList.get(0).visible == true) {
				if(tInfo.currentTime-this.lastJudgeTime>this.AppearTime) {
					this.setVisible(0, false);
				}
			}


		}
	}

	@Override
	public void keyControl(TWInfo tInfo, int key, int action) {
		// TODO 自動生成されたメソッド・スタブ
	}

}
