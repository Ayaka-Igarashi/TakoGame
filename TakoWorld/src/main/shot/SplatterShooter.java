package main.shot;

import java.awt.geom.Point2D;

import main.TWInfo;
import main.stage.Stage;
import main.stage.Stage1;

public class SplatterShooter extends Shooter {

	@Override
	public void shoot(TWInfo tInfo, Stage stage,Point2D.Double position,int num) {
		double r=(Math.random()*120-60.0)/180.0*Math.PI;
		BulletChara bullet=stage.searchBullet();
		if(bullet==null)return;
		bullet.mover=StraightMover.singleton;
		bullet.position.x=stage.getEnemy().position.x;
		bullet.position.y=stage.getEnemy().position.y;
		bullet.vector.x=0.0;
		bullet.vector.y=200.0;
		bullet.vector.rotateVector(r);
		bullet.setImage(stage.getBulletImage(Stage1.STAR_BULLET));
		bullet.setVisible(tInfo, true);

	}
	public static SplatterShooter singleton =new SplatterShooter();
}
