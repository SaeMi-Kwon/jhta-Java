package quiz;
//1. 아래와 같은 프로그램(main)이 실행될 수 있도록 MyArray클래스를 만들어 보세요.

class MyArray {
	 //정렬 메소드
	   public static void sort(int[] a){
	       int n= a.length;
	       for(int i=0;i<n;i++){
	           for(int j=0;j<n-1;j++){
	               if(a[j]>a[j+1]){
	                   int temp=a[j];
	                   a[j]=a[j+1];
	                   a[j+1]=temp;
	               }
	           }
	           System.out.print(a[i]+ " ");
	       }
	       System.out.println();
	   }


	   //역순 메소드
	   public static void reverse(int[] a){
	       int firstIndex=0;
	       int lastIndex=a.length-1;
	       for(;firstIndex<lastIndex;firstIndex++,lastIndex--) {
	           int temp = a[firstIndex];
	           a[firstIndex] = a[lastIndex];
	           a[lastIndex] = temp;
	       }
	       //출력
	       for(int i=0;i<a.length;i++){
	           System.out.print(a[i] + " ");
	       }
	       System.out.println();
	   }


	   //최댓값 메소드
	   public static int max(int[] a){
	       int max=0;
	       for(int i=0;i<a.length;i++){
	           if(a[i]>max) {
	               max = a[i];
	           }
	       }
	       return max;
	   }

}

public class Test01 {
	public static void main(String[] args){
		int[] a={4,6,29,10,30};
		MyArray.sort(a); //배열이 오름차순정렬되어 출력됨 : 4 6 10 29 30
		MyArray.reverse(a); //배열이 거꾸로 출력됨 : 30 10 29 6 4
		int max=MyArray.max(a); //배열요소중 가장 큰값을 얻어옴
		System.out.println("배열요소중가장큰값:" + max);
	}
}
