package test;

public class Student implements Comparable<Student>{
	private int num;
	private String name;
	private int score;
	
	public Student(){}

	public Student(int num, String name, int score) {
		this.num = num;
		this.name = name;
		this.score = score;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", score=" + score + "]";
	}
	

	@Override
	public int compareTo(Student o) {  //어떻게 비교해서 정렬할건지
		//번호순으로 오름차순 정렬
//		if(num>o.num) {  //자신(this)이 비교대상(o)보다 크면 1로 리턴
//			return 1;
//		}else if(num<o.num) {
//			return -1;
//		}else {
//			return 0;
//		}
		
		//번호순으로 내림차순 정렬
//		if(num>o.num) {  
//			return -1;
//		}else if(num<o.num) {
//			return 1;
//		}else {
//			return 0;
//		}
		
		//점수순으로 내림차순 정렬
		if(score>o.score) {
			return -1;
		}else if(score<o.score) {
			return 1;
		}else {
			return 0;
		}
		
	}
	
	
	
}
