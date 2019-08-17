package main.stage;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.TWInfo;
import main.constant.MUSIC_NUM;
import main.constant.SCENE_NUM;
import main.functions.Vector;
import main.items_b.AttackItem;
import main.items_b.GameChara_B;
import main.items_b.Player;
import main.items_b.Takoyaki;
import main.shot.BulletChara;
import main.supers.SoundBox;

public class Stage2 extends Stage {
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

	public Stage2() {
		this.nextScene = SCENE_NUM.INTRO;
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
		this.img_player = ImageIO.read(new File("media/battle/player.png"));
		this.player.setImage(this.img_player.getSubimage(0, 0, 90, 90));
		this.player.setImage(this.img_player.getSubimage(0, 90, 90, 90));
		this.player.setImage(this.img_player.getSubimage(0, 90*2, 90, 90));
		this.player.setImage(this.img_player.getSubimage(90, 0, 90, 90));
		this.player.setImage(this.img_player.getSubimage(90, 90, 90, 90));
		this.player.setImage(this.img_player.getSubimage(90, 90*2, 90, 90));
		this.player.setImage(this.img_player.getSubimage(90*2, 0, 90, 90));
		this.player.setImage(this.img_player.getSubimage(90*2, 90, 90, 90));
		this.player.setImage(this.img_player.getSubimage(90*2, 90*2, 90, 90));

		//this.player.attackAnim.setImage(ImageIO.read(new File("media/battle/attack2.png")));
		//this.player.attackAnim.setAnimation(3, 3, 9, 60);
		this.player.attackAnim.setImage(ImageIO.read(new File("media/battle/attackanim.png")));
		this.player.attackAnim.setAnimation(4, 1, 4, 60);
		this.player.spAttackAnim.setImage(ImageIO.read(new File("media/battle/attack_sp.png")));
		this.player.spAttackAnim.setAnimation(1, 15, 15, 60);

		this.player.lifeMeter.setImage(ImageIO.read(new File("media/battle/life_back.png")));
		this.player.lifeMeter.setImage(ImageIO.read(new File("media/battle/life1.png")));
		this.player.lifeMeter.setImage(ImageIO.read(new File("media/battle/life2.png")));
		this.player.lifeMeter.setImage(ImageIO.read(new File("media/battle/life3.png")));
		//this.player.lifeMeter.setImage(ImageIO.read(new File("media/battle/playerLife.png")));

		this.img_takoyaki = ImageIO.read(new File("media/battle/たこ焼き2.png"));
		this.takoyaki.setImage(this.img_takoyaki.getSubimage(0, 0, 100, 100));
		this.takoyaki.setImage(this.img_takoyaki.getSubimage(100, 0, 100, 100));
		this.takoyaki.setImage(this.img_takoyaki.getSubimage(200, 0, 100, 100));
		this.item.setImage(ImageIO.read(new File("media/battle/attackItem.png")).getSubimage(0, 0, 50, 50));

		this.img_shot = ImageIO.read(new File("media/battle/bullet.png"));
		this.img_bullets.add(this.img_shot.getSubimage(0, 0, 27, 27));
		this.img_bullets.add(this.img_shot.getSubimage(0, 27, 27, 27));
		this.img_bullets.add(this.img_shot.getSubimage(0, 27*2, 27, 27));

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
			this.takoyaki.hitAttack(10,tInfo);
			this.player.attackAnim.isJudge = false;
			SoundBox.singleton.playClip(MUSIC_NUM.HIT);
		} else if (this.hitAttack() == false && this.player.attackAnim.isJudge == true) {
			this.player.attackAnim.isJudge = false;
			SoundBox.singleton.playClip(MUSIC_NUM.ATTACK);
		}
		if (this.player.spAttackAnim.isJudge == true) {
			this.takoyaki.hitAttack(30,tInfo);
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

		this.player.lifeMeter.draw(tInfo);
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
		Point2D.Double position1=new Point2D.Double(this.player.attackAnim.position.x,this.player.attackAnim.position.y-110);
		boolean test1=Vector.distance(position1, this.takoyaki.position)<=this.player.attackAnim.size-10+this.takoyaki.size;

		Point2D.Double position2=new Point2D.Double(this.player.attackAnim.position.x,this.player.attackAnim.position.y+110);
		boolean test2=Vector.distance(position2, this.takoyaki.position)<=this.player.attackAnim.size-10+this.takoyaki.size;

		Point2D.Double position3=new Point2D.Double(this.player.attackAnim.position.x,this.player.attackAnim.position.y-40);
		boolean test3=Vector.distance(position3, this.takoyaki.position)<=this.player.attackAnim.size+this.takoyaki.size;

		Point2D.Double position4=new Point2D.Double(this.player.attackAnim.position.x,this.player.attackAnim.position.y+40);
		boolean test4=Vector.distance(position4, this.takoyaki.position)<=this.player.attackAnim.size+this.takoyaki.size;

		return test1||test2||test3||test4;
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
