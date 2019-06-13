package main.mode;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.constant.MUSIC_NUM;
import main.items_b.Player;
import main.items_b.SoundItem_B;
import main.items_b.TWMenu_B;
import main.supers.GameMode;
import main.supers.SoundBox;

public class BattleMode extends GameMode {
	private TWMenu_B menu = new TWMenu_B();
	private SoundItem_B sound =new SoundItem_B();
	private Player player =new Player();

	private Font font = new Font("HG丸ｺﾞｼｯｸM-PRO", Font.PLAIN, 40);
	private boolean endFlg = false;

	private BufferedImage img_test;

	@Override
	public boolean isEnd() {
		if (this.endFlg == true) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isExit() {
		return this.menu.isExit();
	}

	@Override
	public void first(TWInfo tInfo) {
		this.endFlg = false;
		this.menu.first();
		this.sound.first();
		this.player.first();

	}

	@Override
	public void control(TWInfo tInfo) {
		this.menu.control(tInfo);
		this.sound.control(tInfo);
		this.player.control(tInfo);

	}

	@Override
	public void keyControl(TWInfo tInfo) {
		if (tInfo.keyState[KEY_STATE.Z] == true && tInfo.keyReleased[KEY_STATE.Z] == true) {
			if (this.menu.isMenuTime() == true) {//メニュー画面状態か
				this.menu.keyControl(tInfo, KEY_STATE.Z, 1);
			} else {
				this.player.keyControl(tInfo, KEY_STATE.Z, 0);
				this.endFlg = true;
			}
			SoundBox.singleton.playClip(MUSIC_NUM.CHOICE);//効果音を流す
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
			SoundBox.singleton.playClip(MUSIC_NUM.CHOICE);//効果音を流す
			tInfo.keyReleased[KEY_STATE.UP] = false;//キーが放されていない状態にする
		} else if (tInfo.keyState[KEY_STATE.UP] == false && tInfo.keyReleased[KEY_STATE.UP] == false) {
			SoundBox.singleton.stopClip(MUSIC_NUM.CHOICE);//効果音を止める
			tInfo.keyReleased[KEY_STATE.UP] = true;//キーが放された状態にする
		}

		//下キー
		if (tInfo.keyState[KEY_STATE.DOWN] == true && tInfo.keyReleased[KEY_STATE.DOWN] == true) {
			this.menu.keyControl(tInfo, KEY_STATE.DOWN, 1);
			SoundBox.singleton.playClip(MUSIC_NUM.CHOICE);//効果音を流す
			tInfo.keyReleased[KEY_STATE.DOWN] = false;//キーが放されていない状態にする
		} else if (tInfo.keyState[KEY_STATE.DOWN] == false && tInfo.keyReleased[KEY_STATE.DOWN] == false) {
			SoundBox.singleton.stopClip(MUSIC_NUM.CHOICE);//効果音を止める
			tInfo.keyReleased[KEY_STATE.DOWN] = true;//キーが放された状態にする
		}

	}

	@Override
	public void draw(TWInfo tInfo) {
		this.keyControl(tInfo);
		this.control(tInfo);

		tInfo.g.drawImage(this.img_test, 0, 0, null);
		tInfo.g.setBackground(Color.BLACK);
		tInfo.g.setFont(this.font);
		tInfo.g.drawString("GAME MODE", 100, 100);

		this.menu.draw(tInfo);
		this.player.draw(tInfo);

	}

	@Override
	public void loadMedia() throws IOException {
		this.img_test = ImageIO.read(new File("media/logo.png"));

		this.player.setImage(ImageIO.read(new File("media/same_mini.png")));

		this.menu.setImage(ImageIO.read(new File("media/menu.png")));
		this.menu.setImage(ImageIO.read(new File("media/menu_arrow.png")));

	}

	@Override
	public void stopBGM() {
		return;
	}

}
