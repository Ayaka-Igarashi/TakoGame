package main.items_b;

import java.awt.Color;

import main.TWFrame;
import main.TWInfo;
import main.supers.GameItem;

public class EnemyLife extends GameChara_B {
	private final int MAX_LIFE;
	public double life;

	public EnemyLife(int life) {
		this.MAX_LIFE=life;
	}

	@Override
	public void first() {
		this.life=this.MAX_LIFE;
	}

	@Override
	public GameItem draw(TWInfo tInfo) {
		tInfo.g.setColor(Color.RED);
		tInfo.g.fillRect((int)this.position.x, (int)this.position.y+TWFrame.title_bar_height, (int)(this.life*1.5), 5);
		tInfo.g.setColor(Color.BLACK);
		tInfo.g.drawRect((int)this.position.x, (int)this.position.y+TWFrame.title_bar_height, (int)(this.MAX_LIFE*1.5), 5);

		return this;
	}

	@Override
	public void control(TWInfo tInfo) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void keyControl(TWInfo tInfo, int key, int action) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
