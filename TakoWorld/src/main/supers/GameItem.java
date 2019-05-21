package main.supers;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.TWInfo;

public class GameItem {
	protected ArrayList<BufferedImage> imgList=new ArrayList<BufferedImage>();
	public ArrayList<Point2D.Double> posList=new ArrayList<Point2D.Double>();
	public ArrayList<Boolean> visible=new ArrayList<Boolean>();

	public GameItem setImage(BufferedImage img) {
		this.imgList.add(img);
		this.posList.add(new Point2D.Double(0, 0));
		this.visible.add(false);//見えない状態
		return this;
	}

	public BufferedImage getImage(int idx) {
		return this.imgList.get(idx);
	}

	public GameItem setVisible(int idx,boolean visible) {
		this.visible.set(idx,visible);//代入している
		return this;
	}

	//1つの画像を線画する
	public void drawOne(TWInfo tInfo,int idx){
		if(this.visible.get(idx)==false)return;
		//変形は今のところしない
		//AffineTransform oldtr=tInfo.g.getTransform();
		//tInfo.g.translate(this.position.x, this.position.y);
		//tInfo.g.rotate(0,0,0);
		tInfo.g.drawImage(this.imgList.get(idx), (int)this.posList.get(idx).x, (int)this.posList.get(idx).y,null);
		//tInfo.g.setTransform(oldtr);
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

	public void control(TWInfo tInfo) {
		return;
	}

	public void keyControl(TWInfo tInfo) {
		return;
	}

}
