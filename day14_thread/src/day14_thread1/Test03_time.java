package day14_thread1;

import java.awt.BorderLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JLabel;

class MyFrame03 extends JFrame{
	JLabel lbl=new JLabel("시간출력");
	
	public MyFrame03() {
		super("스레드테스트");
		
		setLayout(new BorderLayout());
		
		add(lbl,BorderLayout.NORTH);
		
		setSize(500,300);
		setVisible(true);
		
		//시간출력하는 스레드를 만들어 lbl에 출력되도록 해보세요.
		class TimeThread extends Thread{
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
		new TimeThread().start();
	}
}

public class Test03_time {
	public static void main(String[] args) {
		new MyFrame03();
		
	}
}
