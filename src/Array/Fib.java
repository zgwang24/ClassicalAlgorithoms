package Array;

public class Fib {
	// ì³²¨ÄÇÆõO(2^n)
	public static int fib(int n){
		return (n > 2) ? fib(n - 1) + fib(n - 2) : n; 
	}
	// µü´úO(n)
	public static int fib2(int n){
		int f = 0;
		int g = 1;
		while(n-- > 0){
			g = g + f;
			f = g - f;
		}
		return g;
	}
	public static void main(String[] args) {
		for(int i = 0; i < 30; i++){
			System.out.println(fib(i));
		}
		for(int i = 0; i < 30; i++){
			System.out.println(fib2(i));
		}
	}
}
