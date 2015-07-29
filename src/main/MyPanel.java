package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.JPanel;

class MyPanel extends JPanel implements KeyListener,Runnable{
	SnakeBody snakebody;
	SnakePart snakehead;
	Apple apple;
	LinkedList<SnakePart> snake=new LinkedList<SnakePart>();//用一个LinkedList装蛇
	MyPanel(){
		snakehead=new SnakePart(100,100,1);
		snake.add(snakehead);//蛇头放进去
		apple=new Apple(200,200);
		Thread snakemove=new Thread(snakebody);
		snakemove.start();
	}
	
	public void paint(Graphics g){//具体的画的方法
		
		g.fillRect(0, 0, 500, 400);	//画背景
		
		if(apple.live){
			g.setColor(Color.GREEN);
			g.fillRect(apple.getX(),apple.getY(),5,5);}//画苹果
		if(snakebody.live){
			for(int i=0;i<snake.size();i++){
				g.setColor(Color.WHITE);   
				g.fillRect(snake.get(i).getX(),snake.get(i).getY(),5,5);}
			}//画蛇
		eat();
	}
	
	public void run() {
		
	}

	
	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP){
			snakebody.direction=0;
			snakebody.y--;
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			snakebody.direction=1;
			snakebody.y++;
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			snakebody.direction=2;
			snakebody.x--;
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			snakebody.direction=3;
			snakebody.x++;
		}
		this.repaint();
	}

	public void keyReleased(KeyEvent e) {
		
	}
	public void eat(){
		if(apple.x==snakebody.x&&apple.y==snakebody.y){
			apple.live=false;
			addsnake();
		}
		Apple apple=new Apple((int)Math.random()*500,(int)Math.random()*400);
		apple.live=true;//被吃掉新建一个苹果
		this.repaint();
	}
	public void addsnake(){//蛇变长
		SnakePart snakeend;
		switch(snakebody.direction){
		case 0:
			snakeend=new SnakePart(apple.getX(),apple.getY()+5,0);
			snake.add(snakeend);
			break;
		case 1:
			snakeend=new SnakePart(apple.getX(),apple.getY()-5,0);
			snake.add(snakeend);
			break;
		case 2:
			snakeend=new SnakePart(apple.getX()-5,apple.getY(),0);
			snake.add(snakeend);
			break;
		case 3:
			snakeend=new SnakePart(apple.getX()+5,apple.getY(),0);
			snake.add(snakeend);
			break;
		}
	}
}
