package main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

class MyPanel extends JPanel implements KeyListener,Runnable{
	MyPanel(){
		//新建Apple和Snake对象，同时调用构造方法
	}
	
	public void paint(Graphics g){//具体的画的方法
		g.fillRect(0, 0, 500, 400);	
	}
	
	public void run() {
		
	}

	
	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		
	}

}
