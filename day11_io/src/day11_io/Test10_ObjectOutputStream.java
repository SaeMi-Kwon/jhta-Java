package day11_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

//ObjectOutputStream : 객체를 출력하는 기능을 갖는 출력 스트림 클래스
//ObjectInputStream : 객체를 읽어오는 기능을 갖는 입력 스트림 클래스

public class Test10_ObjectOutputStream {
	public static void main(String[] args) {
		
		try {
			//출력 스트림 클래스
//			//public ObjectOutputStream(OutputStream out) throws IOException -->생성자
//			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("object.ser"));
//			
//			//public final void writeObject(Object obj) throws IOException
//			oos.writeObject(new String("hello"));
//			oos.writeObject(new Date());
//			
//			oos.close();
//			System.out.println("객체를 파일로 저장 완료");
			
			//입력 스트림 클래스
			//public ObjectInputStream(InputStream in) throws IOException
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("object.ser"));
			
			//public final Object readObject() throws IOException,ClassNotFoundException
			String data1=(String)ois.readObject();
			Date data2=(Date)ois.readObject();
			System.out.println(data1);
			System.out.println(data2);
			
			ois.close();
			
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
			
		}catch(ClassNotFoundException ce) {
			System.out.println(ce.getMessage());
		}
		
		
		
		
	}
}
