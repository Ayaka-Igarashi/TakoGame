package main.supers;

import java.io.IOException;

import main.TWInfo;

public abstract class GamePhase {
	public abstract void first();
	public abstract void keyControl(TWInfo tInfo,int key);
	public abstract void draw(TWInfo tInfo);
	public abstract void loadMedia() throws IOException;
}
