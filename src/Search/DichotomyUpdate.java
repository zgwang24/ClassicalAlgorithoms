package Search;

public class DichotomyUpdate {
	// 升级1
	public static int dichotomyUpdate(int[] a, int lo, int hi, int k){
		// hi不是最后一个元素
		while(hi - lo > 1){
			int mi = (lo + hi) >> 1;
			if(a[mi] > k){
				hi = mi;
			}else{
				lo = mi;
			}
		}
		// System.out.println(hi + " " + lo);
		return (k == a[lo])? lo : -1;
	}
	// 升级2
	public static int dichotomyUpdate2(int[] a, int lo, int hi, int k){
		while(lo < hi){
			int mi = (hi + lo) >> 1;
			if(k < a[mi]){
				hi = mi;
			}else{
				lo = mi + 1;
			}
		}
		return --lo;
	}
	public static void main(String[] args) {
		int[] a = {0, 1, 2, 3, 4, 6, 9, 100};
		System.out.println(dichotomyUpdate(a, 0, a.length, 100));
		System.out.println(dichotomyUpdate2(a, 0, a.length, 98));
	}
}
