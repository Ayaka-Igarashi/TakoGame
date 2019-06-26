package main.shot;

import main.TWInfo;
import main.stage.Stage;

public class AccelMover extends BulletMover {

	@Override
	public void move(TWInfo tInfo, Stage stage, BulletChara bullet) {
		if( bullet.position.x < 0 ||
				bullet.position.x > stage.getWidth() ||
				bullet.position.y < 0 ||
				bullet.position.y > stage.getHeight())
			{
				bullet.visible = false;
			}
			long l = tInfo.currentTime - bullet.getStartTime();
			bullet.vector.normalize();
			double s = 200.0;
			if(l > 500) s = s + (double)l / 5.0;
			bullet.vector.x *= s;
			bullet.vector.y *= s;
			bullet.position.x += bullet.vector.x * tInfo.frameTime;
			bullet.position.y += bullet.vector.y * tInfo.frameTime;
	}
	public static AccelMover singleton = new AccelMover();
}
