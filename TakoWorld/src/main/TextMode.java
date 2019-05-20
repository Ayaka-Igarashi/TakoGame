package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import main.items.Haikei;
import main.supers.GameMode;
import main.supers.SoundBox;

public class TextMode extends GameMode {
	private Haikei haikei=new Haikei();
	private BufferedImage img_back1;
	private BufferedImage img_back2;

	@Override
	public void draw(TWInfo tInfo) {
		this.haikei.draw(tInfo);
	}

	@Override
	public void loadMedia() throws IOException {
		this.img_back1=ImageIO.read(new File("media/haikei.png"));
		this.haikei.setImage(img_back1);
		this.img_back2=ImageIO.read(new File("media/haikei2.png"));
		this.haikei.setImage(img_back2);
		this.haikei.setVisible(0, true);
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
