package main.supers;

import java.util.ArrayList;

import main.TWInfo;
import main.constant.ITEM_NUM;
import main.items.CharaSame;
import main.items.Haikei;
import main.items.Hotate;
import main.struct.Action;
import main.struct.TextChara;

//イベントを作成する親クラス
public abstract class TWEvent {
	protected int label;//シーンのラベル
	protected int next;//次のシーンのラベル
	protected String[][] sceneText;
	protected TextChara[] sceneTextChara;//
	protected ArrayList<ArrayList<Action>> A=new ArrayList<ArrayList<Action>>();

	//イベント内容作成
	protected Action nextText=new Action(ITEM_NUM.TEXT,1);

	protected Action b_nm=new Action(ITEM_NUM.BACK, Haikei.BLUE);
	protected Action b_pp=new Action(ITEM_NUM.BACK, Haikei.PURPLE);
	protected Action h_rm=new Action(ITEM_NUM.HOTATE,Hotate.REMOVE);

	protected Action h_nm_h= new Action(ITEM_NUM.HOTATE,Hotate.NORMAL_HUMAN);
	protected Action h_sw_h=new Action(ITEM_NUM.HOTATE,Hotate.SWEATED_HUMAN);
	protected Action h_nmL=new Action(ITEM_NUM.HOTATE,Hotate.NORMAL_L);
	protected Action h_nmR=new Action(ITEM_NUM.HOTATE,Hotate.NORMAL_R);
	protected Action h_activeL=new Action(ITEM_NUM.HOTATE,Hotate.ACTIVE_L);
	protected Action h_activeR=new Action(ITEM_NUM.HOTATE,Hotate.ACTIVE_R);
	protected Action h_cryL=new Action(ITEM_NUM.HOTATE,Hotate.CRY_L);
	protected Action h_cryR=new Action(ITEM_NUM.HOTATE,Hotate.CRY_R);
	protected Action h_happyL=new Action(ITEM_NUM.HOTATE,Hotate.HAPPY_L);
	protected Action h_happyR=new Action(ITEM_NUM.HOTATE,Hotate.HAPPY_R);
	protected Action h_lazyL=new Action(ITEM_NUM.HOTATE,Hotate.LAZY_L);
	protected Action h_lazyR=new Action(ITEM_NUM.HOTATE,Hotate.LAZY_R);
	protected Action h_seriousL=new Action(ITEM_NUM.HOTATE,Hotate.SERIOUS_L);
	protected Action h_seriousR=new Action(ITEM_NUM.HOTATE,Hotate.SERIOUS_R);

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

	public TextChara[] getTextChara() {
		return this.sceneTextChara;
	}

	public abstract void branch(TWInfo tInfo);

	public boolean isFinished(int pushNum) {
		if(pushNum==A.size()) {
			return true;
		}
		return false;
	}
}
