package Search;

public class FibSearch {
	
	public static int fibSearch(int[] a, int lo, int hi, int k){
		int n = hi - lo;
		while(lo <= hi){
			while((hi - lo) < fib2(n)){
				n--;
			}
			int[] tmp = new int[fib2(n + 1)]; 
			for(int i = 0; i < tmp.length; i++){
				if(i >= a.length){
					tmp[i] = a[a.length - 1];
				}
				tmp[i] = a[i];
			}
			int mi = lo + fib2(n - 1) - 1;
			if(k < tmp[mi]){
				hi = mi;
			}else if(k > tmp[mi]){
				lo = mi + 1;
			}else{
				return mi;
			}
		}
		return -1;
	}
	// ì³²¨ÄÇÆõ
	private static int fib1(int n){
		return (n > 2) ? fib1(n - 1) + fib1(n - 2) : n;
	}
	// µü´ú
	private static int fib2(int n){
		int f = 0;
		int g = 1;
		while(n-- > 0){
			g = g + f;
			f = g - f;
		}
		return g;
	}
	public static void main(String[] args) {
		int[] a = {0, 1, 2, 3, 4, 6, 9, 100};
		System.out.println(fibSearch(a, 0, a.length - 1, 100));
	}
}	
