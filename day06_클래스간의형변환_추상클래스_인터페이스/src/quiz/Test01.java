package quiz;

/*
	1. MyShape클래스의 draw메소드를 추상메소드로 만들고 
	이를 상속받는 MyLine,MyRect클래스를
	만들어 보세요.
	class MyShape{
		protected int x,y;//x,y좌표
		private String color;//색상
		public MyShape(int x,int y,String color){
			this.x=x;
			this.y=y;
			this.color=color;
		}
		public String getColor(){return color;}
		public void draw(){}
	}
	[ 출력결과 ]
	x좌표:100,y좌표:200의 위치에 사각형을 빨강색으로 그려요.
	x좌표:100,y좌표:200의 위치에 직선을 파란색으로 그려요.

 */

abstract class MyShape{
	protected int x,y;//x,y좌표
	private String color;//색상
	public MyShape(int x,int y,String color){
		this.x=x;
		this.y=y;
		this.color=color;
	}
	public String getColor(){
		return color;
		}
	public abstract void draw();
}
class MyRect extends MyShape{
	public MyRect(int x,int y,String color){
		super(x,y,color);
	}
	
	@Override
	public void draw() {
		System.out.println("x좌표:"+x+",y좌표:"+y+"의 위치에 사각형을 "+ getColor() +"으로 그려요.");
	}
}
class MyLine extends MyShape{
	public MyLine(int x,int y,String color){
		super(x,y,color);
	}
	
	@Override
	public void draw() {
		System.out.println("x좌표:"+x+",y좌표:"+y+ "의 위치에 직선을"  +getColor()+"으로 그려요.");
	}
}

public class Test01 {
	public static void main(String[] args) {
		MyShape s = new MyRect(100,200,"빨간색");
		MyShape l = new MyLine(100,200,"파란색");
		
		s.draw();
		l.draw();
	}


}
