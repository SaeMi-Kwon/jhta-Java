package day13;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.BorderLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class MyFrame04 extends JFrame{
	JLabel lbl=new JLabel("이름입력");
	JTextField txtName=new JTextField(10);
	JButton btnAdd=new JButton("추가");
	JButton btnDel=new JButton("삭제");
	JPanel pan1=new JPanel();
	
	//List list=new List(); //버전이 맞지않아 한글깨짐현상이 발생(JList 사용권장)
	
	//public JList(ListModel<E> dataModel) ->생성자
	DefaultListModel<String> model=new DefaultListModel<>();
	JList<String> list=new JList<>(model);
	
	public MyFrame04() {
		setLayout(new BorderLayout());
		
		//데이터추가는 모델객체가 담당한다.
		model.addElement("홍길동");
		
		//list.add("hong");
		
		pan1.add(lbl);
		pan1.add(txtName);
		pan1.add(btnAdd);
		pan1.add(btnDel);
		
		add(pan1,BorderLayout.NORTH);
		add(list,BorderLayout.CENTER);
		
		setSize(600,300);
		setVisible(true);
		
		//입력된 이름이 List에 추가되도록 해보세요.
		//익명의 내부클래스로 작성
		ActionListener action=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object target = e.getSource(); //이벤트가 발생된 객체
				if(target==btnAdd) {
					//입력된 텍스트 얻어오기
					String name=txtName.getText();
					
					//레이블에 출력하기
					//list.add(name);
					model.addElement(name);
					txtName.setText("");  //입력한 문자 비우기(텍스트필드 지우기)
					txtName.requestFocus(); //포커스 추가
				}else if(target==btnDel) {
					int index=list.getSelectedIndex();
					if(index==-1) { //인덱스를 찾지못하는경우
						//(MyFrame04.this) : 부모컴포넌트(부모 창내에서 메시지가 띄워짐)
						JOptionPane.showMessageDialog(MyFrame04.this, "삭제할 이름을 선택하세요");
						return;
					}
					//list.remove(index);
					model.remove(index);
				}
			}
		};
		btnAdd.addActionListener(action);
		btnDel.addActionListener(action);
		
		
		//이름을 입력하고 엔터키를 치면 입력한 이름이 list에 추가되도록 해보세요.
		KeyAdapter keyAdapter = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					String press = txtName.getText();
					model.addElement(press);
					txtName.setText(""); //텍스트필드 지우기
					txtName.requestFocus(); //포커스 주기
				}
			}
		};
		txtName.addKeyListener(keyAdapter);
		
	}
}

public class Test04_List {
	public static void main(String[] args) {
		new MyFrame04();
	}
}
