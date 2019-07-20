package main.shot;

import main.TWInfo;
import main.functions.Vector;
import main.stage.Stage;

public class ChaseMover extends BulletMover {
	private Vector v=new Vector();

	@Override
	public void move(TWInfo tInfo, Stage stage, BulletChara bullet) {
		if(bullet.position.x<-10||bullet.position.x>stage.getWidth()+10||bullet.position.y<-10||bullet.position.y>stage.getHeight()+10) {
			bullet.visible=false;
		}
		long l=tInfo.currentTime_withoutMenu-bullet.getStartTime();
		if(l%1500<10) {
			bullet.vector.x=stage.getPlayer().position.x;
			bullet.vector.y=stage.getPlayer().position.y;
			v.x=bullet.position.x;
			v.y=bullet.position.y;
			bullet.vector.subVector(v);
			bullet.vector.normalize();
			bullet.vector.x*=100;
			bullet.vector.y*=100;
			double r=bullet.vector.angle();
			bullet.angle=r/Math.PI*180.0;
		}
		bullet.position.x+=bullet.vector.x*tInfo.frameTime;
		bullet.position.y+=bullet.vector.y*tInfo.frameTime;

	}

	public static ChaseMover singleton =new ChaseMover();

}
