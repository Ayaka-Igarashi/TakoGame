package main.phase;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.stage.Stage;
import main.stage.Stage1;

public class BattlePhase {
	BattlePhase start,main,clear,lose;
	private BattlePhase nowPhase=null;
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



	public class StartPhase extends BattlePhase {

		public StartPhase() {

		}

		@Override
		public void first() {
			this.nowStage.first();

		}

		@Override
		public void keyControl(TWInfo tInfo,int key) {
			// TODO 自動生成されたメソッド・スタブ

		}

		@Override
		public void draw(TWInfo tInfo) {
			// TODO 自動生成されたメソッド・スタブ

		}

	}

	public class MainPhase extends BattlePhase {

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
			// TODO 自動生成されたメソッド・スタブ

		}

	}

	public class ClearPhase extends BattlePhase {

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
			// TODO 自動生成されたメソッド・スタブ

		}

	}

	public class LosePhase extends BattlePhase {

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
			// TODO 自動生成されたメソッド・スタブ

		}

	}




}
