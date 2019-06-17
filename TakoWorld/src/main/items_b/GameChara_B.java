package main.items_b;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import main.TWFrame;
import main.TWInfo;
import main.struct.ImageState;
import main.supers.GameItem;

public abstract class GameChara_B extends GameItem{
	public Point2D.Double position=new Point2D.Double(100, 100);
	public Point2D.Double center =new Point2D.Double();
	public double angle=0.0;
	public double size;

	@Override
	public GameItem setImage(BufferedImage img) {

		this.imgList.add(new ImageState(img,this.position,false));
		this.center.x=img.getWidth()/2;
		this.center.y=img.getHeight()/2;
		return this;
	}

	@Override
	public void drawOne(TWInfo tInfo,int idx) {

		if(this.imgList.get(idx)==null)return;
		if(this.imgList.get(idx).visible==false)return;
		//
		AffineTransform oldtr=tInfo.g.getTransform();
		tInfo.g.translate(this.position.x, this.position.y+TWFrame.title_bar_height);
		tInfo.g.rotate(this.angle/180.0*Math.PI,0,0);
		tInfo.g.drawImage(this.imgList.get(idx).img, -(int)this.center.x, -(int)this.center.y,null);
		//変形復帰
		tInfo.g.setTransform(oldtr);
		return;
	}

}
