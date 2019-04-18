public class fooBar {
	
	public static void foo1(){
		System.out.println("hi1");
	}

	public static void foo2(){
		System.out.println("hi2");
	}
		
	public static void foo3(){
		System.out.println("hi3");
	}

	public static void allFoo() {
		foo1();
		foo2();
		foo3();
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		allFoo();
		System.out.println("Thank  you");
	}

}
