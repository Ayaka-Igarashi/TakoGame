package main.shot;

import main.TWInfo;
import main.stage.Stage;

public class AccelMover_s extends BulletMover {
	@Override
	public void move(TWInfo tInfo, Stage stage, BulletChara bullet) {
		if(bullet.position.x<-10||bullet.position.x>stage.getWidth()+10||bullet.position.y<-10||bullet.position.y>stage.getHeight()+10)
			{
				bullet.visible = false;
			}
			long l = tInfo.currentTime_withoutMenu - bullet.getStartTime();
			bullet.vector.normalize();
			double s = 100.0;
			if(l > 500) s = s + (double)l / 5.0;
			bullet.vector.x *= s;
			bullet.vector.y *= s;
			bullet.position.x += bullet.vector.x * tInfo.frameTime;
			bullet.position.y += bullet.vector.y * tInfo.frameTime;
	}
	public static AccelMover_s singleton = new AccelMover_s();
}
