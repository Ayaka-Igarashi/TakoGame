package main.supers;

import java.io.IOException;

import main.TWInfo;

public abstract class GameMode {
	public abstract boolean isEnd();//エンディングにいくかどうか
	public abstract boolean isExit();//タイトルに戻るかどうか
	public abstract void first(TWInfo tInfo);//最初の画像設定
	public abstract void control(TWInfo tInfo);
	public abstract void draw(TWInfo tInfo);
	public abstract void loadMedia() throws IOException;

}
