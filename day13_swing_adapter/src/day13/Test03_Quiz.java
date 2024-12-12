package day13;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class MyFrame03 extends JFrame{
	JTextField n1=new JTextField(5);
	JTextField n2=new JTextField(5);
	JTextField n3=new JTextField(5);
	
	JButton btn=new JButton("합구하기");
	
	public MyFrame03() {
		setLayout(new FlowLayout());

		add(n1);
		add(new JLabel("+"));
		add(n2);
		add(new JLabel("="));
		add(n3);
		
		add(btn);

		setSize(600,500);
		setVisible(true);
		
		class MyAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				//두수합 구하기
				int num1=Integer.parseInt(n1.getText());
				int num2=Integer.parseInt(n2.getText());
				int num3=num1+num2;
				
				//public static String valueOf(int i)
				String result =String.valueOf(num3);
				
				//레이블에 출력하기
				n3.setText(result);
			}
		}
		//버튼을 클릭했는데 MyAction이 수행되도록 해보세요.
		MyAction action=new MyAction();
		btn.addActionListener(action);	
	}	
}

public class Test03_Quiz {
	public static void main(String[] args) {
		new MyFrame03();
	}
}
