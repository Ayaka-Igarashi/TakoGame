package main.functions;

import java.awt.geom.Point2D;

public class Vector {
	public double x;
	public double y;
	public Vector() {
		this.x=0;
		this.y=0;
	}

	public static int distance(Point2D.Double a, Point2D.Double b) {
		return (int) Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
	}

	//引く
		public Vector subVector(Vector in) {
			this.x-=in.x;
			this.y-=in.y;
			return this;
		}
		//足す
		public Vector addVector(Vector in) {
			this.x+=in.x;
			this.y+=in.y;
			return this;
		}
	//回転（原点?からradianだけ回転）
	public Vector rotateVector(double radian) {
		double ox = -Math.sin(radian) * this.y + Math.cos(radian) * this.x;
		double oy = Math.cos(radian) * this.y + Math.sin(radian) * this.x;
		this.x = ox;
		this.y = oy;
		return this;
	}

	//長さを調べる(2乗)
		public double lengthSquare() {
			return this.x*this.x+this.y*this.y;
		}
	//正規化（長さ1のベクトルを求める）
		public Vector normalize() {
			double l=Math.sqrt(this.lengthSquare());
			this.x/=l;
			this.y/=l;
			return this;
		}

		//角度を求める
		public double angle() {
			return Math.atan2(this.y, this.x)-(Math.PI/2);
		}

}
