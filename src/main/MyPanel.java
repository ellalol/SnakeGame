package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

class MyPanel extends JPanel implements KeyListener,Runnable{
	MyPanel(){
	
	}
	
	public void paint(Graphics g){//具体的画的方法
		Snake snake=new Snake(100,100,1);
		Apple apple=new Apple(200,200);
		g.fillRect(0, 0, 500, 400);	//画背景
		g.setColor(Color.GREEN);   
		g.fillRect(apple.getX(),apple.getY(),5,5);//画苹果
		g.setColor(Color.WHITE);   
		g.fillRect(snake.getX(),snake.getY(),5,5);//画蛇
	}
	
	public void run() {
		
	}

	
	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP){
			y--;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			y++;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			x--;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			x++;
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}

}
