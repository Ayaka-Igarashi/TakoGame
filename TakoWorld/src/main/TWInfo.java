package main;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import main.constant.KEY_STATE;
import main.constant.SAVE_DATA;
import main.mode.TextMode;

public class TWInfo {
	public Graphics2D g;
	public double frameTime;
	public long currentTime;
	public long currentTime_withoutMenu;//メニュー画面抜きの時間
	public long pushTime;//最後にボタンを押した時間
	public boolean[] keyState;
	public boolean[] keyReleased;//キーが押された後はなされたか

	public TextMode textModeInfo;//現在のゲームデータ
	private int[] saveData=new int[SAVE_DATA.NUM];//セーブデータ

	public int[] choice=new int[5];//選択したもの

	//初期化
	public TWInfo() {
		this.keyState=new boolean[KEY_STATE.NUM];
		this.keyReleased=new boolean[KEY_STATE.NUM];
		for(int i=0;i<this.keyState.length;i++) {
			this.keyState[i]=false;
			this.keyReleased[i]=true;//放された後ということにする
		}

		for(int i=0;i<this.choice.length;i++) {
			this.choice[i]=-1;
		}

		//////////////////////この初期化は消すべし//////////////////////////////////////////////////
		for(int i=0;i<this.saveData.length;i++) {
			this.saveData[i]=-1;
		}


		this.pushTime=System.currentTimeMillis();
	}

	//セーブ時に情報の変換をする
	private void dataConvert() {
		saveData[SAVE_DATA.PUSHNUM_Z]=this.textModeInfo.getPushNumZ();
		saveData[SAVE_DATA.TEXT_NUM]=this.textModeInfo.getTextNum();
		saveData[SAVE_DATA.SCENE_NUM]=this.textModeInfo.getNowScene();
		saveData[SAVE_DATA.CHOICE_TIME]=this.textModeInfo.getChoice().getChoiceTimeInt();
		saveData[SAVE_DATA.CHOICE_TEXT]=this.textModeInfo.getChoice().getChoiceText();

		saveData[SAVE_DATA.HAIKEI]=this.textModeInfo.getHaikei().nowState;
		saveData[SAVE_DATA.HOTATE]=this.textModeInfo.getHotate().nowState;
		saveData[SAVE_DATA.SAME]=this.textModeInfo.getCharaSame().nowState;
		saveData[SAVE_DATA.ENEMY]=this.textModeInfo.getEnemy().nowState;
		saveData[SAVE_DATA.BGM]=this.textModeInfo.getSound().nowState;
	}

	//ロード時にtextmodeを書き換える
	private void dataApply() {
		this.textModeInfo.setPushNumZ(saveData[SAVE_DATA.PUSHNUM_Z]);
		this.textModeInfo.setTextNum(saveData[SAVE_DATA.TEXT_NUM]);
		this.textModeInfo.changeScene(saveData[SAVE_DATA.SCENE_NUM]);
		this.textModeInfo.getText().setNowTextNum(saveData[SAVE_DATA.TEXT_NUM]);
		this.textModeInfo.getChoice().applyChoiceTime(saveData[SAVE_DATA.CHOICE_TIME],saveData[SAVE_DATA.CHOICE_TEXT]);

		this.textModeInfo.getHaikei().nowState=saveData[SAVE_DATA.HAIKEI];
		this.textModeInfo.getHaikei().isChange=true;
		this.textModeInfo.getHotate().nowState=saveData[SAVE_DATA.HOTATE];
		this.textModeInfo.getHotate().isChange=true;
		this.textModeInfo.getCharaSame().nowState=saveData[SAVE_DATA.SAME];
		this.textModeInfo.getCharaSame().isChange=true;
		this.textModeInfo.getEnemy().nowState=saveData[SAVE_DATA.ENEMY];
		this.textModeInfo.getEnemy().isChange=true;

		if(this.textModeInfo.getSound().nowState!=saveData[SAVE_DATA.BGM]) {//違うbgmだったらロード
			this.textModeInfo.getSound().nowState=saveData[SAVE_DATA.BGM];
			this.textModeInfo.getSound().isChange=true;
		}
	}

	//セーブ
	public void save() {
		this.dataConvert();
		try {
			FileWriter fw=new FileWriter("saveData.txt");
			for(int i=0;i<this.saveData.length;i++) {
				fw.write(this.saveData[i]+"\n");
			}
			fw.close();
		} catch (IOException e) {
			JOptionPane.showInputDialog("セーブできません");
		}
		return;
	}

	//ロード
	public void load() {
		try {
			FileReader fr =new FileReader("saveData.txt");
			BufferedReader br=new BufferedReader(fr);
			for(int i=0;i<this.saveData.length;i++) {
				String str=br.readLine();
				this.saveData[i]=Integer.parseInt(str);
				System.out.println("save "+i+" : "+this.saveData[i]);
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			JOptionPane.showInputDialog("ロードできません");
		}
		this.dataApply();
		return;
	}

}
