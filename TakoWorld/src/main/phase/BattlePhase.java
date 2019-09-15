package main.phase;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.io.IOException;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.constant.MUSIC_NUM;
import main.constant.SCENE_NUM;
import main.stage.Stage;
import main.stage.Stage1;
import main.stage.Stage2;
import main.stage.StageDemo;
import main.supers.GamePhase;
import main.supers.SoundBox;

public class BattlePhase extends GamePhase{
	GamePhase start,main,reStart,clear,lose;
	private GamePhase nowPhase=null;
	//private ArrayList<Stage> stageList=new ArrayList<Stage>();//ステージのリスト
	private Stage stageDemo=new StageDemo();
	private Stage stage1=new Stage1();
	private Stage stage2=new Stage2();
	public Stage nowStage =stage1;

	public boolean clearFlg;
	public boolean exitFlg;

	private Font font = new Font("HG丸ｺﾞｼｯｸM-PRO", Font.PLAIN, 40);
	private Font font_s = new Font("HG丸ｺﾞｼｯｸM-PRO", Font.PLAIN, 20);

	protected boolean isMenuTime;

	public BattlePhase(){
		this.start=new StartPhase();
		this.main=new MainPhase();
		this.reStart=new ReStartPhase();
		this.clear=new ClearPhase();
		this.lose=new LosePhase();

		//this.stageList.add(new Stage1());//リスト追加
		//this.stageList.add(new Stage2());
	}

	//スタートするたびに実行
	public void first(TWInfo tInfo,int scene) {
		//System.out.println(scene);
		//this.nowStage=this.stage1;

		//ステージ切り替え
		if(scene==SCENE_NUM.SDemo) {
			this.nowStage=this.stageDemo;
		}else if(scene==SCENE_NUM.S1) {
			this.nowStage=this.stage1;
		}else if(scene==SCENE_NUM.S2) {
			this.nowStage=this.stage2;
		}


		this.nowPhase=start;
		this.nowPhase.first(tInfo,0);
		this.clearFlg=false;
		this.exitFlg=false;



	}

	public void keyControl(TWInfo tInfo,int key) {
		this.nowPhase.keyControl(tInfo, key);

	}

	public void draw(TWInfo tInfo) {
		this.nowPhase.draw(tInfo);
	}

	@Override
	public void loadMedia() throws IOException {
		this.stageDemo.loadMedia();
		this.stage1.loadMedia();
		this.stage2.loadMedia();

		//this.start.loadMedia();
		//this.main.loadMedia();
		//this.clear.loadMedia();
		//this.lose.loadMedia();

	}


	public void setIsMenu(boolean menuTime) {
		this.isMenuTime=menuTime;
		this.nowStage.setIsMenuTime(menuTime);

	}

	//クリア時とゲームオーバー時はメニュー画面開けない
	public boolean canOpenMenu() {
		return this.nowPhase!=clear&&this.nowPhase!=lose;
	}



	public class StartPhase extends GamePhase {

		public StartPhase() {

		}

		//スタート押すたびに実行
		@Override
		public void first(TWInfo tInfo,int scene) {
			BattlePhase.this.nowStage.first(tInfo);
			this.startTime=tInfo.currentTime_withoutMenu;
		}

		@Override
		public void keyControl(TWInfo tInfo,int key) {
			BattlePhase.this.nowStage.getEnemy().control(tInfo);
			BattlePhase.this.nowStage.startMotion(tInfo);

			if(tInfo.currentTime_withoutMenu-this.startTime>1200) {
				BattlePhase.this.nowPhase=main;
			}

		}

		@Override
		public void draw(TWInfo tInfo) {

			BattlePhase.this.nowStage.draw(tInfo);
			//tInfo.g.setBackground(Color.BLACK);
			//tInfo.g.drawString("START", 100, 100);



		}

		@Override
		public void loadMedia() throws IOException {
			// TODO 自動生成されたメソッド・スタブ

		}

	}

	public class MainPhase extends GamePhase {

		public MainPhase() {
		}

		@Override
		public void first(TWInfo tInfo,int scene) {
			// TODO 自動生成されたメソッド・スタブ

		}

		@Override
		public void keyControl(TWInfo tInfo,int key) {
			BattlePhase.this.nowStage.control(tInfo);
			BattlePhase.this.nowStage.getPlayer().keyControl(tInfo,-1, -1);

			if(BattlePhase.this.nowStage.isBossLiving()==false) {
				BattlePhase.this.nowPhase=clear;
				BattlePhase.this.nowPhase.first(tInfo,0);
				SoundBox.singleton.playClip(MUSIC_NUM.BOMB);
			}else if(BattlePhase.this.nowStage.isPlayerAlive()==false) {
				BattlePhase.this.nowPhase=lose;
				BattlePhase.this.nowPhase.first(tInfo,0);
			}else if(BattlePhase.this.nowStage.IsReStart==true) {
				BattlePhase.this.nowPhase=reStart;
				BattlePhase.this.nowPhase.first(tInfo,0);
				BattlePhase.this.nowStage.IsReStart=false;
			}

		}

		@Override
		public void draw(TWInfo tInfo) {
			BattlePhase.this.nowStage.draw(tInfo);
			//tInfo.g.setBackground(Color.BLACK);
			//tInfo.g.drawString("Main", 100, 100);

		}

