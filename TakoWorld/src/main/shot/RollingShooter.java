package main.shot;

import java.awt.geom.Point2D.Double;

import main.TWInfo;
import main.stage.Stage;
import main.stage.Stage1;

public class RollingShooter extends Shooter {

	@Override
	public void shoot(TWInfo tInfo, Stage stage, Double position) {
		double r =Effect.linear(tInfo, 5000, 0.0, Math.PI * 2);
		BulletChara bullet = stage.searchBullet();
		if(bullet == null) return;
		bullet.mover = StraightMover.singleton;
		bullet.position.x = position.x;
		bullet.position.y = position.y;
		bullet.vector.x = 0;
		bullet.vector.y = 120;
		bullet.vector.rotateVector(-r);
		bullet.setImage(stage.getBulletImage(Stage1.BLUE_BULLET));
		bullet.setVisible(tInfo, true);

	}
	public static RollingShooter singleton = new RollingShooter();
}
