package main.items_b;

import java.util.Random;

import main.TWInfo;
import main.supers.GameItem;

public class AttackItem extends GameChara_B {
	private Random random = new Random();
	private long lastJudgeTime;
	private final long AppearTime=20000;//出現時間
	private final int probability=15;//出現確率


	public AttackItem() {
		this.size=30;
	}

	@Override
	public void first() {}

	public void first(TWInfo tInfo) {
		this.setVisible(0, false);
		this.position.x = -100;
		this.position.y = -100;
		this.lastJudgeTime = tInfo.currentTime_withoutMenu;

	}

	@Override
	public void control(TWInfo tInfo) {
		if (tInfo.currentTime_withoutMenu - this.lastJudgeTime > 1000) {
			if (this.imgList.get(0).visible == false) {
				int randomValue = random.nextInt(100);
				//System.out.println(randomValue);
				if (randomValue < this.probability) {
					this.setVisible(0, true);
					this.position.x=random.nextInt(700)+50;
					this.position.y=random.nextInt(300)+200;
				}
				this.lastJudgeTime = tInfo.currentTime_withoutMenu;
			}else if(this.imgList.get(0).visible == true) {
				if(tInfo.currentTime_withoutMenu-this.lastJudgeTime>this.AppearTime) {
					this.setVisible(0, false);
					this.position.x=-100;
					this.position.y=-100;
					this.lastJudgeTime = tInfo.currentTime_withoutMenu;
				}
			}
		}
	}

	@Override
	public GameItem draw(TWInfo tInfo) {
		super.draw(tInfo);
		/*
		tInfo.g.fillOval((int)(this.position.x)-(int)this.size, (int)(this.position.y)-(int)this.size+TWFrame.title_bar_height,
				(int)this.size*2, (int)this.size*2);
		*/
		return this;
	}

	@Override
	public void keyControl(TWInfo tInfo, int key, int action) {
		// TODO 自動生成されたメソッド・スタブ
	}

	//アイテムを取得
	public void got() {
		if(this.imgList.get(0).visible == true) {
			this.setVisible(0, false);
			this.position.x=-100;
			this.position.y=-100;
		}

	}

}
