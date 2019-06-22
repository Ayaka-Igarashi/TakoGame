package main.stage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.TWInfo;
import main.constant.MUSIC_NUM;
import main.functions.Vector;
import main.items_b.AttackItem;
import main.items_b.GameChara_B;
import main.items_b.Player;
import main.items_b.Takoyaki;
import main.supers.SoundBox;

public class Stage1 extends Stage {
	private Player player =new Player();
	private Takoyaki takoyaki=new Takoyaki();
	private AttackItem item=new AttackItem();

	///////////////set  &  get  ////////////////
	@Override
	public GameChara_B getPlayer() {
		return this.player;
	}
	@Override
	public GameChara_B getEnemy() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


	////////////////////////////////////////////

	@Override
	public void first(TWInfo tInfo) {
		this.player.first();
		this.takoyaki.first();
		this.item.first(tInfo);
		this.IsReStart=false;

	}


	@Override
	public void loadMedia() throws IOException {
		this.player.setImage(ImageIO.read(new File("media/battle/same_mini.png")).getSubimage(0, 0, 70, 100));
		this.player.attackAnim.setImage(ImageIO.read(new File("media/battle/attack.png")));
		this.player.attackAnim.setAnimation(3, 3, 9, 60);
		this.takoyaki.setImage(ImageIO.read(new File("media/battle/たこ焼き.png")).getSubimage(0, 0, 110, 100));
		this.item.setImage(ImageIO.read(new File("media/battle/attackItem.png")).getSubimage(0, 0, 50, 50));

	}


	@Override
	public void control(TWInfo tInfo) {
		this.player.control(tInfo);
		this.item.control(tInfo);
		if(this.hitBoss()==true) {
			this.player.hitBoss();
			this.IsReStart=true;
			SoundBox.singleton.playClip(MUSIC_NUM.DEAD);
		}
		if(this.hitItem()==true) {
			this.player.hitItem();
			this.item.got();
			SoundBox.singleton.playClip(MUSIC_NUM.GET);
		}
	}

	@Override
	public void draw(TWInfo tInfo) {
		this.takoyaki.draw(tInfo);
		this.item.draw(tInfo);
		this.player.draw(tInfo);

	}

	@Override
	public void startMotion(TWInfo tInfo) {
		this.player.enter(tInfo);
	}


	@Override
	public void reStart(TWInfo tInfo) {
		this.player.enter(tInfo);
	}

	@Override
	public boolean hitBoss() {
		return Vector.distance(this.takoyaki.position, this.player.position)<=this.takoyaki.size+this.player.size;
	}

	@Override
	public boolean hitItem() {
		return Vector.distance(this.item.position, this.player.position)<=this.item.size+this.player.size;
	}



	@Override
	public void init(TWInfo tInfo) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public boolean isPlayerAlive() {
		return this.player.life>0;
	}

	@Override
	public boolean isBossLiving() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public void setMenuTime(long openTime) {
		this.item.menuTime=openTime;
		this.player.attackAnim.menuTime=openTime;

	}
	@Override
	public void setIsMenuTime(boolean isMenuTime) {
		this.player.attackAnim.isMenuTime=isMenuTime;
	}



}
