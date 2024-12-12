package day07;

import java.util.List;
import java.util.Vector;

public class Test11 {
	public static void main(String[] args) {
		Vector<String> vector=new Vector<>();
		vector.add("개나리");  //0
		vector.add("무궁화");  //1
		vector.add("진달래");  //2
		vector.add("장미꽃");  //3
		vector.add("목련꽃");  //4
		
		//List<E> subList(int fromIndex,int toIndex)
		//위의 메소드를 사용해서 무궁화/진달래/장미꽃만 저장된 List가 출력되도록 코드를 작성해 보세요.
		List<String> list = vector.subList(1, 4);
		for(int i=0;i<list.size();i++) {	
			String s = list.get(i);
			System.out.println(s);
		}
		
		
	}
}
