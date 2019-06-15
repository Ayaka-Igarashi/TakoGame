package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import main.constant.KEY_STATE;
import main.constant.MUSIC_NUM;
import main.mode.BattleMode;
import main.mode.TextMode;
import main.supers.GameDisplay;
import main.supers.GameMode;
import main.supers.SoundBox;

public class TWDisplay extends GameDisplay{
	GameDisplay title,main,end;
	private Font font=new Font("HG丸ｺﾞｼｯｸM-PRO",Font.PLAIN,40);
	private ArrayList<GameMode> modeList =new ArrayList<GameMode>();
	private GameMode mode =null;
	private int modeNum=1;//初期のモード番号

	public TWDisplay() {
		this.title=new TWTitle();
		this.main=new TWMain();
		this.end=new TWEnd();
		//追加していく
		TWDisplay.current=this.title;
		this.modeList.add(new TextMode());
		this.modeList.add(new BattleMode());
		this.mode=modeList.get(this.modeNum);
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
		for(int i=0;i<this.modeList.size();i++) {
			this.modeList.get(i).loadMedia();
		}
	}


	//タイトル画面
	public class TWTitle extends GameDisplay{
		private BufferedImage img_title;
		private BufferedImage img_choice;
		boolean pushFlg=false;//ボタンが押されたか判定
		private int nowChoice=0;//選択しているもの
		private Point2D.Double[] pos= {
				new Point2D.Double(70,485),
				new Point2D.Double(280,485),
				new Point2D.Double(530,485)
				};

		@Override
		public void show(TWInfo tInfo) {

			/*
			//別の処理方法
			ImageFilter filter = new AreaAveragingScaleFilter(800,600);
			ImageProducer p = new FilteredImageSource(this.img_title.getSource(), filter);
			java.awt.Image dstImage = Toolkit.getDefaultToolkit().createImage(p);
			tInfo.g.drawImage(dstImage, 0, 0, null);*/

			tInfo.g.drawImage(this.img_title.getScaledInstance(800, 600, Image.SCALE_SMOOTH),0,TWFrame.title_bar_height,null);

			tInfo.g.drawImage(this.img_choice,(int)this.pos[this.nowChoice].x,(int)this.pos[this.nowChoice].y+TWFrame.title_bar_height,null);

			/*
			tInfo.g.setColor(new Color(50,80,255));
			tInfo.g.setFont(TWDisplay.this.font);
			String str;
			//test用
			if(this.nowChoice==0) {str ="start";}
			else if(this.nowChoice==1) {str="continue";}
			else {str="close";}

			//真ん中に文字を表示
			FontMetrics fm=tInfo.g.getFontMetrics();
			int strw=fm.stringWidth(str)/2;
			tInfo.g.drawString(str,400-strw, 500);
			*/

			//1回押したらもう押されないように
			if(tInfo.keyState[KEY_STATE.Z]&&tInfo.keyReleased[KEY_STATE.Z]&&pushFlg==false) {
				if(this.nowChoice==2) {
					this.nowChoice=0;
					System.exit(0);//ゲームを終了する
				}
				tInfo.pushTime=tInfo.currentTime;
				pushFlg=true;
				SoundBox.singleton.playClip(MUSIC_NUM.BOMB);//効果音を流す
				tInfo.keyReleased[KEY_STATE.Z]=false;//キーが放されていない状態にする
			}else if(tInfo.keyState[KEY_STATE.Z]==false&&tInfo.keyReleased[KEY_STATE.Z]==false) {
				tInfo.keyReleased[KEY_STATE.Z]=true;//キーが放された状態にする
			}

			//右
			if(tInfo.keyState[KEY_STATE.RIGHT]&&tInfo.keyReleased[KEY_STATE.RIGHT]&&pushFlg==false) {
				if(this.nowChoice<2) {
					this.nowChoice+=1;
				}
				SoundBox.singleton.playClip(MUSIC_NUM.CHOICE3);//効果音を流す
				tInfo.keyReleased[KEY_STATE.RIGHT]=false;//キーが放されていない状態にする
			}else if(tInfo.keyState[KEY_STATE.RIGHT]==false&&tInfo.keyReleased[KEY_STATE.RIGHT]==false) {

				tInfo.keyReleased[KEY_STATE.RIGHT]=true;//キーが放された状態にする
				SoundBox.singleton.stopClip(MUSIC_NUM.CHOICE3);//効果音を止める
			}

			//左
			if(tInfo.keyState[KEY_STATE.LEFT]&&tInfo.keyReleased[KEY_STATE.LEFT]&&pushFlg==false) {
				if(this.nowChoice>0) {
					this.nowChoice-=1;
				}
				SoundBox.singleton.playClip(MUSIC_NUM.CHOICE3);//効果音を流す
				tInfo.keyReleased[KEY_STATE.LEFT]=false;//キーが放されていない状態にする
			}else if(tInfo.keyState[KEY_STATE.LEFT]==false&&tInfo.keyReleased[KEY_STATE.LEFT]==false) {

				tInfo.keyReleased[KEY_STATE.LEFT]=true;//キーが放された状態にする
				SoundBox.singleton.stopClip(MUSIC_NUM.CHOICE3);//効果音を止める
			}

			//待ち時間後の処理
			if(tInfo.currentTime-tInfo.pushTime>300&&pushFlg==true) {//待ち時間を作る
				GameDisplay.current=TWDisplay.this.main;
				if(this.nowChoice==1) {//コンティニューの場合ロードする
					TWDisplay.this.mode=TWDisplay.this.modeList.get(0);//テキストモードにする
					TWDisplay.this.modeNum=0;
					TWDisplay.this.mode.first(tInfo);//初期画像設定
					tInfo.load();
				}else {
					TWDisplay.this.mode.first(tInfo);//初期画像設定
				}
				pushFlg=false;
				this.nowChoice=0;//選択をデフォルトの位置にする
			}
		}

