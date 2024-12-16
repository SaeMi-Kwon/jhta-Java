package day16_stream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//reduce : Stream의 요소들을 하나의 데이터로 만드는 작업을 수행

public class Test07_reduce {
	public static void main(String[] args) {
		//Stream<Person> st1=Stream.of(new Person("aa",10),new Person("bb",20));
		
		Stream<Integer> st1=Stream.of(1,2,3,4,5,6,7,8,9,10);
		Optional<Integer> opt=st1.reduce(new BinaryOperator<Integer>() {
			@Override
			//t는 리턴된 값이 들어가고, u에는 스트림요소값들이 전달된다.
			public Integer apply(Integer t, Integer u) {
				return t+u;  //리턴된 값이 다음 apply메소드의 t로 전달된다
			}
		});
		int s=opt.get();
		System.out.println(s);
		
		
		
		//IntStream.range(1, 100);  //마지막 100은 포함이 안됨
		IntStream is =IntStream.rangeClosed(1, 100);  //마지막 100까지 포함
		
		//reduce를 사용해서 1부터 100까지 합 구해보세요.(익명의 내부클래스 -> 람다식사용)
//		OptionalInt opt1=is.reduce(new IntBinaryOperator() {
//			@Override
//			public int applyAsInt(int left, int right) {
//				return left+right;
//			}
//		});
//		int s1=opt1.getAsInt();
//		System.out.println("sum:" + s1);
		
		
		int s1=is.reduce((left,right)->left+right).getAsInt();
		System.out.println("sum:" + s1);
		
		
	}
}
