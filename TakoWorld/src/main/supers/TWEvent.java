package main.supers;

import java.util.ArrayList;

import main.Action;
import main.TWInfo;

//イベントを作成する親クラス
public abstract class TWEvent {
	protected int label;//シーンのラベル
	protected int next;//次のシーンのラベル
	protected String[][] sceneText;
	protected ArrayList<ArrayList<Action>> A=new ArrayList<ArrayList<Action>>();

	//イベントを返す
	public ArrayList<ArrayList<Action>> getEvent(){
		return this.A;
	}

	public int getNext() {
		return this.next;
	}

	public String[][] getText(){
		return this.sceneText;
	}

	public abstract void branch(TWInfo tInfo);

	public abstract boolean isFinished(int pushNum);
}
