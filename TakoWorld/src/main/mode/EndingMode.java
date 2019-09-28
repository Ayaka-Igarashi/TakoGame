package main.mode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.constant.MUSIC_NUM;
import main.functions.TextEffect;
import main.items.GameText;
import main.items.Haikei;
import main.items.SoundItem;
import main.supers.GameMode;
import main.supers.SoundBox;
import main.supers.TWEvent;

public class EndingMode extends GameMode {
	private int pushNum_Z;//Zキーを押した回数(イベント取り出しとシーン判定)
	private int textNum;//テキストの番号
	private Haikei haikei=new Haikei();
	private GameText text=new GameText();
	private SoundItem sound=new SoundItem();

	private ArrayList<TWEvent> sceneList =new ArrayList<TWEvent>();//イベントリスト
	private int nowScene;//現在のシーン
	private boolean endFlg;

	//消すまでは1回しか呼び出されない
	public EndingMode() {
	}

	////////////////////  set   &   get   //////////////////////
	public int getPushNumZ() {return this.pushNum_Z;}
	public void setPushNumZ(int pushNumZ) {this.pushNum_Z=pushNumZ;}

	public int getTextNum() {return textNum;}
	public void setTextNum(int textNum) {this.textNum = textNum;}

	public GameText getText() {return text;}
	public void setText(GameText text) {this.text = text;}

	public Haikei getHaikei() {return haikei;}
	public void setHaikei(Haikei haikei) {this.haikei = haikei;}

	public SoundItem getSound() {return sound;}
	public void setSound(SoundItem sound) {this.sound = sound;}
	////////////////////////////////////////////////////////////



	//最初の画像設定とシーン設定
	//最初から始めるごとに呼び出される
	@Override
	public void first(TWInfo tInfo,int scene) {
		this.pushNum_Z=0;
		this.textNum=0;

		this.haikei.first();
		this.text.first();
		this.sound.first();

		this.endFlg=false;

	}

	//画面操作
	@Override
	public void control(TWInfo tInfo) {
		this.haikei.control(tInfo);
		this.text.control(tInfo);
		this.sound.control(tInfo);

		return;
	}

	//キー操作(どの画像を表示するかなど)
	public void keyControl(TWInfo tInfo) {
		//Zキーが押された瞬間の処理
		if(tInfo.keyState[KEY_STATE.Z]==true&&tInfo.keyReleased[KEY_STATE.Z]==true) {
				if(TextEffect.strFin==false) {//テキスト送り途中の早送りの処理
					this.text.keyControl(tInfo,KEY_STATE.Z,1);
				}else {
					if(this.sceneList.get(nowScene).isFinished(this.pushNum_Z)) {//シーンが終わったか
						this.sceneList.get(nowScene).branch(tInfo);//分岐をきめる
						this.endFlg=true;
					}
				}

			SoundBox.singleton.playClip(MUSIC_NUM.CHOICE);//効果音を流す
			tInfo.keyReleased[KEY_STATE.Z]=false;//キーが放されていない状態にする
		}else if(tInfo.keyState[KEY_STATE.Z]==false&&tInfo.keyReleased[KEY_STATE.Z]==false) {
			tInfo.keyReleased[KEY_STATE.Z]=true;//キーが放された状態にする
			SoundBox.singleton.stopClip(MUSIC_NUM.CHOICE);//効果音を止める
		}

		return;
	}



	//毎回呼び出されるやつ
	@Override
	public void draw(TWInfo tInfo) {
		this.keyControl(tInfo);
		this.control(tInfo);

		this.haikei.draw(tInfo);
		this.text.draw(tInfo);
	}

	//消すまでは1回しか呼び出されない
	@Override
	public void loadMedia() throws IOException {
		this.haikei.setImage(ImageIO.read(new File("media/haikei.png")));
		this.haikei.setImage(ImageIO.read(new File("media/haikei3.png")));

		//音楽読み込み
		try {
			SoundBox.singleton.loadSound(new File("media/sound/choice.wav"));
		}catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		}catch (LineUnavailableException e) {
			e.printStackTrace();
		}

	}


	@Override
	public boolean isModeChange() {
		return false;
	}

	@Override
	public void stopBGM() {
		this.sound.stopBGM();
		return;
	}

	@Override
	public boolean isEnd() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean isExit() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public int getNextScene() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}
