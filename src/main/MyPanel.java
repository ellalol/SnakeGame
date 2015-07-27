package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.JPanel;

class MyPanel extends JPanel implements KeyListener,Runnable{
	Snake snake;
	Apple apple;
	LinkedList<Snake> wholesnake=new LinkedList<Snake>();//用一个LinkedList装蛇
	MyPanel(){
		snake=new Snake(100,100,1);
		wholesnake.add(snake);//蛇头放进去
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
			for(int i=0;i<wholesnake.size();i++){
				g.setColor(Color.WHITE);   
				g.fillRect(wholesnake.get(i).getX(),wholesnake.get(i).getY(),5,5);}
			}//画蛇
		eat();
	}
	
	public void run() {
		
	}

	
	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP){
			snake.direction=0;
			snake.y--;
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			snake.direction=1;
			snake.y++;
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			snake.direction=2;
			snake.x--;
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			snake.direction=3;
			snake.x++;
		}
		this.repaint();
	}

	public void keyReleased(KeyEvent e) {
		
	}
	public void eat(){
		if(apple.x==snake.x&&apple.y==snake.y){
			apple.live=false;
			addsnake();
		}
		this.repaint();
	}
	public void addsnake(){//蛇变长
		Snake newsnake;
		switch(snake.direction){
		case 0:
			newsnake=new Snake(apple.getX(),apple.getY()+5,0);
			wholesnake.add(newsnake);
			break;
		case 1:
			newsnake=new Snake(apple.getX(),apple.getY()-5,1);
			wholesnake.add(newsnake);
			break;
		case 2:
			newsnake=new Snake(apple.getX()-5,apple.getY(),2);
			wholesnake.add(newsnake);
			break;
		case 3:
			newsnake=new Snake(apple.getX()+5,apple.getY(),3);
			wholesnake.add(newsnake);
			break;
		}
	}
}
