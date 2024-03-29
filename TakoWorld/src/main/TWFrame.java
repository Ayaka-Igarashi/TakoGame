package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.constant.KEY_STATE;

public class TWFrame {
	JFrame mainWindow;
	BufferStrategy strategy;
	TWDisplay display = new TWDisplay();
	public static int title_bar_height;//タイトルバーの長さ

	TWFrame() {
		this.mainWindow = new JFrame("TakoWorld");
		this.mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//タイトルバーの長さを求める
		//this.mainWindow.pack();
		//TWFrame.title_bar_height=this.mainWindow.getInsets().top;

		//System.out.println(TWFrame.title_bar_height);

		this.mainWindow.setUndecorated(true);//タイトルバー消す
		TWFrame.title_bar_height = 0;

		this.mainWindow.setSize(800, 600 + TWFrame.title_bar_height);
		this.mainWindow.setLocationRelativeTo(null);

		this.mainWindow.setVisible(true);
		this.mainWindow.setResizable(false);

		this.mainWindow.setIgnoreRepaint(true);
		this.mainWindow.createBufferStrategy(2);
		this.strategy = this.mainWindow.getBufferStrategy();

		this.mainWindow.addKeyListener(new TWKeyAdapter());

		TWMouseListener ml = new TWMouseListener();
		this.mainWindow.addMouseListener(ml);
		this.mainWindow.addMouseMotionListener(ml);

		//画像読み込み
		try {
			this.display.loadMedia();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this.mainWindow, "画像が読み込めません");
		}

	}

	void start() {

		Timer t = new Timer();
		t.schedule(new RenderTask(), 0, 16);
	}

	long lastTime = System.currentTimeMillis();
	TWInfo tInfo = new TWInfo();

	private boolean firstCycle = true;

	void render() {
		long currentTime = System.currentTimeMillis();
		//フレーム速度
		this.tInfo.frameTime = (currentTime - this.lastTime) * 0.001;

		//メニュー操作抜きの時間
		if (this.firstCycle == true) {
			this.tInfo.currentTime_withoutMenu = currentTime;
			this.firstCycle = false;

		} else {
			this.tInfo.currentTime_withoutMenu += currentTime - this.lastTime;
		}

		//普通の時間
		this.lastTime = currentTime;
		this.tInfo.currentTime = currentTime;

		//System.out.println(this.tInfo.currentTime_withoutMenu+" : "+this.tInfo.currentTime);

		Graphics2D g = (Graphics2D) this.strategy.getDrawGraphics();
		g.setBackground(Color.BLACK);
		g.clearRect(0, 0, this.mainWindow.getWidth(), this.mainWindow.getHeight());
		this.tInfo.g = g;

		this.display.getCurrentDisplay().show(tInfo);

		g.dispose();
		this.strategy.show();
	}

	class RenderTask extends TimerTask {
		@Override
		public void run() {
			TWFrame.this.render();
		}
	}

	class TWKeyAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			this.setValue(e.getKeyCode(), true);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			this.setValue(e.getKeyCode(), false);
		}

		private void setValue(int keyCode, boolean b) {
			boolean[] keyState = TWFrame.this.tInfo.keyState;
			switch (keyCode) {
			case KeyEvent.VK_LEFT:
				keyState[KEY_STATE.LEFT] = b;
				break;
			case KeyEvent.VK_RIGHT:
				keyState[KEY_STATE.RIGHT] = b;
				break;
			case KeyEvent.VK_UP:
				keyState[KEY_STATE.UP] = b;
				break;
			case KeyEvent.VK_DOWN:
				keyState[KEY_STATE.DOWN] = b;
				break;
			case KeyEvent.VK_Z:
				keyState[KEY_STATE.Z] = b;
				break;
			case KeyEvent.VK_X:
				keyState[KEY_STATE.X] = b;
				break;
			case KeyEvent.VK_C:
				keyState[KEY_STATE.C] = b;
				break;
			case KeyEvent.VK_SPACE:
				keyState[KEY_STATE.SPACE] = b;
				break;
			case KeyEvent.VK_SHIFT:
				keyState[KEY_STATE.SHIFT] = b;
				break;
			case KeyEvent.VK_ESCAPE:
				keyState[KEY_STATE.ESC] = b;
				break;
			case KeyEvent.VK_A:
				keyState[KEY_STATE.A] = b;
				break;
			}

		}

	}

	//画面をドラッグさせる
	class TWMouseListener implements MouseListener, MouseMotionListener {
		private Point startDrag, startPos;

		private Point getScreenLocation(MouseEvent e) {
			Point p1 = e.getPoint();
			Point p2 = TWFrame.this.mainWindow.getLocationOnScreen();
			return new Point(p1.x + p2.x, p1.y + p2.y);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			Point cursor = getScreenLocation(e);
			int xdiff = cursor.x - startDrag.x;
			int ydiff = cursor.y - startDrag.y;
			TWFrame.this.mainWindow.setLocation(startPos.x + xdiff, startPos.y + ydiff);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			startDrag = getScreenLocation(e);
			startPos = TWFrame.this.mainWindow.getLocation();
		}

		public void mouseMoved(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

	}

}
