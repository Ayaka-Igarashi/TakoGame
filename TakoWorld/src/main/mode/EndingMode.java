package main.mode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.TWFrame;
import main.TWInfo;
import main.constant.KEY_STATE;
import main.constant.MUSIC_NUM;
import main.data.TextData;
import main.functions.TextEffect;
import main.items.GameText_end;
import main.supers.GameMode;
import main.supers.SoundBox;

public class EndingMode extends GameMode {
	private int pushNum_Z;//Zキーを押した回数
	private int textLength;//テキストの長さ
	private int endNum=0;//エンディングの種類（3種類）
	private GameText_end text=new GameText_end();
	private ArrayList<String[][]> textList=new ArrayList<String[][]>();//テキストのリスト

	private boolean endFlg;

	private BufferedImage img_now;
	private BufferedImage img_haikei1,img_haikei2,img_haikei3;

	//消すまでは1回しか呼び出されない
	public EndingMode() {
		this.textList.add(TextData.end1_txt);
		this.textList.add(TextData.end2_txt);
		this.textList.add(TextData.end3_txt);
	}

	////////////////////  set   &   get   //////////////////////
	public int getPushNumZ() {return this.pushNum_Z;}
	public void setPushNumZ(int pushNumZ) {this.pushNum_Z=pushNumZ;}

	public int getEndNum() {return endNum;}
	public void setEndNum(int endNum) {this.endNum = endNum;}

	public GameText_end getText() {return text;}
	public void setText(GameText_end text) {this.text = text;}
	////////////////////////////////////////////////////////////



	//最初の画像設定とシーン設定
	//最初から始めるごとに呼び出される
	@Override
	public void first(TWInfo tInfo,int scene) {
		this.pushNum_Z=0;
		this.endNum=scene;
		this.text.first();

		if(this.endNum==1) {
			this.text.setTexts(this.textList.get(0));
			this.textLength=this.textList.get(0).length;
			this.img_now=this.img_haikei1;
			SoundBox.singleton.loopClip(MUSIC_NUM.ENDING);//stopClipも変える
		}else if(this.endNum==2) {
			this.text.setTexts(this.textList.get(1));
			this.textLength=this.textList.get(1).length;
			this.img_now=this.img_haikei2;
			SoundBox.singleton.loopClip(MUSIC_NUM.ENDING);
		}else if(this.endNum==3) {
			this.text.setTexts(this.textList.get(2));
			this.textLength=this.textList.get(2).length;
			this.img_now=this.img_haikei3;
			SoundBox.singleton.loopClip(MUSIC_NUM.ENDING);
		}
		this.endFlg=false;

	}

	//画面操作
	@Override
	public void control(TWInfo tInfo) {
		this.text.control(tInfo);
		return;
	}

	//キー操作(どの画像を表示するかなど)
	public void keyControl(TWInfo tInfo) {
		//Zキーが押された瞬間の処理
		if(tInfo.keyState[KEY_STATE.Z]==true&&tInfo.keyReleased[KEY_STATE.Z]==true) {
				if(TextEffect.strFin==false) {//テキスト送り途中の早送りの処理
					this.text.keyControl(tInfo,KEY_STATE.Z,1);
				}else {
					if(this.textLength-1<=this.pushNum_Z) {//シーンが終わったか
						this.endFlg=true;
					}else if(this.textLength-1>this.pushNum_Z) {
						this.text.keyControl(tInfo,KEY_STATE.Z,this.pushNum_Z);//this.pushNumZを送る
						this.pushNum_Z+=1;//押した回数に1を足す
						SoundBox.singleton.playClip(MUSIC_NUM.CHOICE);//効果音を流す
					}
				}

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

		tInfo.g.drawImage(this.img_now,0,TWFrame.title_bar_height,null);
		if(this.textLength>this.pushNum_Z&&this.pushNum_Z!=0) {
			this.text.draw(tInfo);
		}
	}

	//消すまでは1回しか呼び出されない
	@Override
	public void loadMedia() throws IOException {
		this.img_haikei1=ImageIO.read(new File("media/haikei.png"));
		this.img_haikei2=ImageIO.read(new File("media/haikei_default.png"));
		this.img_haikei3=ImageIO.read(new File("media/end3.png"));
	}


	@Override
	public boolean isModeChange() {
		return false;
	}

	@Override
	public void stopBGM() {
		if(this.endNum==1) {
			SoundBox.singleton.stopClip(MUSIC_NUM.ENDING);
		}else if(this.endNum==2) {
			SoundBox.singleton.stopClip(MUSIC_NUM.ENDING);
		}else if(this.endNum==3) {
			SoundBox.singleton.stopClip(MUSIC_NUM.ENDING);
		}
		return;
	}

	@Override
	public boolean isEnd() {
		return this.endFlg;
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
