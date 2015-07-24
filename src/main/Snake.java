package main;

class Snake implements Runnable{
	int x;
	int y;
	int direction;
	boolean live=true;
	
	Snake(int x,int y,int direction){
		this.x=x;
		this.y=y;
		this.direction=direction;
	}
	
	public void run() {
		while(true){
			try{
				Thread.sleep(50);
			}catch(Exception e){	
			}
			switch(direction){
			case 0:
				y--;
				break;
			case 1:
				y++;
				break;
			case 2:
				x--;
				break;
			case 3:
				x++;
				break;
			}
		}
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
