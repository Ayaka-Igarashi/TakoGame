package main.items_b;

import java.util.Random;

import main.TWInfo;

public class AttackItem extends GameChara_B {
	private Random random = new Random();
	private long lastJudgeTime;
	private final long AppearTime=3000;//出現時間
	private final int probability=40;//出現確率


	public AttackItem() {
		this.size=50;
	}

	@Override
	public void first() {

	}

	public void first(TWInfo tInfo) {
		this.setVisible(0, false);
		this.position.x = 100;
		this.position.y = 200;
		this.lastJudgeTime = tInfo.currentTime;

		this.menuTime=0;
	}

	@Override
	public void control(TWInfo tInfo) {
		if (tInfo.currentTime - this.lastJudgeTime -this.menuTime> 1000) {
			if (this.imgList.get(0).visible == false) {
				int randomValue = random.nextInt(100);
				//System.out.println(randomValue);
				if (randomValue < this.probability) {
					this.setVisible(0, true);
					this.position.x=random.nextInt(700)+50;
					this.position.y=random.nextInt(300)+200;
				}
				this.lastJudgeTime = tInfo.currentTime;
				this.menuTime=0;
			}else if(this.imgList.get(0).visible == true) {
				if(tInfo.currentTime-this.lastJudgeTime-this.menuTime>this.AppearTime) {
					this.setVisible(0, false);
					this.lastJudgeTime = tInfo.currentTime;
					this.menuTime=0;
				}
			}
		}
	}

	@Override
	public void keyControl(TWInfo tInfo, int key, int action) {
		// TODO 自動生成されたメソッド・スタブ
	}

}
