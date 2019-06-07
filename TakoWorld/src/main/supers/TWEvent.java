package main.supers;

import java.util.ArrayList;

import main.Action;
import main.TWInfo;
import main.constant.ITEM_NUM;
import main.items.CharaSame;
import main.items.Haikei;
import main.items.Hotate;

//イベントを作成する親クラス
public abstract class TWEvent {
	protected int label;//シーンのラベル
	protected int next;//次のシーンのラベル
	protected String[][] sceneText;
	protected ArrayList<ArrayList<Action>> A=new ArrayList<ArrayList<Action>>();

	//イベント内容作成
	protected Action nextText=new Action(ITEM_NUM.TEXT,1);
	protected Action b_nm=new Action(ITEM_NUM.BACK, Haikei.BLUE);
	protected Action b_pp=new Action(ITEM_NUM.BACK, Haikei.PURPLE);
	protected Action h_rm=new Action(ITEM_NUM.HOTATE,Hotate.REMOVE);
	protected Action h_nm= new Action(ITEM_NUM.HOTATE,Hotate.NORMAL);
	protected Action h_sw=new Action(ITEM_NUM.HOTATE,Hotate.SWEATED);
	protected Action s_rm=new Action(ITEM_NUM.SAME,CharaSame.REMOVE);
	protected Action s_nmL=new Action(ITEM_NUM.SAME,CharaSame.NORMAL_L);
	protected Action s_nmR=new Action(ITEM_NUM.SAME,CharaSame.NORMAL_R);

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

	public boolean isFinished(int pushNum) {
		if(pushNum==A.size()) {
			return true;
		}
		return false;
	}
}
