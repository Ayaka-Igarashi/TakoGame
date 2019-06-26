package main.pattern;

import main.TWInfo;
import main.stage.Stage;

public abstract class Pattern {
		protected Pattern next=null;//次のパターン
		protected long limit,starttime;//時間制限

		///////get,set////////
		public void setNext(Pattern pt) {
			this.next=pt;
		}
		public Pattern getNext() {
			return this.next;
		}

		public void setLimit(long l) {
			this.limit=l;
		}
		///////////////////////


		//開始時間の記録
		public void start(TWInfo tInfo) {
			this.starttime=tInfo.currentTime_withoutMenu;
		}

		//終了判定
		public abstract boolean isFinished(TWInfo tInfo);
		public abstract void move(TWInfo tInfo,Stage stage);
}
