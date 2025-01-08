package jdbc03;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dto.MembersDAO;
import test.dto.MembersDTO;

class MyFrame extends JFrame{
	JTabbedPane tabs=new JTabbedPane();  //위에 탭
	JPanel panBack1=new JPanel();   //탭에 붙일 판넬
	JPanel panBack2=new JPanel();
	JPanel pan1=new JPanel();
	JTextField txtNum=new JTextField();
	JTextField txtName=new JTextField();
	JTextField txtPhone=new JTextField();
	JTextField txtAddr=new JTextField();
	JButton btnAdd=new JButton("추가");
	
	JTable table=null;     //테이블 보여주기용
	DefaultTableModel model=null;    //실질적으로 데이터가지고 있음
	
	JPanel panBack3=new JPanel();
	JTextField txtDelNum=new JTextField(15);
	JButton btnDel=new JButton("회원삭제");
	
	MembersDAO dao=new MembersDAO();
	
	public MyFrame() {
		add(tabs);
		pan1.setLayout(new GridLayout(4,2));
		
		//----------- 회원추가 탭 -------------//
		pan1.add(new JLabel("회원번호"));
		pan1.add(txtNum);
		pan1.add(new JLabel("회원이름"));
		pan1.add(txtName);
		pan1.add(new JLabel("전화번호"));
		pan1.add(txtPhone);
		pan1.add(new JLabel("회원주소"));
		pan1.add(txtAddr);
		
		panBack1.setLayout(null);
		pan1.setBounds(10,10,550,100);
		btnAdd.setBounds(460,120,100,30);
		panBack1.add(btnAdd);
		panBack1.add(pan1);

		tabs.addTab("회원추가", panBack1);
		
		//------------- 회원목록 탭--------------//
		String[] columnNames= {"회원번호","이름","전화번호","주소","가입일"};
		model=new DefaultTableModel(columnNames,0);
		table=new JTable(model);
		panBack2.setLayout(new BorderLayout());
		panBack2.add(new JScrollPane(table),BorderLayout.CENTER);
	
		tabs.addTab("회원목록", panBack2);
		
		//-------------- 회원삭제 탭--------------//
		panBack3.add(new JLabel("삭제할 회원번호"));
		panBack3.add(txtDelNum);
		panBack3.add(btnDel);
		
		tabs.addTab("회원삭제", panBack3);		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);  //프로그램 종료
		setSize(600,600);
		setVisible(true);
		
		listAll();
		
		ActionListener listener=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//텍스트필드에 입력된 값 얻어와 DB에 저장하기
				int num=Integer.parseInt(txtNum.getText());
				String name=txtName.getText();
				String phone=txtPhone.getText();
				String addr=txtAddr.getText();
				
				MembersDTO dto=new MembersDTO(num,name,phone,addr,null);
				int n=dao.insert(dto);
				
				if(n>0) {
					JOptionPane.showMessageDialog(MyFrame.this, "회원등록성공!");
					listAll();   //목록호출
				}else {
					JOptionPane.showMessageDialog(MyFrame.this, "회원등록실패!");
				}
			}
		};
		btnAdd.addActionListener(listener);
		
		
		btnDel.addActionListener((e)->{
			int num=Integer.parseInt(txtDelNum.getText());
			int n=dao.delete(num);
			if(n>0) {
				JOptionPane.showMessageDialog(MyFrame.this, "회원삭제성공!");
				listAll();   
			}else {
				JOptionPane.showMessageDialog(MyFrame.this, "회원삭제실패!");
			}
		});
		
	}
	
	public void listAll() {  //db의 전체데이터를 모델객체에 담는 메소드
		//모델에 담긴 기존 데이터 삭제하기
		int length=model.getRowCount();  //전체 행의 갯수
		
		//거꾸로 삭제하는이유: for문이 돌면서 0번째삭제하면 1번째있던 데이터는 0번인덱스가 되어 순차적으로 위치가 바끼게된다.
		//거꾸로 삭제하거나 0번째인덱스만 삭제하는 방식으로 해주면 된다.
		for(int i=length-1;i>=0;i--) { 
			model.removeRow(i);  //i번째 행 삭제
		}

		
		ArrayList<MembersDTO> list=dao.selectAll();
		for(int i=0;i<list.size();i++) {
			MembersDTO dto=list.get(i);  //db에 저장된 i번째 객체 꺼내오기
			
			//dto를  Vector로 변환후 model객체에 추가하기(ArrayList는 지원을 안하기때문에 Vector사용)
			Vector<Object> vector=new Vector<>();
			vector.add(dto.getNum());
			vector.add(dto.getName());
			vector.add(dto.getPhone());
			vector.add(dto.getAddr());
			vector.add(dto.getRegdate());
			model.addRow(vector);
		}
	}
	
}


public class TestGUI {
	public static void main(String[] args) {
		new MyFrame();
	}
}
