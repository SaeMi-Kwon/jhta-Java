package day13;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class MyFrame02 extends JFrame{
	JTextField txtName=new JTextField(20);
	JButton btn1=new JButton("확인");
	JLabel lbe=new JLabel();
	
	public MyFrame02() {
		setLayout(new FlowLayout());
		
		lbe.setText("여기에 입력된 이름이 출력되요");
		
		add(txtName);
		add(btn1);
		add(lbe);
		
		txtName.setText("홍길동");
		setSize(600,500);
		setVisible(true);
		
		class MyAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				//입력된 텍스트 얻어오기
				String name=txtName.getText();
				//레이블에 출력하기
				lbe.setText("입력된 이름:" + name);
			}
		}
		//버튼을 클릭했는데 MyAction이 수행되도록 해보세요.
		MyAction action=new MyAction();
		btn1.addActionListener(action);
		
	}
}
public class Test02_TextField {
	public static void main(String[] args) {
		new MyFrame02();
	}
}
