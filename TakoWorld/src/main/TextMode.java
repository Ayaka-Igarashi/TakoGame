package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import main.constant.ITEM_NUM;
import main.constant.KEY_STATE;
import main.constant.MUSIC_NUM;
import main.functions.TextEffect;
import main.items.GameText;
import main.items.Haikei;
import main.items.Hotate;
import main.items.TextBox;
import main.scenes.SceneIntro;
import main.supers.GameMode;
import main.supers.SoundBox;

public class TextMode extends GameMode {
	private int pushNum_Z;//Zキーを押した回数
	private Haikei haikei=new Haikei();
	private Hotate hotate=new Hotate();
	private TextBox textBox=new TextBox();
	private GameText text=new GameText();
	private BufferedImage img_back1,img_back2;
	private BufferedImage img_hotate1,img_hotate2;
	private BufferedImage img_textBox;

	private SceneIntro intro=new SceneIntro();//イントロの操作呼び出し

	//最初の画像設定
	@Override
	public void first() {
		this.pushNum_Z=0;
		this.haikei.first();
		this.hotate.first();
		this.textBox.first();
		this.text.first();
	}

	//画面操作+キー操作(どの画像を表示するかなど)
	@Override
	public void control(TWInfo tInfo) {
		this.haikei.control(tInfo);
		this.hotate.control(tInfo);
		this.textBox.control(tInfo);
		this.text.control(tInfo);
		//Zキーが押された瞬間の処理
		if(tInfo.keyState[KEY_STATE.Z]==true&&tInfo.keyReleased[KEY_STATE.Z]==true) {
			if(TextEffect.strFin==false) {//テキスト送り途中の早送りの処理
				this.text.keyControl(tInfo,KEY_STATE.Z,1);
			}else {
				if(intro.getEvent().size()>this.pushNum_Z) {
					Action[] event =new Action[intro.getEvent().get(this.pushNum_Z).size()];
					for(int i=0;i<event.length;i++) {
						event[i]=intro.getEvent().get(this.pushNum_Z).get(i);//イベントを取り出すAction型

						if(event[i].item==ITEM_NUM.BACK) {
							this.haikei.keyControl(tInfo,KEY_STATE.Z,event[i].action);
						}else if(event[i].item==ITEM_NUM.TEXTBOX) {
							this.textBox.keyControl(tInfo,KEY_STATE.Z,event[i].action);
						}else if(event[i].item==ITEM_NUM.TEXT) {
							this.text.keyControl(tInfo,KEY_STATE.Z,event[i].action);
						}else if(event[i].item==ITEM_NUM.CHOICE) {
	//追加する
						}else if(event[i].item==ITEM_NUM.HOTATE) {
							this.hotate.keyControl(tInfo,KEY_STATE.Z,event[i].action);
						}
					}
					this.pushNum_Z+=1;//押した回数に1を足す
				}

			}

			//this.haikei.keyControl(tInfo,KEY_STATE.Z);//(tinfo,KEY,)
			//this.hotate.keyControl(tInfo,KEY_STATE.Z);
			//this.textBox.keyControl(tInfo,KEY_STATE.Z);
			//this.text.keyControl(tInfo,KEY_STATE.Z,1);
			tInfo.keyReleased[KEY_STATE.Z]=false;//キーが放されていない状態にする
		}else if(tInfo.keyState[KEY_STATE.Z]==false) {
			tInfo.keyReleased[KEY_STATE.Z]=true;//キーが放された状態にする
			SoundBox.singleton.stopClip(MUSIC_NUM.CHOICE);//効果音を止める
		}
		//Xキー
		if(tInfo.keyState[KEY_STATE.X]==true&&tInfo.keyReleased[KEY_STATE.X]==true) {
			//this.hotate.keyControl(tInfo,KEY_STATE.X);
			tInfo.keyReleased[KEY_STATE.X]=false;//キーが放されていない状態にする
		}else if(tInfo.keyState[KEY_STATE.X]==false) {
			tInfo.keyReleased[KEY_STATE.X]=true;//キーが放された状態にする
		}

		return;
	}

	//毎回呼び出されるやつ
	@Override
	public void draw(TWInfo tInfo) {
		this.control(tInfo);
		this.haikei.draw(tInfo);
		this.hotate.draw(tInfo);
		this.textBox.draw(tInfo);
		this.text.draw(tInfo);
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
		this.img_textBox=ImageIO.read(new File("media/UI.png"));
		this.textBox.setImage(img_textBox);


		//音楽読み込み
		try {
			SoundBox.singleton.loadSound(new File("media/question.wav"));
			SoundBox.singleton.setLoop(MUSIC_NUM.QUESTION, 0, 331000);//ループ設定
			SoundBox.singleton.loadSound(new File("media/choice.wav"));
		}catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		}catch (LineUnavailableException e) {
			e.printStackTrace();
		}

	}
	//エンディングにいくかどうか
	@Override
	public boolean isEnd() {
		return this.text.isEnd();
	}







}
