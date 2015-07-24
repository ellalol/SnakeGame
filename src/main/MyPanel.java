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
		Thread snakemove=new Thread(snake);
		snakemove.start();
	}
	
	public void paint(Graphics g){//具体的画的方法
		
		g.fillRect(0, 0, 500, 400);	//画背景
		
		if(apple.live){
			g.setColor(Color.GREEN);
			g.fillRect(apple.getX(),apple.getY(),5,5);}//画苹果
		if(snake.live){
			g.setColor(Color.WHITE);   
			g.fillRect(snake.getX(),snake.getY(),5,5);}//画蛇
		eat();
	}
	
	public void run() {
		
	}

	
	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP){
			snake.direction=0;
			snake.y-=10;
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			snake.direction=1;
			snake.y+=10;
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			snake.direction=2;
			snake.x-=10;
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			snake.direction=3;
			snake.x+=10;
		}
		this.repaint();
	}

	public void keyReleased(KeyEvent e) {
		
	}
	public void eat(){
		if(apple.x==snake.x&&apple.y==snake.y){
			apple.live=false;
		}
		this.repaint();
	}

}