		@Override
		public void loadMedia() throws IOException {
			// TODO 自動生成されたメソッド・スタブ

		}

	}

	public class ReStartPhase extends GamePhase {

		@Override
		public void first(TWInfo tInfo,int scene) {
			this.startTime=tInfo.currentTime_withoutMenu;
		}

		@Override
		public void keyControl(TWInfo tInfo, int key) {
			BattlePhase.this.nowStage.control(tInfo);
			if(tInfo.currentTime_withoutMenu-this.startTime>500) {
				BattlePhase.this.nowStage.reStart(tInfo);
			}


			if(tInfo.currentTime_withoutMenu-this.startTime>1000) {
				BattlePhase.this.nowPhase=main;
			}

		}

		@Override
		public void draw(TWInfo tInfo) {
			BattlePhase.this.nowStage.draw(tInfo);
			//tInfo.g.setBackground(Color.BLACK);
			//tInfo.g.drawString("reSTART", 100, 100);

		}

		@Override
		public void loadMedia() throws IOException {
			// TODO 自動生成されたメソッド・スタブ

		}

	}

	public class ClearPhase extends GamePhase {
		public ClearPhase() {

		}

		@Override
		public void first(TWInfo tInfo,int scene) {
			this.startTime=tInfo.currentTime_withoutMenu;
		}

		@Override
		public void keyControl(TWInfo tInfo,int key) {
			/*
			if(!tInfo.keyState[KEY_STATE.Z]) {
				BattlePhase.this.nowStage.getPlayer().keyControl(tInfo,-1, -1);
			}
			*/
			if(tInfo.currentTime_withoutMenu-this.startTime>3800) {
				BattlePhase.this.clearFlg=true;
			}
		}

		@Override
		public void draw(TWInfo tInfo) {
			BattlePhase.this.nowStage.draw(tInfo);
			//tInfo.g.setBackground(Color.BLACK);
			//tInfo.g.drawString("CLEAR", 100, 100);

			if(tInfo.currentTime_withoutMenu-this.startTime>800) {
				tInfo.g.setBackground(Color.BLACK);
				tInfo.g.setFont(BattlePhase.this.font);
				String str="CLEAR!!!";
				FontMetrics fm=tInfo.g.getFontMetrics();
				int strw=fm.stringWidth(str)/2;
				tInfo.g.drawString(str,400-strw, 350);
			}
		}

		@Override
		public void loadMedia() throws IOException {
			// TODO 自動生成されたメソッド・スタブ

		}

	}

	public class LosePhase extends GamePhase {
		private boolean pushFlg;
		private long pushTime;
		private int leftTime;

		public LosePhase() {
		}

		@Override
		public void first(TWInfo tInfo,int scene) {
			this.startTime=tInfo.currentTime_withoutMenu;
			this.pushFlg=false;
		}

		@Override
		public void keyControl(TWInfo tInfo,int key) {
			if(tInfo.currentTime_withoutMenu-this.startTime>800) {
				if(tInfo.keyState[KEY_STATE.Z]&&tInfo.keyReleased[KEY_STATE.Z]&&pushFlg==false) {
					pushFlg=true;
					this.pushTime=tInfo.currentTime_withoutMenu;
					SoundBox.singleton.playClip(MUSIC_NUM.CHOICE3);
					tInfo.keyReleased[KEY_STATE.Z]=false;//キーが放されていない状態にする
				}else if(tInfo.keyState[KEY_STATE.Z]==false&&tInfo.keyReleased[KEY_STATE.Z]==false) {
					tInfo.keyReleased[KEY_STATE.Z]=true;//キーが放された状態にする
				}
				else if(tInfo.currentTime_withoutMenu-this.pushTime>500&&pushFlg==true) {
					BattlePhase.this.nowPhase=start;
					BattlePhase.this.nowPhase.first(tInfo,0);
				}
			}
			if(tInfo.currentTime_withoutMenu-this.startTime>6500&&pushFlg==false) {
				BattlePhase.this.exitFlg=true;
			}
		}

		@Override
		public void draw(TWInfo tInfo) {
			this.leftTime=(int) (6-(tInfo.currentTime_withoutMenu-this.startTime+200)/1000);


			BattlePhase.this.nowStage.draw(tInfo);
			//tInfo.g.setBackground(Color.BLACK);
			//tInfo.g.drawString("GAME OVER", 100, 100);

			if(tInfo.currentTime_withoutMenu-this.startTime>800) {
				tInfo.g.setBackground(Color.BLACK);
				tInfo.g.setFont(BattlePhase.this.font);
				String str="GAME OVER";
				FontMetrics fm=tInfo.g.getFontMetrics();
				int strw=fm.stringWidth(str)/2;
				tInfo.g.drawString(str,400-strw, 350);

				tInfo.g.setFont(BattlePhase.this.font_s);
				str="PUSH Z to Retry : "+this.leftTime;
				strw=fm.stringWidth(str)/2;
				tInfo.g.drawString(str,760-strw, 400);
			}
		}

		@Override
		public void loadMedia() throws IOException {
			// TODO 自動生成されたメソッド・スタブ
		}

	}


}
