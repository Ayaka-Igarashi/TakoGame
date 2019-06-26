package main.shot;

import java.awt.geom.Point2D;

import main.TWInfo;
import main.functions.Vector;
import main.stage.Stage;
import main.stage.Stage1;

public class CrossShooter extends Shooter {
	private Vector v = new Vector();
	@Override
	public void shoot(TWInfo tInfo, Stage stage,Point2D.Double position) {
		double r = 120.0 / 180.0 * Math.PI;
		this.v.x = 200.0;
		this.v.y = 120.0;
		for(int i=0; i<2; i++){
			BulletChara bullet = stage.searchBullet();
			if(bullet == null) return;
			bullet.mover = StraightMover.singleton;
			bullet.position.x = position.x;
			bullet.position.y = position.y;
			bullet.vector.x = this.v.x;
			bullet.vector.y = this.v.y;
			bullet.setImage(stage.getBulletImage(Stage1.STAR_BULLET));
			bullet.setVisible(tInfo, true);
			this.v.rotateVector(r);

	}}
		public static CrossShooter singleton = new CrossShooter();
}
