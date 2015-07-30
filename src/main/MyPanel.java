package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JPanel;

class MyPanel extends JPanel implements KeyListener,Runnable{
	SnakePart snakehead;
	Apple apple;
	LinkedList<SnakePart> snake;
	int direction;
	MyPanel(){
		snakehead=new SnakePart(100,100,1);
		snake=new LinkedList<SnakePart>();
		snake.add(snakehead);//蛇头放进去
		apple=new Apple(200,200);
		direction = 0;
	}
	
	public void paint(Graphics g){//具体的画的方法
		
		g.fillRect(0, 0, 500, 400);	//画背景
		
		if(apple.live){
			g.setColor(Color.GREEN);
			g.fillRect(apple.getX(),apple.getY(),5,5);}//画苹果
		if(snakehead.live){
			for(int i=0;i<snake.size();i++){
				g.setColor(Color.WHITE);   
				g.fillRect(snake.get(i).getX(),snake.get(i).getY(),5,5);}
			}//画蛇
		eat();
	}
	
	public void run() {
		while(true){ 
			try{
				Thread.sleep(50);
			}
			catch(Exception e){
			}
			for(int i=0;i<snake.size();i++){
				SnakePart snakepart = null;
				switch(direction) {
				case 0:
					snakepart=new SnakePart(snake.get(i).x,snake.get(i).y-1,direction);
					break;
				case 1:
					snakepart=new SnakePart(snake.get(i).x,snake.get(i).y+1,direction);
					break;
				case 2:
					snakepart=new SnakePart(snake.get(i).x-1,snake.get(i).y,direction);
					break;
				case 3:
					snakepart=new SnakePart(snake.get(i).x+1,snake.get(i).y,direction);
					break;
				}
				snake.addFirst(snakepart);//加头
				snake.removeLast();//去尾
			}repaint();
	}		
}
	
	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP){
			direction=0;			
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			direction=1;
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			direction=2;
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			direction=3;
		}
		this.repaint();
	}

	public void keyReleased(KeyEvent e) {
		
	}
	public void eat(){
		if(apple.x==snake.getFirst().x&&apple.y==snake.getFirst().y&&apple.live){
			apple.live=false;
			addsnake();
		}
		this.repaint();
	}
	public void addsnake(){//蛇变长
		SnakePart snakepart;
		switch(direction){
		case 0:
			snakepart=new SnakePart(snake.getLast().x,snake.getLast().y+5,direction);
			snake.addLast(snakepart);
			break;
		case 1:
			snakepart=new SnakePart(snake.getLast().x,snake.getLast().y-5,direction);
			snake.addLast(snakepart);
			break;
		case 2:
			snakepart=new SnakePart(snake.getLast().x+5,snake.getLast().y,direction);
			snake.addLast(snakepart);
			break;
		case 3:
			snakepart=new SnakePart(snake.getLast().x-5,snake.getLast().y,direction);
			snake.addLast(snakepart);
			break;
		}
	}
}
