package main;

import java.util.LinkedList;

class SnakePart{
	int x;
	int y;
	int direction;
	boolean live=true;
	
	SnakePart(int x,int y,int direction){
		this.x=x;
		this.y=y;	
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
