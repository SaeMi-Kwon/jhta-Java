package day14_thread1;

import java.awt.BorderLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JLabel;

class MyFrame04 extends JFrame implements Runnable{
	JLabel lbl=new JLabel("시간출력");
	
	public MyFrame04() {
		super("스레드테스트");
		
		setLayout(new BorderLayout());
		
		add(lbl,BorderLayout.NORTH);
		
		setSize(500,300);
		setVisible(true);
		
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		while(true) {
			DateTimeFormatter f=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String str=LocalDateTime.now().format(f);
			
			lbl.setText(str);
		
			try {
				Thread.sleep(1000);
			}catch(InterruptedException u) {
				System.out.println(u.getMessage());
			}
		}
	}
}

public class Test04_time {
	public static void main(String[] args) {
		//new Thread(new MyFrame04()).start();
		new MyFrame04();
	}
}
