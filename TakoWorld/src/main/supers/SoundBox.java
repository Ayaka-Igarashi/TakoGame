package main.supers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundBox {
	private ArrayList<Clip> clips=new ArrayList<Clip>();

	//音声ファイルを読み込む
	public int loadSound(File file)throws UnsupportedAudioFileException,IOException,LineUnavailableException{
		AudioInputStream aistream=AudioSystem.getAudioInputStream(file);
		DataLine.Info info=new DataLine.Info(Clip.class,aistream.getFormat());
		Clip clip=(Clip)AudioSystem.getLine(info);
		clip.open(aistream);
		this.clips.add(clip);
		return this.clips.size()-1;
	}


	public Clip getClip(int idx) {
		if(idx>=this.clips.size()) {
			return null;
		}
		return this.clips.get(idx);
	}

	//音声を再生する
	public Clip playClip(int idx) {
		Clip clip=this.getClip(idx);
		clip.setFramePosition(0);
		clip.start();
		return clip;
	}

	//ループ再生設定
	public Clip setLoop(int idx,int start,int end) {
		Clip clip=this.getClip(idx);
		clip.setLoopPoints(start,end);
		return clip;
	}
/*
	//1回再生（いらない）
	public Clip playOnce(int idx) {
		Clip clip=this.getClip(idx);
		clip.setFramePosition(0);
		clip.loop(1);
		return clip;
	}
*/
	//音楽をループ再生する
	public Clip loopClip(int idx) {
		Clip clip=this.getClip(idx);
		clip.setFramePosition(0);
		clip.loop(clip.LOOP_CONTINUOUSLY);
		return clip;
	}

	//音声を止める
	public Clip stopClip(int idx) {
		Clip clip=this.getClip(idx);
		clip.stop();
		return clip;
	}

	public static SoundBox singleton=new SoundBox();

}
