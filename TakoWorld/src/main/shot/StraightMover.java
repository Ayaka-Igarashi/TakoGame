package main.shot;

import main.TWInfo;
import main.stage.Stage;

public class StraightMover extends BulletMover {

	@Override
	public void move(TWInfo tInfo, Stage stage, BulletChara bullet) {
		if(bullet.position.x<-10||bullet.position.x>stage.getWidth()+10||bullet.position.y<-10||bullet.position.y>stage.getHeight()+10) {
			bullet.visible=false;
		}
		bullet.position.x+=bullet.vector.x*tInfo.frameTime;
		bullet.position.y+=bullet.vector.y*tInfo.frameTime;
	}

	public static StraightMover singleton=new StraightMover();

}
