package main.supers;

import java.io.IOException;

import main.TWInfo;

public abstract class GameMode {
	public abstract void draw(TWInfo tInfo);
	public abstract void loadMedia() throws IOException;

}
