package quiz;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

//메인메소드에서 원본 파일명과 복사될 파일명을 입력받아 스레드를 사용해서 복사하는 프로그램 작성하기
//쓰레드 생성자에 파일명

class FileCopyThread extends Thread{
	   private String inputFile;
	   private String outputFile;


	   public FileCopyThread(String inputFile,String outputFile){
	       this.inputFile=inputFile;
	       this.outputFile=outputFile;
	   }
	   @Override
	   public void run() {
	       try {
	           FileInputStream fis=new FileInputStream(inputFile);
	           FileOutputStream fos= new FileOutputStream(outputFile);


	           byte[] b=new byte[50];
	           int n=0;
	           while((n=fis.read(b))!=-1) {
	               fos.write(b,0,n);
	           }

	           fos.close();
	           fis.close();
	           System.out.println("복사본 파일생성 완료!!!");


	       }catch(IOException ie) {
	           System.out.println(ie.getMessage());
	       }
	   }
	}

public class Test01 {
	 public static void main(String[] args) {
	       Scanner scan = new Scanner(System.in);
	       System.out.println("원본파일명:");
	       String origFile=scan.next();
	       System.out.println("복사파일명:");
	       String copyFile=scan.next();


	       FileCopyThread thread=new FileCopyThread(origFile,copyFile);
	       thread.start();
	   }

}
