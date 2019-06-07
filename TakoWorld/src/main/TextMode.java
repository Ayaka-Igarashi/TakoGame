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
import main.items.CharaSame;
import main.items.Choice;
import main.items.GameText;
import main.items.Haikei;
import main.items.Hotate;
import main.items.TWMenu;
import main.items.TextBox;
import main.scenes.Scene1;
import main.scenes.Scene2;
import main.scenes.Scene3;
import main.scenes.Scene4;
import main.scenes.SceneIntro;
import main.supers.GameMode;
import main.supers.SoundBox;
import main.supers.TWEvent;

public class TextMode extends GameMode {
	private int pushNum_Z;//Zキーを押した回数(イベント取り出しとシーン判定)
	private int textNum;//テキストの番号
	private Haikei haikei=new Haikei();
	private Hotate hotate=new Hotate();
	private CharaSame same=new CharaSame();
	private TextBox textBox=new TextBox();
	private GameText text=new GameText();
	private Choice choice=new Choice();
	private TWMenu menu=new TWMenu();

	private BufferedImage img_choice;

	private ArrayList<TWEvent> sceneList =new ArrayList<TWEvent>();//イベントリスト
	private int nowScene;//現在のシーン
	private boolean endFlg;

	//消すまでは1回しか呼び出されない
	public TextMode() {
		this.sceneList.add(SCENE_NUM.INTRO, new SceneIntro());//イベント追加
		this.sceneList.add(SCENE_NUM.ONE,new Scene1());
		this.sceneList.add(SCENE_NUM.TWO,new Scene2());
		this.sceneList.add(SCENE_NUM.THREE,new Scene3());
		this.sceneList.add(SCENE_NUM.FOUR,new Scene4());
	}

	////////////////////  set   &   get   //////////////////////
	public int getPushNumZ() {return this.pushNum_Z;}
	public void setPushNumZ(int pushNumZ) {this.pushNum_Z=pushNumZ;}

	public int getTextNum() {return textNum;}
	public void setTextNum(int textNum) {this.textNum = textNum;}

	public int getNowScene() {return nowScene;}
	public void setNowScene(int nowScene) {this.nowScene = nowScene;}

	public GameText getText() {return text;}
	public void setText(GameText text) {this.text = text;}

	public Haikei getHaikei() {return haikei;}
	public void setHaikei(Haikei haikei) {this.haikei = haikei;}

	public Hotate getHotate() {return hotate;}
	public void setHotate(Hotate hotate) {this.hotate = hotate;}

	public CharaSame getCharaSame() {return same;}
	public void getCharaSame(CharaSame same) {this.same = same;}

	public TextBox getTextBox() {return textBox;}
	public void setTextBox(TextBox textBox) {this.textBox = textBox;}

	public Choice getChoice() {return choice;}
	public void setChoice(Choice choice) {this.choice = choice;}
	////////////////////////////////////////////////////////////





	//シーンを変える
	public void changeScene(int sceneNum) {
		this.nowScene=sceneNum;
		this.text.setTexts(this.sceneList.get(nowScene).getText());
	}

	//最初の画像設定とシーン設定
	//最初から始めるごとに呼び出される
	@Override
	public void first(TWInfo tInfo) {
		this.pushNum_Z=0;
		this.textNum=0;
		this.haikei.first();
		this.hotate.first();
		this.same.first();
		this.textBox.first();
		this.text.first();
		this.choice.first();
		this.menu.first();
		this.nowScene=SCENE_NUM.INTRO;
		this.text.setTexts(this.sceneList.get(nowScene).getText());
		this.endFlg=false;

		tInfo.textModeInfo=this;
	}

	//画面操作
	@Override
	public void control(TWInfo tInfo) {
		this.haikei.control(tInfo);
		this.hotate.control(tInfo);
		this.same.control(tInfo);
		this.textBox.control(tInfo);
		this.text.control(tInfo);
		this.choice.control(tInfo);
		this.menu.control(tInfo);

		return;
	}

	//キー操作(どの画像を表示するかなど)
	public void keyControl(TWInfo tInfo) {
		//Zキーが押された瞬間の処理
		if(tInfo.keyState[KEY_STATE.Z]==true&&tInfo.keyReleased[KEY_STATE.Z]==true) {
			if(this.menu.isMenuTime()==true) {//メニュー画面状態か
				this.menu.keyControl(tInfo,KEY_STATE.Z,1);
			}else if(this.menu.isMenuTime()==false) {
				if(TextEffect.strFin==false) {//テキスト送り途中の早送りの処理
					this.text.keyControl(tInfo,KEY_STATE.Z,1);
				}else {
					if(this.choice.isChoiceTime()==true) {//選択肢状態だったら選択してそのまま次へ
						this.choice.keyControl(tInfo, KEY_STATE.Z, 0);
					}
					if(this.sceneList.get(nowScene).isFinished(this.pushNum_Z)) {//シーンが終わったか
						this.sceneList.get(nowScene).branch(tInfo);//分岐をきめる
						if(this.sceneList.get(nowScene).getNext()==SCENE_NUM.END) {//エンディングに行く
							this.endFlg=true;
						}else {
							this.changeScene(this.sceneList.get(nowScene).getNext());//次のシーンに行く
							this.text.resetNowTextNum();
							this.pushNum_Z=0;
							this.textNum=0;
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
								this.textNum+=1;
								this.text.keyControl(tInfo,KEY_STATE.Z,this.textNum);//this.pushNumZを送る
							}else if(event[i].item==ITEM_NUM.CHOICE) {
								this.choice.keyControl(tInfo, KEY_STATE.Z, event[i].action);
							}else if(event[i].item==ITEM_NUM.HOTATE) {
								this.hotate.keyControl(tInfo,KEY_STATE.Z,event[i].action);
							}else if(event[i].item==ITEM_NUM.SAME) {
								this.same.keyControl(tInfo,KEY_STATE.Z,event[i].action);
							}
						}
						this.pushNum_Z+=1;//押した回数に1を足す
					}
				}
			}

			SoundBox.singleton.playClip(MUSIC_NUM.CHOICE);//効果音を流す
			tInfo.keyReleased[KEY_STATE.Z]=false;//キーが放されていない状態にする
		}else if(tInfo.keyState[KEY_STATE.Z]==false&&tInfo.keyReleased[KEY_STATE.Z]==false) {
			tInfo.keyReleased[KEY_STATE.Z]=true;//キーが放された状態にする
			SoundBox.singleton.stopClip(MUSIC_NUM.CHOICE);//効果音を止める
		}

