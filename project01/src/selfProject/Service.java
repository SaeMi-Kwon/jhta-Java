package selfProject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel; 
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


class CafeFrame extends JFrame{
	JLabel lbl=new JLabel("커피메뉴");
	JTextArea textArea=new JTextArea(); //주문내역 보여주는 텍스트
	JTextField txtAmout=new JTextField(5); //수량입력
	JButton btnSave=new JButton("담기");
	JButton btnDel=new JButton("삭제");
	JButton btnSel=new JButton("결정");
	JButton btnClear=new JButton("초기화");
	
	JPanel pan1=new JPanel();	//수량 입력 패널
	JPanel pan2=new JPanel();  //(선택,초기화,닫기)버튼 배치 패널

	DefaultListModel<String> model=new DefaultListModel<>();
	JList<String> list=new JList<>(model);
	
	ArrayList<String> menu=new ArrayList<>(); 
	ArrayList<Integer> pay=new ArrayList<>();
	ArrayList<Order> order=new ArrayList<>();
	
	public CafeFrame(){
		super("커피 주문 프로그램");
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
		
		
		//메뉴리스트
		for(int i=0;i<menu.size();i++) {
			model.addElement(menu.get(i) + " - " + pay.get(i)+ "원");
		}
		
		JPanel listPanel=new JPanel();
		listPanel.setLayout(new BorderLayout());
		listPanel.add(new JScrollPane(list),BorderLayout.CENTER);
		
		
		//수량입력창
		pan1.setLayout(new FlowLayout());
		pan1.add(new JLabel("수량"));
		pan1.add(txtAmout);
		
		//버튼 패널
		pan2.setLayout(new FlowLayout());
		pan2.add(btnSave);
		pan2.add(btnDel);
		pan2.add(btnSel);
		pan2.add(btnClear);
		
		//위치
		add(pan1,BorderLayout.EAST);
		add(listPanel,BorderLayout.WEST);
		
		add(pan2,BorderLayout.SOUTH);
		add(lbl,BorderLayout.NORTH);

		add(new JScrollPane(textArea),BorderLayout.CENTER);
		
		
		setSize(800,500);
		setVisible(true);
	
	
		//주문한 커피를 누적해서 저장하는 용도
		ActionListener save = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				int index=list.getSelectedIndex();
				if(index==-1) { 
					JOptionPane.showMessageDialog(CafeFrame.this, "커피를 선택하세요");
					return;
				}

				//인덱스의 값을 얻어온다
				String store= model.getElementAt(index);
				
				
				String[] list=store.split("-");
				String item=list[0].trim();
				String pr=list[1].replace("원", "").trim();
				
				int price=Integer.parseInt(pr);
				
				//수량을 입력하지 않거나 잘못된 값을 입력한 경우 
				int amt=1;
				try {
					amt=Integer.parseInt(txtAmout.getText()); 
					
					if(amt<=0) {  //0개 이하일 경우 기본값 설정
						amt=1;
					}
					
				}catch(NumberFormatException ne) {
					JOptionPane.showMessageDialog(CafeFrame.this, "숫자를 입력하세요");
					txtAmout.setText("1");  //잘못 설정한 경우 기본값 설정 
					return;
				}
				
				order.add(new Order(item,price,amt));
				
				//주문 내역
				textArea.setText(""); //텍스트 초기화
				for(Order o:order) {
					textArea.append(o.toString()+"\n");
				}
				
				txtAmout.setText("");  //수량 초기화
				txtAmout.requestFocus();
			}
			
		};
		btnSave.addActionListener(save);
		
		
		//담았던 주문을 취소
		ActionListener delete = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean find=false;

				//TextArea상의 선택부분 텍스트를 얻어옴
				String str = textArea.getSelectedText(); 
				
				
		        //선택된 텍스트가 두줄이상인 경우
		        String[] line = str.split("\n"); // 줄바꿈 기준으로 텍스트 분리

		        if (line.length > 1) {
		            JOptionPane.showMessageDialog(CafeFrame.this, "한 줄만 선택하여 삭제할 수 있습니다.");
		            return; 
		        }

		        //선택된 텍스트가 한 줄일 경우
		        String item = line[0].trim(); 
		        if (item.indexOf(",")==-1) { 
		            JOptionPane.showMessageDialog(CafeFrame.this, "잘못된 선택입니다.");
		            return;
		        }
				
		        
				String orderItem=str.substring(0,(str.indexOf(",")));
				System.out.println(orderItem);

				
				for(int i=0;i<order.size();i++) {
					Order o=order.get(i);
					
					if(orderItem.equals(o.getItem())) {
						order.remove(i);
						find=true;
						break;
					}
				}

				if(!find) {
					JOptionPane.showMessageDialog(CafeFrame.this, "삭제할 품목이 없습니다.");
					
				}else {
					int start = textArea.getSelectionStart(); //선택부분의 시작점
					int end = textArea.getSelectionEnd(); //선택부분의 끝점
					textArea.replaceRange("", start, end); //시작부분과 끝점 사이를 공백으로 교체
				}

		    
			}
		};
		btnDel.addActionListener(delete);
		
		
		
		//저장된 주문 총합계 보여주기
				ActionListener select = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						int sum=0;
						for(Order s:order) {
							sum+=s.getTotal();
						}
						String total=String.valueOf(sum);
						textArea.append("총 합계:" + total + "원 입니다.\n");
					}
				};
				btnSel.addActionListener(select);
				
				
		
		//저장한 품목 초기화 
		ActionListener clear = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(CafeFrame.this,"저장된 품목들 리셋.");
				textArea.setText("");
				order.clear();
			}
		};
		btnClear.addActionListener(clear);
		
		
		//창 닫을때 파일저장 및 종료
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//종료하면 판매한 메뉴및 총매출액 오늘날짜로 파일에 저장
				DateTimeFormatter fomt=DateTimeFormatter.ofPattern("yyMMdd");
				String fileName=LocalDateTime.now().format(fomt);
				
				try {
					
					File f=new File("c:\\2407\\cafe");
					if(!f.exists()) {
						f.mkdirs(); 
					}
	
					FileWriter fw=new FileWriter(
							f.getAbsolutePath() + File.separator + fileName + ".txt",true);
			
					
					String text=textArea.getText();
					fw.write("\n" + text + "\n");
						
					fw.close();
					System.out.println("파일저장 성공");
					
				} catch (FileNotFoundException fe) {
					System.out.println(fe.getMessage());
				} catch(IOException ie) {
					System.out.println(ie.getMessage());
				}
		

				JOptionPane.showMessageDialog(CafeFrame.this,"파일저장 및 종료.");
				System.exit(0);
			}
		});
		
	}
}

public class Service {
	public static void main(String[] args) {
		new CafeFrame();
		
	}
}
