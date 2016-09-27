package Array;

public class ArraySum {
	// 利用循环进行数组循环
	public static int arraySum(int[] a){
		int sum = 0;
		for(int i = 0; i < a.length; i++){
			sum += a[i];
		}
		return sum;
	}
	// 减而治之递归实现
	public static int arraySum2(int[] a, int n){
		return (n < 1) ? 0 : arraySum2(a, n - 1) + a[n - 1];
	}
	// 分而治之
	public static int arraySum3(int[] a, int lo, int hi){
		if(lo == hi){
			return a[lo];
		}
		int mi = (hi + lo) >> 1;
		return arraySum3(a, lo, mi) + arraySum3(a, mi + 1, hi);
	}
	
	
	public static void main(String[] args) {
		int[] a = {1, 3, 5, 9, 10};
		System.out.println(arraySum(a));
		System.out.println(arraySum2(a, a.length));
		System.out.println(arraySum3(a, 0, a.length - 1));
	}
}

