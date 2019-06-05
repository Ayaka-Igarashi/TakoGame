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

	public TextMode textModeInfo;//現在のゲームデータ
	private int[] saveData=new int[3];//セーブデータ

	public int[] choice=new int[5];//選択したもの

	public TWInfo() {
		this.keyState=new boolean[8];
		this.keyReleased=new boolean[8];
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
		saveData[0]=this.textModeInfo.getPushNumZ();
		saveData[1]=this.textModeInfo.getTextNum();
		saveData[2]=this.textModeInfo.getNowScene();
	}

	//ロード時にtextmodeを書き換える
	private void dataApply() {
		this.textModeInfo.setPushNumZ(saveData[0]);
		this.textModeInfo.setTextNum(saveData[1]);
		this.textModeInfo.changeScene(saveData[2]);
		this.textModeInfo.getText().setNowTextNum(saveData[1]);
	}

	//セーブ
	public void save() {
		this.dataConvert();
		try {
			FileWriter fw=new FileWriter("saveData.txt");
			fw.write(this.saveData[0]+"\n"+this.saveData[1]+"\n"+this.saveData[2]);
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
				this.saveData[i]=Integer.parseInt(str);
				System.out.println(this.saveData[i]);
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
