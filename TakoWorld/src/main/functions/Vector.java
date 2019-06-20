package main.functions;

import java.awt.geom.Point2D;

public class Vector {

	public static int distance(Point2D.Double a,Point2D.Double b) {
		return (int)Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
	}
}
