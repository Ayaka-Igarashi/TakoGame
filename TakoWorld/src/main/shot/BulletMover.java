package main.shot;

import main.TWInfo;
import main.stage.Stage;

public abstract class BulletMover {
	public abstract void move(TWInfo tInfo,Stage stage,BulletChara bullet);
}
