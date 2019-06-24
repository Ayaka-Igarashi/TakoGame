package main.shot;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import main.TWFrame;
import main.TWInfo;
import main.functions.Vector;
import main.items_b.GameChara_B;
import main.stage.Stage;
import main.supers.GameItem;

public class BulletChara extends GameChara_B{
	public BulletMover mover =null;
	protected long starttime;
	public Vector vector=new Vector();

	public BufferedImage img;
	public boolean visible;


	@Override
	public GameItem setImage(BufferedImage img) {
		this.img=img;
		this.center.x=img.getWidth()/2;
		this.center.y=img.getHeight()/2;
		return this;
	}


	public BulletChara() {
		this.visible=false;
		this.size=12;
	}


	public GameItem draw(TWInfo tInfo,Stage stage,boolean isMenuTime) {
		if(this.mover!=null) {
			if(isMenuTime==false) {//メニュ―画面時は動かないようにする
				this.mover.move(tInfo,stage, this);
			}

		}

		if(this.img==null)return this;
		if(this.visible==false)return this;
		AffineTransform oldtr=tInfo.g.getTransform();
		tInfo.g.translate(0, TWFrame.title_bar_height);
		tInfo.g.rotate(0,0,0);
		tInfo.g.drawImage(this.img,
				(int)this.position.x,
				(int)this.position.y,
				null);
		tInfo.g.setTransform(oldtr);
		return this;
	}

	public void setVisible(TWInfo tInfo,boolean b) {
		this.visible=b;
		if(b==true) {
			this.starttime=tInfo.currentTime;
		}
	}

	public long getStartTime() {
		return this.starttime;
	}


	@Override
	public void first() {
		// TODO 自動生成されたメソッド・スタブ

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