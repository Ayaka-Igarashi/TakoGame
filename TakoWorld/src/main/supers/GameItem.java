package main.supers;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.ImageState;
import main.TWFrame;
import main.TWInfo;

//背景とかキャラ
public abstract class GameItem {
	private ArrayList<ImageState> imgList=new ArrayList<ImageState>();

	public GameItem setImage(BufferedImage img) {
		this.imgList.add(new ImageState(img,new Point2D.Double(0, 0),false));
		return this;
	}

	public BufferedImage getImage(int idx) {
		return this.imgList.get(idx).img;
	}

	protected GameItem setVisible(int idx,boolean visible) {
		if(this.imgList.size()>idx) {
			this.imgList.get(idx).visible=visible;
		}
		return this;
	}

	protected GameItem setPosition(int idx,Point2D.Double position) {
		if(this.imgList.size()>idx) {
			this.imgList.get(idx).position=position;
		}
		return this;
	}

	//文字を線画する
	public void drawStr(TWInfo tInfo,String str,int x,int y) {
		tInfo.g.drawString(str,x,y+TWFrame.title_bar_height);
		return;
	}

	//1つの画像を線画する
	public void drawOne(TWInfo tInfo,int idx){
		if(this.imgList.get(idx).visible==false)return;
		//変形は今のところしない
		AffineTransform oldtr=tInfo.g.getTransform();
		tInfo.g.translate(0, TWFrame.title_bar_height);
		tInfo.g.rotate(0,0,0);
		tInfo.g.drawImage(this.imgList.get(idx).img,//.getScaledInstance(800, 600, Image.SCALE_SMOOTH)
				(int)this.imgList.get(idx).position.x,
				(int)this.imgList.get(idx).position.y,
				null);
		tInfo.g.setTransform(oldtr);
		return;
	}

	//全体を線画する
	public GameItem draw(TWInfo tInfo) {
		int imgNum=this.imgList.size();
		for(int i=0;i<imgNum;i++) {
			this.drawOne(tInfo, i);
		}
		return this;
	}
	//初期の画像の配置
	public abstract void first();

	public abstract void control(TWInfo tInfo);

	public abstract void keyControl(TWInfo tInfo,int key,int action);


}
