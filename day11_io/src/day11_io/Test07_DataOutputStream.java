package day11_io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//DataOutputStream : 자바의 기본자료형을 출력하는 기능을 갖는 출력 스트림

public class Test07_DataOutputStream {
	public static void main(String[] args) {
		int a=10;
		boolean b=true;
		double c=3.5;
		char d='A';
		String str="안녕하세요";
		
		try {
			//기본자료형의 크기만큼 파일로 출력하는 기능을 갖는 스트림 객체
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.dat"));
			dos.writeInt(a); //int형의 크기로 파일에 저장
			dos.writeBoolean(b); //boolean형의 크기로 파일에 저장
			dos.writeDouble(c); //double형의 크기로 파일에 저장
			dos.writeChar(d); //char형의 크기로 파일에 저장
			dos.writeUTF(str); //utf-8 인코딩방식으로 문자열을 파일에 저장
			
			dos.close();
			System.out.println("파일로 저장 완료");
			
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
		
	}
}
