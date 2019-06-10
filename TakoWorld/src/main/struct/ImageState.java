package main.struct;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;

//画像の状態を格納
public class ImageState {
	public BufferedImage img;
	public Point2D.Double position;
	public boolean visible;
	public ImageState(BufferedImage img, Double position, boolean visible) {
		this.img = img;
		this.position = position;
		this.visible = visible;
	}


}
