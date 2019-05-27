package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import main.constant.ITEM_NUM;
import main.constant.KEY_STATE;
import main.constant.MUSIC_NUM;
import main.constant.SCENE_NUM;
import main.functions.TextEffect;
import main.items.Choice;
import main.items.GameText;
import main.items.Haikei;
import main.items.Hotate;
import main.items.TextBox;
import main.scenes.Scene1;
import main.scenes.SceneIntro;
import main.supers.GameMode;
import main.supers.SoundBox;
import main.supers.TWEvent;

public class TextMode extends GameMode {
	private int pushNum_Z;//Zキーを押した回数
	private Haikei haikei=new Haikei();
	private Hotate hotate=new Hotate();
	private TextBox textBox=new TextBox();
	private GameText text=new GameText();
	private Choice choice=new Choice();
	private BufferedImage img_back1,img_back2;
	private BufferedImage img_hotate1,img_hotate2;
	private BufferedImage img_textBox;
	private BufferedImage img_choice;

	private ArrayList<TWEvent> sceneList =new ArrayList<TWEvent>();//イベントリスト
	private int nowScene;//現在のシーン
	private boolean endFlg;

	//消すまでは1回しか呼び出されない
	public TextMode() {
		this.sceneList.add(SCENE_NUM.INTRO, new SceneIntro());//イベント追加
		this.sceneList.add(SCENE_NUM.ONE,new Scene1());
	}

	//最初の画像設定とシーン設定
	//最初から始めるごとに呼び出される
	@Override
	public void first() {
		this.pushNum_Z=0;
		this.haikei.first();
		this.hotate.first();
		this.textBox.first();
		this.text.first();
		this.choice.first();
		this.nowScene=SCENE_NUM.INTRO;
		this.text.setTexts(this.sceneList.get(nowScene).getText());
		this.endFlg=false;
	}

	//画面操作+キー操作(どの画像を表示するかなど)
	@Override
	public void control(TWInfo tInfo) {
		this.haikei.control(tInfo);
		this.hotate.control(tInfo);
		this.textBox.control(tInfo);
		this.text.control(tInfo);
		this.choice.control(tInfo);
		//Zキーが押された瞬間の処理
		if(tInfo.keyState[KEY_STATE.Z]==true&&tInfo.keyReleased[KEY_STATE.Z]==true) {
			if(TextEffect.strFin==false) {//テキスト送り途中の早送りの処理
				this.text.keyControl(tInfo,KEY_STATE.Z,1);
			}else {
				if(this.sceneList.get(nowScene).isFinished(this.pushNum_Z)) {//シーンが終わったか
					if(this.sceneList.get(nowScene).getNext()==SCENE_NUM.END) {//エンディングに行く
						this.endFlg=true;
					}else {
						this.nowScene=this.sceneList.get(nowScene).getNext();//次のシーンに行く
						this.text.setTexts(this.sceneList.get(nowScene).getText());
						this.text.resetNowTextNum();
						this.pushNum_Z=0;
					}

				}//そのまま次のシーンへ
				if(sceneList.get(nowScene).getEvent().size()>this.pushNum_Z) {
					Action[] event =new Action[sceneList.get(nowScene).getEvent().get(this.pushNum_Z).size()];
					for(int i=0;i<event.length;i++) {
						event[i]=sceneList.get(nowScene).getEvent().get(this.pushNum_Z).get(i);//イベントを取り出すAction型

						if(event[i].item==ITEM_NUM.BACK) {
							this.haikei.keyControl(tInfo,KEY_STATE.Z,event[i].action);
						}else if(event[i].item==ITEM_NUM.TEXTBOX) {
							this.textBox.keyControl(tInfo,KEY_STATE.Z,event[i].action);
						}else if(event[i].item==ITEM_NUM.TEXT) {
							this.text.keyControl(tInfo,KEY_STATE.Z,event[i].action);
						}else if(event[i].item==ITEM_NUM.CHOICE) {
							this.choice.keyControl(tInfo, KEY_STATE.Z, event[i].action);
						}else if(event[i].item==ITEM_NUM.HOTATE) {
							this.hotate.keyControl(tInfo,KEY_STATE.Z,event[i].action);
						}
					}
					this.pushNum_Z+=1;//押した回数に1を足す
				}
			}
			SoundBox.singleton.playClip(MUSIC_NUM.CHOICE);//効果音を流す
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
		//上キー（選択肢用）
		if(tInfo.keyState[KEY_STATE.UP]==true&&tInfo.keyReleased[KEY_STATE.UP]==true) {
			if(this.choice.isChoiceTime()==true) {//選択中だったら動く
				this.choice.keyControl(tInfo, KEY_STATE.UP, 0);
			}
			SoundBox.singleton.playClip(MUSIC_NUM.CHOICE);//効果音を流す
			tInfo.keyReleased[KEY_STATE.UP]=false;//キーが放されていない状態にする
		}else if(tInfo.keyState[KEY_STATE.UP]==false) {
			SoundBox.singleton.stopClip(MUSIC_NUM.CHOICE);//効果音を止める
			tInfo.keyReleased[KEY_STATE.UP]=true;//キーが放された状態にする
		}
		//下キー
		if(tInfo.keyState[KEY_STATE.DOWN]==true&&tInfo.keyReleased[KEY_STATE.DOWN]==true) {
			if(this.choice.isChoiceTime()==true) {//選択中だったら動く
				this.choice.keyControl(tInfo, KEY_STATE.DOWN, 0);
			}
			SoundBox.singleton.playClip(MUSIC_NUM.CHOICE);//効果音を流す
			tInfo.keyReleased[KEY_STATE.DOWN]=false;//キーが放されていない状態にする
		}else if(tInfo.keyState[KEY_STATE.DOWN]==false) {
			SoundBox.singleton.stopClip(MUSIC_NUM.CHOICE);//効果音を止める
			tInfo.keyReleased[KEY_STATE.DOWN]=true;//キーが放された状態にする
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
		this.choice.draw(tInfo);
	}

	//消すまでは1回しか呼び出されない
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
		this.img_choice=ImageIO.read(new File("media/haikei.png"));////////////
		///cut
		this.choice.setImage(img_choice);
		this.choice.setImage(img_back2);



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
		return this.endFlg;
	}







}
