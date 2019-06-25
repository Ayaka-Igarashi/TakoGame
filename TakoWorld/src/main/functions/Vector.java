package main.functions;

import java.awt.geom.Point2D;

public class Vector {
	public double x;
	public double y;

	public static int distance(Point2D.Double a, Point2D.Double b) {
		return (int) Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
	}

	//回転（原点?からradianだけ回転）
	public Vector rotateVector(double radian) {
		double ox = -Math.sin(radian) * this.y + Math.cos(radian) * this.x;
		double oy = Math.cos(radian) * this.y + Math.sin(radian) * this.x;
		this.x = ox;
		this.y = oy;
		return this;
	}

}
