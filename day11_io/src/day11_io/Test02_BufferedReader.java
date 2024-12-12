package day11_io;

import java.io.*;

public class Test02_BufferedReader {
	public static void main(String[] args) {
		//BufferedReader를 사용해서 hello.txt파일의 모든 데이터를 읽어와 화면에 출력해 보세요
		
		try {
			//public BufferedReader(Reader in) -->생성자
			
			// 방식1
			InputStream is = new FileInputStream("hello.txt");
			Reader in = new InputStreamReader(is);
			BufferedReader br= new BufferedReader(in);
			
			/* 방식2
			//public FileReader(String fileName) throws FileNotFoundException
			Reader in = new FileReader("hello.txt");
			BufferedReader br= new BufferedReader(in);
			*/
			
			while(true) {
				//public String readLine() throws IOException
				String s=br.readLine();
				if(s==null) break;  // readLine()더이상 읽어올것이 없으면 null반환한다.
				System.out.println(s);
			}
			
			br.close();
			in.close();
			
		}catch(FileNotFoundException fe) {
			System.out.println(fe.getMessage());
		}catch(IOException io) {
			System.out.println(io.getMessage());
		}
		

	}

	
}
