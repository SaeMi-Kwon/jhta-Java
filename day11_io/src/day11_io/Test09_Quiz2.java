package day11_io;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class Test09_Quiz2 {
	public static void main(String[] args) {
		//DataInputStream 방식2
		DataInputStream dis=null;
		
		try {
			//public DataInputStream(InputStream in)
			dis=new DataInputStream(new FileInputStream("student.dat"));
		
			for(int i=0;i<3;i++) {
				String name=dis.readUTF();
				int kor=dis.readInt();
				int eng=dis.readInt();
				int sum=kor+eng;
				double avg=sum/2.0;
			
				System.out.println(name + "," + kor + "," + eng + "," + sum + "," + avg);
			}

		//EOFException - if this input stream reaches the end before reading four bytes.
		}catch(EOFException ee) {
			try {
				if(dis!=null) dis.close();
				System.out.println("파일을 모두 읽었어요");
			}catch(IOException ie) {
				System.err.println(ie.getMessage());
			}
	
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
}
