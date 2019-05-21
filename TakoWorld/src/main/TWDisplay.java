package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import main.supers.GameDisplay;
import main.supers.GameMode;
import main.supers.SoundBox;

public class TWDisplay extends GameDisplay{
	GameDisplay title,main,end;
	private Font font=new Font("HG丸ｺﾞｼｯｸM-PRO",Font.PLAIN,40);
	GameMode mode=new TextMode();

	public TWDisplay() {
		this.title=new TWTitle();
		this.main=new TWMain();
		this.end=new TWEnd();
		//追加していく
		TWDisplay.current=this.title;

	}

	@Override
	public void show(TWInfo tInfo) {
	}

	@Override
	public void loadMedia() throws IOException {
		this.title.loadMedia();
		this.main.loadMedia();
		this.end.loadMedia();
		//追加していく

	}


	//タイトル画面
	public class TWTitle extends GameDisplay{
		private BufferedImage img_title;
		boolean pushFlg=false;//ボタンが押されたか判定

		@Override
		public void show(TWInfo tInfo) {
			tInfo.g.drawImage(this.img_title,0,0,null);
			tInfo.g.setColor(new Color(50,80,255));
			tInfo.g.setFont(TWDisplay.this.font);
			String str ="PUSH SPACE";
			//真ん中に文字を表示
			FontMetrics fm=tInfo.g.getFontMetrics();
			int strw=fm.stringWidth(str)/2;
			tInfo.g.drawString(str,400-strw, 500);
			//1回押したらもう押されないように
			if(tInfo.keyState[KEY_STATE.Z]&&pushFlg==false) {
				tInfo.pushTime=tInfo.currentTime;
				pushFlg=true;
				SoundBox.singleton.playClip(0);//音楽を流す
			}
			if(tInfo.currentTime-tInfo.pushTime>500&&pushFlg==true) {
				GameDisplay.current=TWDisplay.this.main;
				SoundBox.singleton.playClip(1);//音楽を流す
			}
		}

		@Override
		public void loadMedia() throws IOException {
			this.img_title=ImageIO.read(new File("media/haikei2.png"));
			//音楽読み込み
			try {
				SoundBox.singleton.loadSound(new File("media/bom34.wav"));
			}catch (UnsupportedAudioFileException e) {
				e.printStackTrace();
			}catch (LineUnavailableException e) {
				e.printStackTrace();
			}
		}

	}

	//本編
	public class TWMain extends GameDisplay{
		private BufferedImage img_textbox;
		private BufferedImage img_hotate;

		@Override
		public void show(TWInfo tInfo) {/*
			tInfo.g.drawImage(this.img_back,0,0,null);
			tInfo.g.drawImage(this.img_textbox,0,0,null);
			tInfo.g.drawImage(this.img_hotate,0,0,null);
			*/
			TWDisplay.this.mode.draw(tInfo);//現在のモードを線画
			}

		@Override
		public void loadMedia() throws IOException {
			TWDisplay.this.mode.loadMedia();
			/*

			this.img_textbox=ImageIO.read(new File("media/textbox.png"));
			this.img_hotate=ImageIO.read(new File("media/kai.png"));*/

		}

	}
	//エンディング
	public class TWEnd extends GameDisplay{

		@Override
		public void show(TWInfo tInfo) {
			tInfo.g.setColor(new Color(50,80,255));
			tInfo.g.setFont(TWDisplay.this.font);
			String str ="CLEAR!";
			//真ん中に文字を表示
			FontMetrics fm=tInfo.g.getFontMetrics();
			int strw=fm.stringWidth(str)/2;
			tInfo.g.drawString(str,400-strw, 600);
			if(tInfo.keyState[KEY_STATE.Z]) {
				GameDisplay.current=TWDisplay.this.title;

			}

		}

		@Override
		public void loadMedia() throws IOException {
			// TODO 自動生成されたメソッド・スタブ

		}

	}


}
