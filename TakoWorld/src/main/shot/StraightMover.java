package main.shot;

import main.TWInfo;
import main.stage.Stage;

public class StraightMover extends BulletMover {

	@Override
	public void move(TWInfo tInfo, Stage stage, BulletChara bullet) {
		if(bullet.position.x<0||bullet.position.x>stage.getWidth()||bullet.position.y<0||bullet.position.y>stage.getHeight()) {
			bullet.visible=false;
		}
		bullet.position.x+=bullet.vector.x*tInfo.frameTime;
		bullet.position.y+=bullet.vector.y*tInfo.frameTime;
	}

	public static StraightMover singleton=new StraightMover();

}
