package main.stage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.TWInfo;
import main.constant.MUSIC_NUM;
import main.constant.SCENE_NUM;
import main.items_b.AttackItem;
import main.items_b.GameChara_B;
import main.items_b.Player;
import main.items_b.Takoyaki;
import main.shot.BulletChara;
import main.supers.SoundBox;

public class Stage1 extends Stage {
	private BufferedImage img_player, img_takoyaki;
	private Player player = new Player();
	private Takoyaki takoyaki = new Takoyaki();
	private AttackItem item = new AttackItem();

	private BufferedImage img_shot;
	public static final int MAX_BULLETS = 200;
	private ArrayList<BulletChara> bullets = new ArrayList<BulletChara>(MAX_BULLETS);
	private ArrayList<BufferedImage> img_bullets = new ArrayList<BufferedImage>();
	public static final int BLUE_BULLET = 0;
	public static final int STAR_BULLET = 1;
	public static final int BLACK_BULLET = 2;

	///////////////set  &  get  ////////////////
	@Override
	public GameChara_B getPlayer() {
		return this.player;
	}

	@Override
	public GameChara_B getEnemy() {
		return this.takoyaki;
	}

	@Override
	public ArrayList<BulletChara> getBullets() {
		return this.bullets;
	}

	@Override
	public BufferedImage getBulletImage(int type) {
		return this.img_bullets.get(type);
	}
	////////////////////////////////////////////

	public Stage1() {
		this.nextScene = SCENE_NUM.ONE;
	}

	@Override
	public void first(TWInfo tInfo) {
		this.player.first();
		this.takoyaki.first();
		this.item.first(tInfo);
		this.IsReStart = false;

		this.bullets.clear();
		for (int i = 0; i < MAX_BULLETS; i++) {
			this.bullets.add(new BulletChara());
		}

	}

	@Override
	public void loadMedia() throws IOException {
		this.img_player = ImageIO.read(new File("media/battle/same_mini.png"));
		this.player.setImage(this.img_player.getSubimage(0, 0, 51, 75));
		this.player.setImage(this.img_player.getSubimage(51, 0, 51, 75));
		this.player.setImage(this.img_player.getSubimage(102, 0, 54, 75));
		this.player.attackAnim.setImage(ImageIO.read(new File("media/battle/attack.png")));
		this.player.attackAnim.setAnimation(3, 3, 9, 60);
		this.player.spAttackAnim.setImage(ImageIO.read(new File("media/battle/attack_sp.png")));
		this.player.spAttackAnim.setAnimation(1, 15, 15, 60);

		this.img_takoyaki = ImageIO.read(new File("media/battle/たこ焼き.png"));
		this.takoyaki.setImage(this.img_takoyaki.getSubimage(0, 0, 125, 100));
		this.takoyaki.setImage(this.img_takoyaki.getSubimage(125, 0, 125, 100));
		this.takoyaki.setImage(this.img_takoyaki.getSubimage(250, 0, 125, 100));
		this.item.setImage(ImageIO.read(new File("media/battle/attackItem.png")).getSubimage(0, 0, 50, 50));

		this.img_shot = ImageIO.read(new File("media/battle/bullet.png"));
		this.img_bullets.add(this.img_shot.getSubimage(0, 0, 30, 30));
		this.img_bullets.add(this.img_shot.getSubimage(30, 0, 30, 30));
		this.img_bullets.add(this.img_shot.getSubimage(60, 0, 30, 30));

	}

	@Override
	public void control(TWInfo tInfo) {
		this.player.control(tInfo);
		this.takoyaki.control(tInfo);
		this.item.control(tInfo);
		if (this.hitBoss() == true || this.hitBullet(tInfo) == true) {
			if (this.player.isInvincible == false) {
				this.player.hitBoss();
				this.IsReStart = true;
				SoundBox.singleton.playClip(MUSIC_NUM.DEAD);
			}
		}
		if (this.hitItem() == true) {
			this.player.hitItem();
			this.item.got();
			SoundBox.singleton.playClip(MUSIC_NUM.GET);
		}
		if (this.hitAttack() == true && this.player.attackAnim.isJudge == true) {
			this.takoyaki.hitAttack(10);
			this.player.attackAnim.isJudge = false;
			SoundBox.singleton.playClip(MUSIC_NUM.HIT);
		} else if (this.hitAttack() == false && this.player.attackAnim.isJudge == true) {
			this.player.attackAnim.isJudge = false;
			SoundBox.singleton.playClip(MUSIC_NUM.ATTACK);
		}
		if (this.player.spAttackAnim.isJudge == true) {
			this.takoyaki.hitAttack(30);
			this.player.spAttackAnim.isJudge = false;
			SoundBox.singleton.playClip(MUSIC_NUM.BOMB);
			this.removeAllBullets();
		}
	}

	@Override
	public void draw(TWInfo tInfo) {
		this.takoyaki.draw(tInfo, this);
		this.item.draw(tInfo);
		this.player.draw(tInfo);

		for (int i = 0; i < MAX_BULLETS; i++) {
			if (this.bullets.get(i).visible == true) {
				this.bullets.get(i).draw(tInfo, this, isMenuTime);
			}
		}
	}

	@Override
	public void startMotion(TWInfo tInfo) {
		this.player.enter(tInfo, 100, 2000);
	}

	@Override
	public void reStart(TWInfo tInfo) {
		this.player.enter(tInfo, 190, 1500);
	}

	@Override
	public boolean hitBoss() {
		return this.hitTest(this.takoyaki, this.player);
	}

	@Override
	public boolean hitItem() {
		return this.hitTest(this.item, this.player);
	}

	@Override
	public boolean hitAttack() {
		return this.hitTest(this.takoyaki, this.player.attackAnim);
	}

	@Override
	public boolean hitBullet(TWInfo tInfo) {
		for (int i = 0; i < MAX_BULLETS; i++) {
			if (this.bullets.get(i).visible == true) {
				if (this.hitTest(this.bullets.get(i), this.player) == true) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void init(TWInfo tInfo) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public boolean isPlayerAlive() {
		return this.player.life > 0;
	}

	@Override
	public boolean isBossLiving() {
		return this.takoyaki.isAlive;
	}

	/*
		public void setMenuTime(long openTime) {
			//this.menuTime+=openTime;
			//this.item.menuTime = openTime;
			//this.player.attackAnim.menuTime += openTime;
			//this.player.spAttackAnim.menuTime += openTime;
			//this.takoyaki.menuTime+=openTime;

		}
	*/

	@Override
	public void setIsMenuTime(boolean isMenuTime) {
		this.isMenuTime = isMenuTime;
		this.player.attackAnim.isMenuTime = isMenuTime;
		this.player.spAttackAnim.isMenuTime = isMenuTime;
		this.takoyaki.isMenuTime = isMenuTime;
	}

	@Override
	public void removeAllBullets() {
		for (int i = 0; i < MAX_BULLETS; i++) {
			this.bullets.get(i).visible = false;
		}

	}

}
