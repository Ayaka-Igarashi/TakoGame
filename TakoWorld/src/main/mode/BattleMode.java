package main.mode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.TWFrame;
import main.TWInfo;
import main.constant.KEY_STATE;
import main.constant.MUSIC_NUM;
import main.items_b.SoundItem_B;
import main.items_b.TWMenu_B;
import main.phase.BattlePhase;
import main.supers.GameMode;
import main.supers.SoundBox;

public class BattleMode extends GameMode {
	private BattlePhase phase=new BattlePhase();
	private TWMenu_B menu = new TWMenu_B();
	private SoundItem_B sound =new SoundItem_B();

	//private Font font = new Font("HG丸ｺﾞｼｯｸM-PRO", Font.PLAIN, 40);

	private BufferedImage img_back;

	public BattleMode() {

	}

	//バトルモードからはエンディングにいかない
	@Override
	public boolean isEnd() {
		return false;
	}

	@Override
	public boolean isExit() {
		return this.menu.isExit()||this.phase.exitFlg;
	}

	@Override
	public boolean isModeChange() {
		return this.phase.clearFlg;
	}

	@Override
	public int getNextScene() {
		return this.phase.nowStage.nextScene;
	}

	@Override
	public void first(TWInfo tInfo,int scene) {
		this.phase.first(tInfo,scene);
		this.menu.first();
		this.sound.first();

	}

	@Override
	public void control(TWInfo tInfo) {
		this.menu.control(tInfo);
		this.sound.control(tInfo);

	}

	@Override
	public void keyControl(TWInfo tInfo) {
		if(this.menu.isMenuTime()==false) {//メニュー画面の時はキー入力無効(controlも)
			this.phase.keyControl(tInfo, -1);
		}

		if(this.phase.canOpenMenu()==true) {
			if (tInfo.keyState[KEY_STATE.Z] == true && tInfo.keyReleased[KEY_STATE.Z] == true) {
				if (this.menu.isMenuTime() == true) {//メニュー画面状態か
					this.menu.keyControl(tInfo, KEY_STATE.Z, 1);
				} else {
				}
				tInfo.keyReleased[KEY_STATE.Z] = false;
			} else if (tInfo.keyState[KEY_STATE.Z] == false && tInfo.keyReleased[KEY_STATE.Z] == false) {
				SoundBox.singleton.stopClip(MUSIC_NUM.CHOICE);//効果音を止める
				tInfo.keyReleased[KEY_STATE.Z] = true;//キーが放された状態にする
			}

			//Xキー
			if (tInfo.keyState[KEY_STATE.X] == true && tInfo.keyReleased[KEY_STATE.X] == true) {
				this.menu.keyControl(tInfo, KEY_STATE.X, 1);
				SoundBox.singleton.playClip(MUSIC_NUM.CHOICE);//効果音を流す
				tInfo.keyReleased[KEY_STATE.X] = false;//キーが放されていない状態にする
			} else if (tInfo.keyState[KEY_STATE.X] == false && tInfo.keyReleased[KEY_STATE.X] == false) {
				SoundBox.singleton.stopClip(MUSIC_NUM.CHOICE);//効果音を止める
				tInfo.keyReleased[KEY_STATE.X] = true;//キーが放された状態にする
			}

			//上キー（選択肢用）
			if (tInfo.keyState[KEY_STATE.UP] == true && tInfo.keyReleased[KEY_STATE.UP] == true) {
				this.menu.keyControl(tInfo, KEY_STATE.UP, 1);
				//SoundBox.singleton.playClip(MUSIC_NUM.CHOICE);//効果音を流す
				tInfo.keyReleased[KEY_STATE.UP] = false;//キーが放されていない状態にする
			} else if (tInfo.keyState[KEY_STATE.UP] == false && tInfo.keyReleased[KEY_STATE.UP] == false) {
				SoundBox.singleton.stopClip(MUSIC_NUM.CHOICE);//効果音を止める
				tInfo.keyReleased[KEY_STATE.UP] = true;//キーが放された状態にする
			}

			//下キー
			if (tInfo.keyState[KEY_STATE.DOWN] == true && tInfo.keyReleased[KEY_STATE.DOWN] == true) {
				this.menu.keyControl(tInfo, KEY_STATE.DOWN, 1);
				//SoundBox.singleton.playClip(MUSIC_NUM.CHOICE);//効果音を流す
				tInfo.keyReleased[KEY_STATE.DOWN] = false;//キーが放されていない状態にする
			} else if (tInfo.keyState[KEY_STATE.DOWN] == false && tInfo.keyReleased[KEY_STATE.DOWN] == false) {
				SoundBox.singleton.stopClip(MUSIC_NUM.CHOICE);//効果音を止める
				tInfo.keyReleased[KEY_STATE.DOWN] = true;//キーが放された状態にする
			}

		}

	}

	@Override
	public void draw(TWInfo tInfo) {
		//this.menu.resetOpenTime();
		this.keyControl(tInfo);
		this.control(tInfo);
		if(this.menu.setTimeFlg==true) {
			this.phase.setMenuTime(this.menu.openTime);
			this.menu.setTimeFlg=false;
		}
		this.phase.setIsMenu(this.menu.isMenuTime());

		tInfo.g.drawImage(this.img_back, 0, TWFrame.title_bar_height, null);
		//tInfo.g.setBackground(Color.BLACK);
		//tInfo.g.setFont(this.font);
		//tInfo.g.drawString("GAME MODE", 100, 100);

		this.phase.draw(tInfo);

		this.menu.draw(tInfo);

	}

	@Override
	public void loadMedia() throws IOException {
		this.phase.loadMedia();
		this.img_back = ImageIO.read(new File("media/haikei_default.png"));

		this.menu.setImage(ImageIO.read(new File("media/menu.png")));
		this.menu.setImage(ImageIO.read(new File("media/menu_arrow.png")));

	}

	@Override
	public void stopBGM() {
		this.sound.stopBGM();
		return;
	}

}
