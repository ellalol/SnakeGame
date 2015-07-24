package main;

class Snake implements Runnable{
	int x;
	int y;
	int direction;
	boolean live;
	
	Snake(int x,int y,int direction){
		this.x=x;
		this.y=y;
		this.direction=direction;
	}
	
	public void run() {
		
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
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
}
