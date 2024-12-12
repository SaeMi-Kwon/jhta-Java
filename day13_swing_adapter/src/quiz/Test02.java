package quiz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

/*
	왼쪽 List에 c:\\일기장안의 파일 목록들이 보이고 파일을 선택후 읽기 버튼을 누르면
	텍스트파일안의 내용이 오른쪽 JTextArea에 보여진다.
	저장버튼을 누르면 텍스트에리어에 입력된 내용이 날짜명으로 저장된다.
 */

class MyDiary extends JFrame{
	File f=new File("c:\\diary");
	String path=f.getAbsolutePath();
	
	JTextArea textArea=new JTextArea();
	JButton btnRead=new JButton("읽기");
	JButton btnSave=new JButton("저장");
	
	JPanel pan1=new JPanel();
	
	DefaultListModel<String> model=new DefaultListModel<>();
	JList<String> list=new JList<>(model);
	
	public MyDiary() {
		super("일기장");
		setLayout(new BorderLayout());
		
		pan1.add(btnRead);
		pan1.add(btnSave);
		
		
		add(pan1,BorderLayout.NORTH);
		add(new JScrollPane(list),BorderLayout.WEST);
		add(new JScrollPane(textArea),BorderLayout.CENTER);
		
		setSize(800,500);
		setVisible(true);
		
		
		//저장
		ActionListener saveAction=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				//오늘날짜
				DateTimeFormatter df = DateTimeFormatter.ofPattern("MMdd");
				String day =LocalDateTime.now().format(df);

				//디렉토리가 없으면 생성
				if(!f.exists()) {
					f.mkdirs(); 
				}
				
				//저장하기
				try {
					PrintWriter pw = new PrintWriter(new File(path +"\\" + day+".txt"));
					String text=textArea.getText(); 
					pw.println(text);
	
					pw.close();
					
					model.addElement(day+".txt");
					
					textArea.setText(""); //내용 비우기
					
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(MyDiary.this, "파일이 존재하지 않아요");
				}  
				
			}
		};
		btnSave.addActionListener(saveAction);
		
		
		//읽기
		ActionListener readAction=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int index=list.getSelectedIndex();
				if(index==-1) { 
					JOptionPane.showMessageDialog(MyDiary.this, "읽을 날짜를 선택하세요");
					return;
				}
				
				BufferedReader br;
				
					String selectFile = model.getElementAt(index); //지정된 인덱스로 나타나는 값을 돌려준다
	                File file = new File(path + "\\" + selectFile);
				
	           try {    
	        	    textArea.setText("");
	                br = new BufferedReader(new FileReader(file));
					
					while(true) {
						String str=br.readLine();
						if(str==null) break;  
						textArea.append(str + "\n");   
					}
			
					br.close();
					
				} catch (FileNotFoundException fe) {
					JOptionPane.showMessageDialog(MyDiary.this, "파일을 찾지 못했습니다");
					System.out.println(fe.getMessage());
				} catch (IOException ie) {
					System.out.println(ie.getMessage());
				}

			}
		};
		btnRead.addActionListener(readAction);
	}
}

public class Test02 {
	public static void main(String[] args) {
		new MyDiary();
	}
}
