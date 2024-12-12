package day14_thread1;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

class MyFram03 extends JFrame{
	JLabel lbl=new JLabel("시간출력");
	
	public MyFram03() {
		super("스레드테스트");
		
		setLayout(new BorderLayout());
		
		add(lbl,BorderLayout.NORTH);
		
		setSize(500,300);
		setVisible(true);
	}
}


public class Test03_time {
	public static void main(String[] args) {
		new MyFram03();
	}
}
