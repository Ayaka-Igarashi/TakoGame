package main.shot;

import main.TWInfo;
import main.functions.Vector;
import main.stage.Stage;
import main.stage.Stage1;

public class TargetShooter extends Shooter {
	private Vector v=new Vector();

	@Override
	public void shoot(TWInfo tInfo, Stage stage) {
		BulletChara bullet =stage.searchBullet();
		if(bullet==null)return;
		bullet.mover=ChaseMover.singleton;
		bullet.position.x=stage.getEnemy().position.x;
		bullet.position.y=stage.getEnemy().position.y;
		bullet.vector.x=stage.getPlayer().position.x;
		bullet.vector.y=stage.getPlayer().position.y;
		v.x=bullet.position.x;
		v.y=bullet.position.y;
		bullet.vector.subVector(v);
		bullet.vector.normalize();
		bullet.vector.x*=500;
		bullet.vector.y*=500;
		double r =bullet.vector.angle();
		bullet.angle=r/Math.PI*180.0;
		bullet.setImage(stage.getBulletImage(Stage1.STAR_BULLET));
		bullet.setVisible(tInfo, true);

	}
	public static TargetShooter singleton =new TargetShooter();
}
