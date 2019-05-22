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

import main.constant.KEY_STATE;
import main.constant.MUSIC_NUM;
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
			String str ="スタート画面　PUSH Z";
			//真ん中に文字を表示
			FontMetrics fm=tInfo.g.getFontMetrics();
			int strw=fm.stringWidth(str)/2;
			tInfo.g.drawString(str,400-strw, 500);
			//1回押したらもう押されないように
			if(tInfo.keyState[KEY_STATE.Z]&&pushFlg==false) {
				tInfo.pushTime=tInfo.currentTime;
				pushFlg=true;
				SoundBox.singleton.playClip(MUSIC_NUM.BOMB);//効果音を流す
			}
			if(tInfo.currentTime-tInfo.pushTime>500&&pushFlg==true) {
				GameDisplay.current=TWDisplay.this.main;
				TWDisplay.this.mode.first();//初期画像設定
				SoundBox.singleton.loopClip(MUSIC_NUM.QUESTION);
				pushFlg=false;
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
		boolean pushFlg=false;//ボタンが押されたか判定

		//繰り返し呼ばれる
		@Override
		public void show(TWInfo tInfo) {
			TWDisplay.this.mode.draw(tInfo);//現在のモードを線画
			if(TWDisplay.this.mode.isEnd()&&pushFlg==false) {
				tInfo.pushTime=tInfo.currentTime;
				pushFlg=true;
			}
			if(tInfo.currentTime-tInfo.pushTime>500&&pushFlg==true) {
				GameDisplay.current=TWDisplay.this.end;
				SoundBox.singleton.stopClip(MUSIC_NUM.QUESTION);//音楽を止める
				pushFlg=false;
			}
		}

		@Override
		public void loadMedia() throws IOException {
			TWDisplay.this.mode.loadMedia();
		}

	}
	//エンディング
	public class TWEnd extends GameDisplay{
		boolean pushFlg=false;//ボタンが押されたか判定

		@Override
		public void show(TWInfo tInfo) {
			tInfo.g.setColor(new Color(50,80,255));
			tInfo.g.setFont(TWDisplay.this.font);
			String str ="CLEAR! PUSH Z";
			//真ん中に文字を表示
			FontMetrics fm=tInfo.g.getFontMetrics();
			int strw=fm.stringWidth(str)/2;
			tInfo.g.drawString(str,400-strw, 400);
			if(tInfo.keyState[KEY_STATE.Z]&&pushFlg==false) {
				tInfo.pushTime=tInfo.currentTime;
				pushFlg=true;
				SoundBox.singleton.playClip(MUSIC_NUM.BOMB);//音楽を流す
			}
			if(tInfo.currentTime-tInfo.pushTime>500&&pushFlg==true) {
				GameDisplay.current=TWDisplay.this.title;
				pushFlg=false;
			}

		}

		@Override
		public void loadMedia() throws IOException {
			// TODO 自動生成されたメソッド・スタブ

		}

	}


}
