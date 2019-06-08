package main.mode;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.supers.GameMode;

public class BattleMode extends GameMode {
	private Font font=new Font("HG丸ｺﾞｼｯｸM-PRO",Font.PLAIN,40);
	private boolean endFlg=false;

	private BufferedImage img_test;

	@Override
	public boolean isEnd() {
		if(this.endFlg==true) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean isExit() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public void first(TWInfo tInfo) {
		this.endFlg=false;

	}

	@Override
	public void control(TWInfo tInfo) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void keyControl(TWInfo tInfo) {
		if(tInfo.keyState[KEY_STATE.Z]==true&&tInfo.keyReleased[KEY_STATE.Z]==true) {
			this.endFlg=true;
			tInfo.keyReleased[KEY_STATE.Z]=false;
		}else if(tInfo.keyState[KEY_STATE.Z]==false&&tInfo.keyReleased[KEY_STATE.Z]==false) {
			tInfo.keyReleased[KEY_STATE.Z]=true;//キーが放された状態にする
		}

	}

	@Override
	public void draw(TWInfo tInfo) {
		this.keyControl(tInfo);
		this.control(tInfo);


		tInfo.g.drawImage(this.img_test,0,0,null);
		tInfo.g.setBackground(Color.BLACK);
		tInfo.g.setFont(this.font);
		tInfo.g.drawString("GAME MODE", 100, 100);

	}

	@Override
	public void loadMedia() throws IOException {
		this.img_test=ImageIO.read(new File("media/logo.png"));

	}

}
