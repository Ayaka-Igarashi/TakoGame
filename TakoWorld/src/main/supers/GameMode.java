package main.supers;

import java.io.IOException;

import main.TWInfo;

public abstract class GameMode {
	public abstract boolean isEnd();//エンディングにいくかどうか
	public abstract boolean isExit();//タイトルに戻るかどうか
	public abstract boolean isModeChange();//モードを変えるかどうか

	public abstract int getNextScene();

	public abstract void first(TWInfo tInfo,int scene);//最初の画像設定
	public abstract void control(TWInfo tInfo);
	public abstract void keyControl(TWInfo tInfo);
	public abstract void draw(TWInfo tInfo);
	public abstract void loadMedia() throws IOException;

	public abstract void stopBGM();

}
