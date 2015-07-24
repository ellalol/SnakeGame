package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

class MyPanel extends JPanel implements KeyListener,Runnable{
	Snake snake;
	Apple apple;
	MyPanel(){
		snake=new Snake(100,100,1);
		apple=new Apple(200,200);
	}
	
	public void paint(Graphics g){//具体的画的方法
		
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
			snake.y-=10;
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			snake.y+=10;
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			snake.x-=10;
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			snake.x+=10;
		}
		this.repaint();
	}

	public void keyReleased(KeyEvent e) {
		
	}
	public void eat(){
		
	}

}
