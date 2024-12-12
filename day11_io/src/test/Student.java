package test;

import java.io.Serializable;

public class Student implements Serializable{

	private String name;
	private int kor;
	private int eng;
	private int sum;
	private double avg;
	
	public Student(String name,int kor,int eng) {
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		sum = kor+eng;
		avg = sum/2.0;
	}

	
	public void print() {
		System.out.println("이름:" + name);
		System.out.println("국어점수:" + kor);
		System.out.println("영어점수:" + eng);
		System.out.println("총합:" + sum);
		System.out.println("평균:" + avg);
	}
	
//	public String getName() {
//		return name;
//	}
//
//	public int getKor() {
//		return kor;
//	}
//
//	public int getEng() {
//		return eng;
//	}
//
//	public int getSum() {
//		return sum;
//	}
//	
//	public double getAvg() {
//		return avg;
//	}
	
}
