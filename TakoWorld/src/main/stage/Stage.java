package main.stage;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import main.TWInfo;
import main.functions.Vector;
import main.items_b.GameChara_B;
import main.shot.BulletChara;

public abstract class Stage {
	protected boolean isMenuTime;
	protected long menuTime;

	private double width=800;
	private double height=600;
	public boolean IsReStart;

	public int nextScene;

	public abstract void first(TWInfo tInfo);

	public abstract GameChara_B getPlayer();
	public abstract void loadMedia() throws IOException;
	public abstract GameChara_B getEnemy();

	public abstract void control(TWInfo tInfo);
	public abstract void draw(TWInfo tInfo);
	public abstract void init(TWInfo tInfo);

	public abstract boolean hitBoss();
	public abstract boolean hitItem();
	public abstract boolean hitAttack();
	public abstract boolean hitBullet(TWInfo tInfo);

	public boolean hitTest(GameChara_B A,GameChara_B B) {
		return Vector.distance(A.position, B.position)<=A.size+B.size;
	}

	//プレイヤー生きてるか
	public abstract boolean isPlayerAlive();
	//ボスが生きているか
	public abstract boolean isBossLiving();

	public abstract void setMenuTime(long openTime);
	public abstract void setIsMenuTime(boolean isMenuTime);

	//スタート時の動き
	public abstract void startMotion(TWInfo tInfo);
	public abstract void reStart(TWInfo tInfo);//プレイヤーの残機が減った時



	//敵の弾のデータを取得する
	public abstract ArrayList<BulletChara> getBullets();


	//弾の画像を取得する
	public abstract BufferedImage getBulletImage(int type);

	public abstract void removeAllBullets();

	//空いてる弾を探す
	protected int searchidx=0;
	public BulletChara searchBullet() {
		ArrayList<BulletChara>bullets=this.getBullets();
		int m=bullets.size();
		//空き弾を探す
		for(;this.searchidx<m;this.searchidx++) {
			if(bullets.get(this.searchidx).visible==false) {
				return bullets.get(this.searchidx);
			}
		}
		//空きがないときはnullを返して発射キャンセル
		this.searchidx=0;
		return null;
	}

	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}




}