		@Override
		public void loadMedia() throws IOException {
			this.img_title=ImageIO.read(new File("media/title.png"));
			this.img_choice=ImageIO.read(new File("media/choice_icon.png"));
			//音楽読み込み
			try {
				SoundBox.singleton.loadSound(new File("media/sound/bom34.wav"));
				SoundBox.singleton.loadSound(new File("media/sound/question.wav"));
				SoundBox.singleton.setLoop(MUSIC_NUM.QUESTION, 0, 331000);//ループ設定
				SoundBox.singleton.loadSound(new File("media/sound/戦闘曲31.wav"));
				SoundBox.singleton.setLoop(MUSIC_NUM.BATTLE, 10000, 2132000);//ループ設定
				SoundBox.singleton.loadSound(new File("media/sound/choice3.wav"));
			}catch (UnsupportedAudioFileException e) {
				e.printStackTrace();
			}catch (LineUnavailableException e) {
				e.printStackTrace();
			}
		}

	}

	//本編
	public class TWMain extends GameDisplay{
		//boolean pushFlg=false;//ボタンが押されたか判定

		//繰り返し呼ばれる
		@Override
		public void show(TWInfo tInfo) {

			TWDisplay.this.mode.draw(tInfo);//現在のモードを線画
			if(TWDisplay.this.mode.isExit()) {
				TWDisplay.this.mode.stopBGM();//bgmを止める
				GameDisplay.current=TWDisplay.this.title;
				TWDisplay.this.mode=TWDisplay.this.modeList.get(1);
				TWDisplay.this.modeNum=1;
			}else if(TWDisplay.this.mode.isEnd()) {
				if(TWDisplay.this.modeNum==1) {
					TWDisplay.this.mode.stopBGM();//bgmを止める
					TWDisplay.this.mode =TWDisplay.this.modeList.get(0);
					TWDisplay.this.modeNum=0;
					TWDisplay.this.mode.first(tInfo);//初期画像設定
				}else {
					TWDisplay.this.mode.stopBGM();//bgmを止める
					GameDisplay.current=TWDisplay.this.end;
				}
			}

			/*
			if(TWDisplay.this.mode.isEnd()&&pushFlg==false) {
				tInfo.pushTime=tInfo.currentTime;
				pushFlg=true;
			}
			if(tInfo.currentTime-tInfo.pushTime>500&&pushFlg==true) {
				GameDisplay.current=TWDisplay.this.end;
				SoundBox.singleton.stopClip(MUSIC_NUM.QUESTION);//音楽を止める
				pushFlg=false;
			}*/
		}

		@Override
		public void loadMedia() throws IOException {
		}

	}
	//エンディング
	public class TWEnd extends GameDisplay{
		boolean pushFlg=false;//ボタンが押されたか判定

		@Override
		public void show(TWInfo tInfo) {
			tInfo.g.setColor(new Color(50,80,255));
			tInfo.g.setFont(TWDisplay.this.font);
			String str ="END!!! PUSH Z";
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
				TWDisplay.this.mode=TWDisplay.this.modeList.get(1);
				TWDisplay.this.modeNum=1;
				pushFlg=false;
			}

		}

		@Override
		public void loadMedia() throws IOException {
			// TODO 自動生成されたメソッド・スタブ

		}

	}


}
