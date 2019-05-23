package main.supers;

import java.util.ArrayList;

import main.Action;

//イベントを作成する親クラス
public class TWEvent {
	protected int label;//シーンのラベル
	protected ArrayList<ArrayList<Action>> A=new ArrayList<ArrayList<Action>>();

	//イベントを返す
	public ArrayList<ArrayList<Action>> getEvent(){
		return this.A;
	}
}
