package day12;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame15 extends JFrame{
	JButton button1=new JButton("버튼1");
	JButton button2=new JButton("버튼2");

	public MyFrame15() {
		super("나의 두번째 윈도우");
		
		//public void setLayout(LayoutManager manager)
		setLayout(null); //레이아웃매니져 사용안함 - 이때는 컴포넌트 사이즈와 위치를 설정해줘야 함
		button1.setSize(100,50); //버튼 크기설정
		button1.setLocation(10,50);  //버튼 위치설정
		
		button2.setSize(100,50);
		button2.setLocation(120,50);
		
		add(button1);
		add(button2);
		
		setSize(600,500);
		setVisible(true);
	}
}

public class Test15_Frame {
	public static void main(String[] args) {
		new MyFrame15();
	}
}
