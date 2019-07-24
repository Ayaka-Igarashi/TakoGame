package main.items_b;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import main.TWFrame;
import main.TWInfo;
import main.struct.ImageState;
import main.supers.GameItem;

public class PlayerLife extends GameChara_B {
	private int MAX_LIFE = 4;
	public int life;

	public PlayerLife() {
		this.position = new Point2D.Double(684, 528);
	}

	@Override
	public GameItem setImage(BufferedImage img) {
		this.imgList.add(new ImageState(img,new Point2D.Double(0, 0),false));
		return this;
	}

	@Override
	public void first() {
		this.life = this.MAX_LIFE;
		for(int i=0;i<4;i++) {
			this.setVisible(i, true);
		}
	}

	@Override
	public GameItem draw(TWInfo tInfo) {
		/*
		tInfo.g.setColor(Color.BLUE);
		for (int i = 0; i < this.life - 1; i++) {
			tInfo.g.fillOval((int) (this.position.x + i * 35), (int) this.position.y + TWFrame.title_bar_height, 20,
					20);
		}
		tInfo.g.setColor(Color.BLACK);
		for (int i = 0; i < this.MAX_LIFE - 1; i++) {
			tInfo.g.drawOval((int) (this.position.x + i * 35), (int) this.position.y + TWFrame.title_bar_height, 20,
					20);
		}
		*/
		for(int i=0;i<this.life;i++) {
			this.drawOne(tInfo,i);
		}
		return this;
	}

	//1つの画像を線画する
	@Override
	public void drawOne(TWInfo tInfo, int idx) {
		if (this.imgList.get(idx) == null)
			return;
		if (this.imgList.get(idx).visible == false)
			return;
		//変形は今のところしない
		AffineTransform oldtr = tInfo.g.getTransform();
		tInfo.g.translate(0, TWFrame.title_bar_height);
		tInfo.g.rotate(0, 0, 0);
		tInfo.g.drawImage(this.imgList.get(idx).img,
				(int) this.imgList.get(idx).position.x,
				(int) this.imgList.get(idx).position.y,
				null);
		tInfo.g.setTransform(oldtr);
		return;
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
