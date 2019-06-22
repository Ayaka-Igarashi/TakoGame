package main.stage;

import java.io.IOException;

import main.TWInfo;
import main.items_b.GameChara_B;

public abstract class Stage {
	private double width=800;
	private double height=600;
	public boolean IsReStart;

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
	//public abstract ArrayList<BulletChara> getBullets_E();

	//自機の弾データを取得する
	//public abstract ArrayList<BulletChara> getBullets_J();

	//弾の画像を取得する
	//public abstract BufferedImage getBulletImage(int type);
/*
	//空いてる弾を探す
	protected int searchidx=0;
	public BulletChara searchBullet() {
		ArrayList<BulletChara>bullets_e=this.getBullets_E();
		int m=bullets_e.size();
		//空き弾を探す
		for(;this.searchidx<m;this.searchidx++) {
			if(bullets_e.get(this.searchidx).visible==false) {
				return bullets_e.get(this.searchidx);
			}
		}
		//空きがないときはnullを返して発射キャンセル
		this.searchidx=0;
		return null;
	}
*/
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







	//当たり判定
	//public abstract boolean hitTestAll(GraphicsInfo gInfo);

}
