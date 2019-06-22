package main.phase;

import java.awt.Color;
import java.io.IOException;

import main.TWInfo;
import main.stage.Stage;
import main.stage.Stage1;
import main.supers.GamePhase;

public class BattlePhase extends GamePhase{
	GamePhase start,main,reStart,clear,lose;
	private GamePhase nowPhase=null;
	public Stage nowStage =new Stage1();

	protected long menuTime;
	protected boolean isMenuTime;

	public BattlePhase(){
		this.start=new StartPhase();
		this.main=new MainPhase();
		this.reStart=new ReStartPhase();
		this.clear=new ClearPhase();
		this.lose=new LosePhase();
	}

	//スタートするたびに実行
	public void first(TWInfo tInfo) {
		this.nowPhase=start;
		this.nowPhase.first(tInfo);
		this.menuTime=0;
	}

	public void keyControl(TWInfo tInfo,int key) {
		this.nowPhase.keyControl(tInfo, key);

	}

	public void draw(TWInfo tInfo) {
		this.nowPhase.draw(tInfo);
	}

	@Override
	public void loadMedia() throws IOException {
		this.nowStage.loadMedia();

		//this.start.loadMedia();
		//this.main.loadMedia();
		//this.clear.loadMedia();
		//this.lose.loadMedia();

	}

	public void setMenuTime(long openTime) {
		this.nowStage.setMenuTime(openTime);
		this.menuTime=openTime;
	}
	public void setIsMenu(boolean menuTime) {
		this.isMenuTime=menuTime;
		this.nowStage.setIsMenuTime(menuTime);

	}



	public class StartPhase extends GamePhase {

		public StartPhase() {

		}

		//スタート押すたびに実行
		@Override
		public void first(TWInfo tInfo) {
			BattlePhase.this.nowStage.first(tInfo);
			this.startTime=tInfo.currentTime;
		}

		@Override
		public void keyControl(TWInfo tInfo,int key) {
			//BattlePhase.this.nowStage.control(tInfo);
			//BattlePhase.this.nowStage.getPlayer().keyControl(tInfo,-1, -1);
			BattlePhase.this.nowStage.startMotion(tInfo);

			if(tInfo.currentTime-this.startTime-BattlePhase.this.menuTime>1200) {
				BattlePhase.this.nowPhase=main;
			}

		}

		@Override
		public void draw(TWInfo tInfo) {

			BattlePhase.this.nowStage.draw(tInfo);
			tInfo.g.setBackground(Color.BLACK);
			tInfo.g.drawString("START", 100, 100);



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
		public void first(TWInfo tInfo) {
			// TODO 自動生成されたメソッド・スタブ

		}

		@Override
		public void keyControl(TWInfo tInfo,int key) {
			BattlePhase.this.nowStage.control(tInfo);
			BattlePhase.this.nowStage.getPlayer().keyControl(tInfo,-1, -1);

			if(BattlePhase.this.nowStage.isPlayerAlive()==false) {
				BattlePhase.this.nowPhase=lose;
			}else if(BattlePhase.this.nowStage.IsReStart==true) {
				BattlePhase.this.nowPhase=reStart;
				BattlePhase.this.nowPhase.first(tInfo);
				BattlePhase.this.nowStage.IsReStart=false;
			}

		}

		@Override
		public void draw(TWInfo tInfo) {
			BattlePhase.this.nowStage.draw(tInfo);
			tInfo.g.setBackground(Color.BLACK);
			tInfo.g.drawString("Main", 100, 100);

		}

		@Override
		public void loadMedia() throws IOException {
			// TODO 自動生成されたメソッド・スタブ

		}

	}

	public class ReStartPhase extends GamePhase {

		@Override
		public void first(TWInfo tInfo) {
			this.startTime=tInfo.currentTime;
		}

		@Override
		public void keyControl(TWInfo tInfo, int key) {
			BattlePhase.this.nowStage.control(tInfo);
			BattlePhase.this.nowStage.reStart(tInfo);

			if(tInfo.currentTime-this.startTime-BattlePhase.this.menuTime>1000) {
				BattlePhase.this.nowPhase=main;
			}

		}

		@Override
		public void draw(TWInfo tInfo) {
			BattlePhase.this.nowStage.draw(tInfo);
			tInfo.g.setBackground(Color.BLACK);
			tInfo.g.drawString("reSTART", 100, 100);

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
		public void first(TWInfo tInfo) {
			// TODO 自動生成されたメソッド・スタブ

		}

		@Override
		public void keyControl(TWInfo tInfo,int key) {
			// TODO 自動生成されたメソッド・スタブ

		}

		@Override
		public void draw(TWInfo tInfo) {
			BattlePhase.this.nowStage.draw(tInfo);
			tInfo.g.setBackground(Color.BLACK);
			tInfo.g.drawString("CLEAR", 100, 100);
		}

		@Override
		public void loadMedia() throws IOException {
			// TODO 自動生成されたメソッド・スタブ

		}

	}

	public class LosePhase extends GamePhase {
		public LosePhase() {
		}

		@Override
		public void first(TWInfo tInfo) {
			// TODO 自動生成されたメソッド・スタブ

		}

		@Override
		public void keyControl(TWInfo tInfo,int key) {
			// TODO 自動生成されたメソッド・スタブ

		}

		@Override
		public void draw(TWInfo tInfo) {
			BattlePhase.this.nowStage.draw(tInfo);
			tInfo.g.setBackground(Color.BLACK);
			tInfo.g.drawString("GAME OVER", 100, 100);

		}

		@Override
		public void loadMedia() throws IOException {
			// TODO 自動生成されたメソッド・スタブ

		}

	}





}
