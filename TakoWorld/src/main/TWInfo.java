package main;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class TWInfo {
	public Graphics2D g;
	public double frameTime;
	public long currentTime;
	public long pushTime;//最後にボタンを押した時間
	public boolean[] keyState;
	public boolean[] keyReleased;//キーが押された後はなされたか

	public boolean isLoad;//ロードをするか

	public TextMode modeInfo;//現在のゲームデータ
	private int[] textModeInfo=new int[3];//現在のゲームデータprivate

	public int[] choice=new int[5];//選択したもの

	public TWInfo() {
		this.keyState=new boolean[8];
		this.keyReleased=new boolean[8];
		this.isLoad=false;
		for(int i=0;i<8;i++) {
			this.keyState[i]=false;
			this.keyReleased[i]=true;//放された後ということにする
		}

		for(int i=0;i<5;i++) {
			this.choice[i]=-1;
		}

		this.pushTime=System.currentTimeMillis();
	}

	//セーブ時に情報の変換をする
	private void dataConvert() {
		textModeInfo[0]=this.modeInfo.getPushNumZ();
		textModeInfo[1]=this.modeInfo.getTextNum();
		textModeInfo[2]=this.modeInfo.getNowScene();
	}

	//ロード時にtextmodeを書き換える
	private void dataApply() {
		this.modeInfo.setPushNumZ(textModeInfo[0]);
		this.modeInfo.setTextNum(textModeInfo[1]);
		this.modeInfo.changeScene(textModeInfo[2]);
		this.modeInfo.getText().setNowTextNum(textModeInfo[1]);
	}

	//セーブ
	public void save() {
		this.dataConvert();
		try {
			FileWriter fw=new FileWriter("saveData.txt");
			fw.write(this.textModeInfo[0]+"\n"+this.textModeInfo[1]+"\n"+this.textModeInfo[2]);
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
			for(int i=0;i<3;i++) {//
				String str=br.readLine();
				this.textModeInfo[i]=Integer.parseInt(str);
				System.out.println(this.textModeInfo[i]);
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			JOptionPane.showInputDialog("ロードできません");
		}
		//this.isLoad=true;
		this.dataApply();
		return;
	}

}