		//Xキー
		if(tInfo.keyState[KEY_STATE.X]==true&&tInfo.keyReleased[KEY_STATE.X]==true) {
			this.menu.keyControl(tInfo,KEY_STATE.X,1);
			SoundBox.singleton.playClip(MUSIC_NUM.CHOICE);//効果音を流す
			tInfo.keyReleased[KEY_STATE.X]=false;//キーが放されていない状態にする
		}else if(tInfo.keyState[KEY_STATE.X]==false&&tInfo.keyReleased[KEY_STATE.X]==false) {
			tInfo.keyReleased[KEY_STATE.X]=true;//キーが放された状態にする
			SoundBox.singleton.stopClip(MUSIC_NUM.CHOICE);//効果音を止める
		}

		//上キー（選択肢用）
		if(tInfo.keyState[KEY_STATE.UP]==true&&tInfo.keyReleased[KEY_STATE.UP]==true) {
			this.menu.keyControl(tInfo, KEY_STATE.UP, 1);
			this.choice.keyControl(tInfo, KEY_STATE.UP, 0);
			tInfo.keyReleased[KEY_STATE.UP]=false;//キーが放されていない状態にする
		}else if(tInfo.keyState[KEY_STATE.UP]==false&&tInfo.keyReleased[KEY_STATE.UP]==false) {
			SoundBox.singleton.stopClip(MUSIC_NUM.CHOICE);//効果音を止める
			tInfo.keyReleased[KEY_STATE.UP]=true;//キーが放された状態にする
		}

		//下キー
		if(tInfo.keyState[KEY_STATE.DOWN]==true&&tInfo.keyReleased[KEY_STATE.DOWN]==true) {
			this.menu.keyControl(tInfo, KEY_STATE.DOWN, 1);
			this.choice.keyControl(tInfo, KEY_STATE.DOWN, 0);
			tInfo.keyReleased[KEY_STATE.DOWN]=false;//キーが放されていない状態にする
		}else if(tInfo.keyState[KEY_STATE.DOWN]==false&&tInfo.keyReleased[KEY_STATE.DOWN]==false) {
			SoundBox.singleton.stopClip(MUSIC_NUM.CHOICE);//効果音を止める
			tInfo.keyReleased[KEY_STATE.DOWN]=true;//キーが放された状態にする
		}
		return;
	}



	//毎回呼び出されるやつ
	@Override
	public void draw(TWInfo tInfo) {
		this.keyControl(tInfo);
		this.control(tInfo);

		this.haikei.draw(tInfo);
		this.hotate.draw(tInfo);
		this.same.draw(tInfo);
		this.textBox.draw(tInfo);
		this.text.draw(tInfo);
		this.choice.draw(tInfo);
		this.menu.draw(tInfo);

		tInfo.textModeInfo=this;//情報更新
	}

	//消すまでは1回しか呼び出されない
	@Override
	public void loadMedia() throws IOException {
		this.haikei.setImage(ImageIO.read(new File("media/haikei.png")));
		this.haikei.setImage(ImageIO.read(new File("media/haikei_default.png")));

		this.hotate.setImage(ImageIO.read(new File("media/kai.png")));
		this.hotate.setImage(ImageIO.read(new File("media/kai2.png")));

		this.same.setImage(ImageIO.read(new File("media/same/same_body_L.png")));
		this.same.setImage(ImageIO.read(new File("media/same/same_body_R.png")));
		this.same.setImage(ImageIO.read(new File("media/same/same_face_default_L.png")));
		this.same.setImage(ImageIO.read(new File("media/same/same_face_default_R.png")));

		this.textBox.setImage(ImageIO.read(new File("media/textbox/textbox_back.png")));
		this.textBox.setImage(ImageIO.read(new File("media/textbox/textbox_L.png")));
		this.textBox.setImage(ImageIO.read(new File("media/textbox/textbox_R.png")));
		this.textBox.setImage(ImageIO.read(new File("media/textbox/textbox_same_L.png")));
		this.textBox.setImage(ImageIO.read(new File("media/textbox/textbox_same_R.png")));


		this.img_choice=ImageIO.read(new File("media/choice.png"));
		this.choice.setImage(this.img_choice.getSubimage(0, 0, 230, 100));
		this.choice.setImage(this.img_choice.getSubimage(0, 100, 230, 100));

		this.menu.setImage(ImageIO.read(new File("media/menu.png")));
		this.menu.setImage(ImageIO.read(new File("media/menu_arrow.png")));


		//音楽読み込み
		try {
			SoundBox.singleton.loadSound(new File("media/sound/question.wav"));
			SoundBox.singleton.setLoop(MUSIC_NUM.QUESTION, 0, 331000);//ループ設定
			SoundBox.singleton.loadSound(new File("media/sound/choice.wav"));
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

	//タイトルに戻るかどうか
	public boolean isExit() {
		return this.menu.isExit();
	}

}
