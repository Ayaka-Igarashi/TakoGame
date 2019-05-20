package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.supers.GameDisplay;
import main.supers.GameMode;

public class TWDisplay extends GameDisplay{
	GameDisplay title,main,end;
	private Font font=new Font("HG丸ｺﾞｼｯｸM-PRO",Font.PLAIN,50);
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

		@Override
		public void show(TWInfo tInfo) {
			tInfo.g.drawImage(this.img_title,0,0,null);
			tInfo.g.setColor(new Color(50,80,255));
			tInfo.g.setFont(TWDisplay.this.font);
			String str ="PUSH Z";
			//真ん中に文字を表示
			FontMetrics fm=tInfo.g.getFontMetrics();
			int strw=fm.stringWidth(str)/2;
			tInfo.g.drawString(str,400-strw, 600);
			if(tInfo.keyState[KEY_STATE.Z]) {
				GameDisplay.current=TWDisplay.this.main;
				//

			}

		}

		@Override
		public void loadMedia() throws IOException {
			this.img_title=ImageIO.read(new File("haikei2.png"));
		}

	}

	//本編
	public class TWMain extends GameDisplay{
		private BufferedImage img_back;
		private BufferedImage img_textbox;
		private BufferedImage img_hotate;

		@Override
		public void show(TWInfo tInfo) {/*
			tInfo.g.drawImage(this.img_back,0,0,null);
			tInfo.g.drawImage(this.img_textbox,0,0,null);
			tInfo.g.drawImage(this.img_hotate,0,0,null);
			*/
			TWDisplay.this.mode.draw(tInfo);//現在のモードを線画
			if(tInfo.keyState[KEY_STATE.Z]) {
				//処理

			}

		}

		@Override
		public void loadMedia() throws IOException {
			TWDisplay.this.mode.loadMedia();
			/*
			this.img_back=ImageIO.read(new File("haikei.png"));
			this.img_textbox=ImageIO.read(new File("textbox.png"));
			this.img_hotate=ImageIO.read(new File("kai.png"));*/

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
