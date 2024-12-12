package day06_2;
/*
 * 아래와 같은 구조의 인터페이스와 이를 구현하는 클래스를 만들어 보세요.
 *  			[동물인터페이스]
 * 					|
 *    [강아지]      [사람]     [고양이]
 *    걷는기능      걷는기능     걷는기능
 *    짖는기능      짖는기능     짖는기능
 *    꼬리흔들기     공부하기     쥐잡기
 */

interface Animal{
	void work();
	void sound();
}

class Dog implements Animal{
	@Override
	public void work() {
		System.out.println("강아지가 걷는다");
	}
	
	@Override
	public void sound() {
		System.out.println("멍멍!");
	}
	
	public void tail() {
		System.out.println("꼬리 흔들기");
	}
}

class Person implements Animal{
	@Override
	public void work() {
		System.out.println("사람이 걷는다");
	}
	
	@Override
	public void sound() {
		System.out.println("안녕하세요!");
	}
	
	public void study() {
		System.out.println("공부하기");
	}
}

class Cat implements Animal{
	@Override
	public void work() {
		System.out.println("고양이가 걷는다");
	}
	
	@Override
	public void sound() {
		System.out.println("냐옹!");
	}
	
	public void catching() {
		System.out.println("쥐 잡기");
	}
}

public class Test11_Quiz {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Person person = new Person();
		Animal cat = new Cat();
		
		dog.work();
		dog.sound();
		dog.tail();
		
		person.work();
		person.sound();
		person.study();
		
		cat.work();
		cat.sound();
		Cat c=(Cat)cat;
		c.catching();
	}
}
