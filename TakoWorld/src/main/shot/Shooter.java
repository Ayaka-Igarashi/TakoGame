package main.shot;

import java.awt.geom.Point2D;

import main.TWInfo;
import main.stage.Stage;

public abstract class Shooter {
	public abstract void shoot(TWInfo tInfo,Stage stage,Point2D.Double position);
}
