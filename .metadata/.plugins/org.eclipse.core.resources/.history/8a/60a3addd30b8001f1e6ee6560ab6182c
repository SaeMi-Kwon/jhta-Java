package day14_thread;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test03_FileCopy {
	static int n=1;

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		while(true) {
			System.out.println("1.파일복사 2.종료");
			int n=scan.nextInt();
			switch(n) {
			case 1: filecopy(); break;
			case 2: System.exit(0);
			}
		}
		
		
	}
	
	public static void filecopy() {
		try {
			FileInputStream fis=new FileInputStream("c:\\2407\\1.exe");
			String copyName = "copy" + (n++) + ".exe";
			FileOutputStream fos= new FileOutputStream("c:\\2407\\" + copyName);
			
			byte[] b=new byte[50];
			int n1=0;
			while((n1=fis.read(b))!=-1) {
				fos.write(b,0,n1);
			}
			
			fos.close();
			fis.close();
			System.out.println(copyName + "복사본 파일생성 완료!!!");
			
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
}
