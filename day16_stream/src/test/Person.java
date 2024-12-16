package test;

public class Person implements Comparable<Person>{
	private String name;
	private int age;
	
	public Person() {}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	
	@Override
	public int compareTo(Person o) {
//		//방법1)
//		//나이순으로 내림차순 정렬
//		if(age>o.age) {
//			return -1;
//		}else if(age<o.age) {
//			return 1;
//		}else {
//			return 0;
//		}
		
		
//		//방법2)
//		//public static int compare(int x,int y) : 두값이 같으면0, x가 크면 양수, x가 작으면 음수 변환(오름차순)
//		// -->Integer의 메소드
//		//나이순으로 오름차순 정렬
//		return Integer.compare(age, o.age);
//		
//		//나이순으로 내림차순 정렬
//		return Integer.compare(age, o.age)*-1;
		
		
//		//이름순으로 오름차순 정렬
//		//public int compareTo(String anotherString) -->String의 메소드
//		return name.compareTo(o.name);
		
		//이름순으로 내림차순 정렬
		return name.compareTo(o.name)*-1;
		
	}
	
	
}
