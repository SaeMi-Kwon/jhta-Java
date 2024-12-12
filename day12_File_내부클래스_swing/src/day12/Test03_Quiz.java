package day12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * 1.디렉토리명(경로포함)을 입력받아 해당 디렉토리 안의 목록중에 파일명만 출력되도록 보여보세요.
 * 	 만약 디렉토리가 존재하지 않으면 디렉토리를 찾지 못했다는 오류 메시지를 출력해 보세요
 * 
 * 
 * 2. 파일명을 입력받아 해당파일의 내용을 화면에 출력해 보세요.(텍스트파일인 경우만 가능)
 * 	  예) 보여질 파일명 입력하세요: 0917.txt
 * 	  -->파일의 내용이 화면에 보여지도록 
 */
public class Test03_Quiz {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("디렉토리명(경로포함) 입력");
		String path=scan.nextLine();
		
		File f=new File(path);
		
		if(!f.exists()) {
			System.out.println("디렉토리를 찾지 못했습니다.");
			return; //메소드 끝내기 - main종료(프로그램종료)
		}
		
		File[] list=f.listFiles();
		System.out.println( "< "+f.getName() + "디렉토리 안의 파일 목록 >");
		for(File ff:list) {
			if(ff.isFile()) {
				String fileName=f.getName();  //파일명 이름
				if(fileName.endsWith(".txt")||fileName.endsWith(".java")) { //파일이름이 ".txt" or ".java"로 끝난것만 출력
					System.out.println(ff.getName());
				}
			}
		}

		System.out.println("읽어올 파일명 입력");
		String file=scan.nextLine();
		try {
			//public BufferedReader(Reader in)
			//BufferedReader br= new BufferedReader(new FileReader(path+"\\"+file));
			BufferedReader br= new BufferedReader(new FileReader(f.getAbsolutePath()+"\\"+file));
			
			while(true) {
				String s=br.readLine();
				if(s==null) break; 
				System.out.println(s);
			}
			
			br.close();
			
		}catch(FileNotFoundException fe) {
			System.out.println(fe.getMessage());
			
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
		
	}
}
