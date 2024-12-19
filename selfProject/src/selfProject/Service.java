package selfProject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class CafeFrame extends JFrame{
	JLabel lbl=new JLabel("커피메뉴");
	JTextArea textArea=new JTextArea(); //주문내역 보여주는 텍스트
	JTextField txtAmout=new JTextField(5); //수량입력
	JButton btnSel=new JButton("선택");
	JButton btnClear=new JButton("초기화");
	JButton btnExit=new JButton("닫기");
	JPanel pan1=new JPanel();	//수량 입력 패널
	JPanel pan2=new JPanel();  //(선택,초기화,닫기)버튼 배치 패널

	DefaultListModel<String> model=new DefaultListModel<>();
	JList<String> list=new JList<>(model);
	
	ArrayList<String> menu=new ArrayList<>();
	ArrayList<Integer> pay=new ArrayList<>();
	
	ArrayList<Order> order=new ArrayList<>();
	
	public CafeFrame(){
		super("주문 프로그램");
		setLayout(new BorderLayout());
		
		
		menu.add("아메리카노");
		pay.add(3200);
		menu.add("에스프레소");
		pay.add(3500);
		menu.add("바닐라라떼");
		pay.add(4500);
		menu.add("카페모카");
		pay.add(4500);
		menu.add("카라멜마끼아또");
		pay.add(4800);
		menu.add("초코라떼");
		pay.add(4800);
		menu.add("허브차");
		pay.add(4200);
		menu.add("캐모마일");
		pay.add(4200);
		menu.add("페퍼민트");
		pay.add(4200);
		menu.add("아이스티");
		pay.add(3500);
		menu.add("스무디");
		pay.add(5000);
		menu.add("에이드");
		pay.add(4000);
		

		
		for(int i=0;i<menu.size();i++) {
			model.addElement(menu.get(i) + " - " + pay.get(i)+ "원");
		}
		
		//카페리스트
		JPanel listPanel=new JPanel();
		listPanel.setLayout(new BorderLayout());
		listPanel.add(new JScrollPane(list),BorderLayout.CENTER);
		
		
		pan1.setLayout(new FlowLayout());
		pan1.add(new JLabel("수량"));
		pan1.add(txtAmout);
		txtAmout.setText("1"); 
		
		
		pan2.setLayout(new FlowLayout());
		pan2.add(btnSel);
		pan2.add(btnClear);
		pan2.add(btnExit);
		
		add(lbl,BorderLayout.NORTH);
		add(listPanel,BorderLayout.CENTER);
		add(pan1,BorderLayout.EAST);
		add(pan2,BorderLayout.SOUTH);
		add(new JScrollPane(textArea),BorderLayout.WEST);
	
		
		setSize(600,600);
		setVisible(true);
	
	
		ActionListener Selected = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				//txtAmout.setText("");  
				txtAmout.requestFocus();
			}
			
		};
		btnSel.addActionListener(Selected);
		
		ActionListener clear = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		};
		btnClear.addActionListener(clear);
		
		
		ActionListener exited = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("프로그램 종료");
				System.exit(0);
			}
		};
		btnExit.addActionListener(exited);
		

	}
	
	
}



public class Service {
	public static void main(String[] args) {
		new CafeFrame();
		
	}
}
