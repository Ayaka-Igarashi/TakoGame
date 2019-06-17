package main.phase;

import java.io.IOException;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.stage.Stage;
import main.stage.Stage1;
import main.supers.GamePhase;

public class BattlePhase extends GamePhase{
	GamePhase start,main,clear,lose;
	private GamePhase nowPhase=null;
	Stage nowStage =new Stage1();

	public BattlePhase(){
		this.start=new StartPhase();
		this.main=new MainPhase();
		this.clear=new ClearPhase();
		this.lose=new LosePhase();
	}

	public void first() {
		this.nowPhase=start;
		this.nowPhase.first();
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



	public class StartPhase extends GamePhase {

		public StartPhase() {

		}

		@Override
		public void first() {
			BattlePhase.this.nowStage.first();

		}

		@Override
		public void keyControl(TWInfo tInfo,int key) {
			BattlePhase.this.nowStage.getPlayer().keyControl(tInfo,-1, -1);

		}

		@Override
		public void draw(TWInfo tInfo) {
			BattlePhase.this.nowStage.draw(tInfo);

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
		public void first() {
			// TODO 自動生成されたメソッド・スタブ

		}

		@Override
		public void keyControl(TWInfo tInfo,int key) {
			if (key==KEY_STATE.Z) {

			}

		}

		@Override
		public void draw(TWInfo tInfo) {
			BattlePhase.this.nowStage.draw(tInfo);

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
		public void first() {
			// TODO 自動生成されたメソッド・スタブ

		}

		@Override
		public void keyControl(TWInfo tInfo,int key) {
			// TODO 自動生成されたメソッド・スタブ

		}

		@Override
		public void draw(TWInfo tInfo) {
			BattlePhase.this.nowStage.draw(tInfo);

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
		public void first() {
			// TODO 自動生成されたメソッド・スタブ

		}

		@Override
		public void keyControl(TWInfo tInfo,int key) {
			// TODO 自動生成されたメソッド・スタブ

		}

		@Override
		public void draw(TWInfo tInfo) {
			BattlePhase.this.nowStage.draw(tInfo);

		}

		@Override
		public void loadMedia() throws IOException {
			// TODO 自動生成されたメソッド・スタブ

		}

	}



}
