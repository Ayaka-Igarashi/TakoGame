package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TWFrame {
	JFrame mainWindow;
	BufferStrategy strategy;
	TWDisplay display=new TWDisplay();

	TWFrame(){
		this.mainWindow=new JFrame("TakoWorld");
		this.mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainWindow.setSize(800,600);
		this.mainWindow.setLocationRelativeTo(null);
		this.mainWindow.setVisible(true);
		this.mainWindow.setResizable(false);

		this.mainWindow.setIgnoreRepaint(true);
		this.mainWindow.createBufferStrategy(2);
		this.strategy=this.mainWindow.getBufferStrategy();

		this.mainWindow.addKeyListener(new TWKeyAdapter());

		//画像読み込み
		try {
			this.display.loadMedia();
		}catch(IOException e) {
			JOptionPane.showMessageDialog(this.mainWindow, "画像が読み込めません");
		}
	}

	void start() {
		Timer t=new Timer();
		t.schedule(new RenderTask(), 0,16);
	}

	long lastTime=System.currentTimeMillis();
	TWInfo tInfo=new TWInfo();

	void render() {
		long currentTime=System.currentTimeMillis();
		//フレーム速度
		this.tInfo.frameTime=(currentTime-this.lastTime)*0.001;
		this.lastTime=currentTime;
		this.tInfo.currentTime=currentTime;

		Graphics2D g=(Graphics2D)this.strategy.getDrawGraphics();
		g.setBackground(Color.BLACK);
		g.clearRect(0, 0, this.mainWindow.getWidth(), this.mainWindow.getHeight());
		this.tInfo.g=g;

		this.display.getCurrentDisplay().show(tInfo);

		g.dispose();
		this.strategy.show();
	}

	class RenderTask extends TimerTask{
		@Override
		public void run() {
			TWFrame.this.render();
		}
	}

	class TWKeyAdapter extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			this.setValue(e.getKeyCode(),true);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			this.setValue(e.getKeyCode(),false);
		}

		private void setValue(int keyCode,boolean b) {
			boolean[] keyState=TWFrame.this.tInfo.keyState;
			switch(keyCode) {
			case KeyEvent.VK_LEFT:
				keyState[KEY_STATE.LEFT]=b;
				break;
			case KeyEvent.VK_RIGHT:
				keyState[KEY_STATE.RIGHT]=b;
				break;
			case KeyEvent.VK_UP:
				keyState[KEY_STATE.UP]=b;
				break;
			case KeyEvent.VK_DOWN:
				keyState[KEY_STATE.DOWN]=b;
				break;
			case KeyEvent.VK_Z:
				keyState[KEY_STATE.Z]=b;
				break;
			case KeyEvent.VK_X:
				keyState[KEY_STATE.X]=b;
				break;
			case KeyEvent.VK_C:
				keyState[KEY_STATE.C]=b;
				break;
			case KeyEvent.VK_SPACE:
				keyState[KEY_STATE.SPACE]=b;
				break;
			}

		}

	}

}