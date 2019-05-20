package main.supers;

import java.io.IOException;

import main.TWInfo;

public abstract class GameDisplay {
	protected static GameDisplay current=null;
	protected long startTime;

	public void setStartTime(long st) {
		this.startTime=st;
	}

	public GameDisplay getCurrentDisplay() {
		return GameDisplay.current;
	}

	public abstract void show(TWInfo tinfo);

	public abstract void loadMedia() throws IOException;
}
