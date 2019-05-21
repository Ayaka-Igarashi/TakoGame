package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import main.items.Haikei;
import main.items.Hotate;
import main.items.TextBox;
import main.supers.GameMode;
import main.supers.SoundBox;

public class TextMode extends GameMode {
	private Haikei haikei=new Haikei();
	private Hotate hotate=new Hotate();
	private TextBox textBox=new TextBox();
	private BufferedImage img_back1,img_back2;
	private BufferedImage img_hotate1,img_hotate2;
	private BufferedImage img_textBox;

	//最初の画像設定
	@Override
	public void first() {
		this.haikei.first();
		this.hotate.first();
		this.textBox.first();
	}

	//画面操作(どの画像を)
	@Override
	public void control(TWInfo tInfo) {
		this.haikei.control(tInfo);
		this.hotate.control(tInfo);
		this.textBox.control(tInfo);
		//キーが押されたら押した時間を更新
		if(tInfo.currentTime-tInfo.pushTime>200) {
			if(tInfo.keyState[KEY_STATE.Z]||tInfo.keyState[KEY_STATE.X]) {
				this.haikei.keyControl(tInfo);
				this.hotate.keyControl(tInfo);
				this.textBox.keyControl(tInfo);
				tInfo.pushTime=tInfo.currentTime;
			}
		}
	}

	//毎回呼び出されるやつ
	@Override
	public void draw(TWInfo tInfo) {
		this.control(tInfo);
		this.haikei.draw(tInfo);
		this.hotate.draw(tInfo);
		this.textBox.draw(tInfo);
	}

	@Override
	public void loadMedia() throws IOException {
		this.img_back1=ImageIO.read(new File("media/haikei.png"));
		this.haikei.setImage(img_back1);
		this.img_back2=ImageIO.read(new File("media/haikei2.png"));
		this.haikei.setImage(img_back2);
		this.img_hotate1=ImageIO.read(new File("media/kai.png"));
		this.hotate.setImage(img_hotate1);
		this.img_hotate2=ImageIO.read(new File("media/kai2.png"));
		this.hotate.setImage(img_hotate2);
		this.img_textBox=ImageIO.read(new File("media/textbox2.png"));
		this.textBox.setImage(img_textBox);

		this.first();//初期画像設定

		//音楽読み込み
		try {
			SoundBox.singleton.loadSound(new File("media/city-trial.wav"));
		}catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		}catch (LineUnavailableException e) {
			e.printStackTrace();
		}

	}







}
