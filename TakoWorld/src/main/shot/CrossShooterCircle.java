package main.shot;

import java.awt.geom.Point2D.Double;

import main.TWInfo;
import main.functions.Vector;
import main.stage.Stage;
import main.stage.Stage1;

public class CrossShooterCircle extends Shooter {
	private Vector v = new Vector();

	@Override
	public void shoot(TWInfo tInfo, Stage stage, Double position) {
		double radius=15.0;//間隔
		double r = radius / 180.0 * Math.PI;
		this.v.x = Math.tan(r);//35.26
		this.v.y = 200.0;
		for (int i = 0; i < 36; i++) {
			BulletChara bullet = stage.searchBullet();
			if (bullet != null) {
				bullet.mover = AccelMover_s.singleton;
				bullet.position.x = position.x;
				bullet.position.y = position.y;
				bullet.vector.x = this.v.x;
				bullet.vector.y = this.v.y;
				bullet.setImage(stage.getBulletImage(Stage1.BLUE_BULLET));
				bullet.setVisible(tInfo, true);
				this.v.rotateVector(r);
			}

		}

	}

	public static CrossShooterCircle singleton = new CrossShooterCircle();
}
