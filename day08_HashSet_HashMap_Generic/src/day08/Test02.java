package day08;

import java.util.HashSet;
import java.util.Iterator;

import test.Person;

public class Test02 {
	public static void main(String[] args) {
		HashSet<Person> set = new HashSet<Person>();
		set.add(new Person("홍길동",10));
		set.add(new Person("이길동",20));
		set.add(new Person("삼길동",30));
		
		Iterator<Person> it = set.iterator();
		
		while(it.hasNext()) {
			Person p=it.next();
			p.print();
		}
	}
}
