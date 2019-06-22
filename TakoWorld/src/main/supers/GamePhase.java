package main.supers;

import java.io.IOException;

import main.TWInfo;

public abstract class GamePhase {
	protected long startTime;
	public abstract void first(TWInfo tInfo,int scene);
	public abstract void keyControl(TWInfo tInfo,int key);
	public abstract void draw(TWInfo tInfo);
	public abstract void loadMedia() throws IOException;
}
