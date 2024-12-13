package day151_java8;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame03 extends JFrame{
	JButton btn1=new JButton("버튼1");
	
	public MyFrame03() {
		setLayout(new FlowLayout());
		
		add(btn1);
		
		setSize(500,200);
		setVisible(true);
		
		//버튼을 눌렀을때 안녕하세요 를 출력해 보세요 -> 람다식 사용 ActionListener
		//클래스 형태
//		class MyActionListener implements ActionListener{
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("안녕하세요!!");
//			}
//		}
//		MyActionListener action=new MyActionListener();
//		btn1.addActionListener(action);
//		
//		
//		//익명의 내부클래스 형태
//		ActionListener al=new ActionListener() {	
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("안녕하세요");
//			}
//		};
//		btn1.addActionListener(al);
		
		
		//람다식 형태
		ActionListener ac=(e)->System.out.println("안녕하세요");
		btn1.addActionListener(ac);
		
	}
}

public class Test03 {
	public static void main(String[] args) {
		new MyFrame03();
	}
}
