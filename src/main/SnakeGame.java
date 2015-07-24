package main;

import javax.swing.JFrame;

public class SnakeGame extends JFrame{
	SnakeGame(){
		MyPanel mb=new MyPanel();//新建对象的同时 调用了MyPanel()构造函数
		this.add(mb);
		this.addKeyListener(mb);
		this.setSize(500,420);
		this.setLocation(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args){
		SnakeGame sg=new SnakeGame();//新建对象的同时 调用了SnakeGame()构造函数
	}
}
