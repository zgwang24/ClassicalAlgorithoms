package Array;

public class MedianNum {
	// 1分治思想
	public static int medianNum1(int[] a){
		quickSort(a, 0, a.length - 1);
		int median = a[a.length / 2 - 1];
		return median;
	}

	private static void quickSort(int[] a, int lo, int hi) {
		if(hi <= lo){
			return ;
		}
		int p = partition(a, lo, hi);
		quickSort(a, lo, p - 1);
		quickSort(a, p + 1, hi);
	}

	private static int partition(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		int v = a[lo];
		while(true){
			while(a[++i] < v){
				if(i == hi){
					break;
				}
			}
			while(a[--j] > v){
				if(j == lo){
					break;
				}
			}
			if(i >= j){
				break;
			}
			a[i] = a[i] + a[j] - (a[j] = a[i]);
		}
		a[lo] = a[j] + a[lo] - (a[j] = a[lo]);
		return j;
	}
	// 
	public static int medianNum2(int[] a){
		int[] newA = new int[a.length / 2];
		for(int i = 0; i < a.length / 2; i++){
			newA[i] = a[i];
		}
		for(int i = 0; i < newA.length; i++){
			dowm(newA, 0, newA.length);
		}
		for(int i = newA.length + 1; i < a.length; i++){
			if(a[i] < newA[0]){
				newA[0] = a[i];
				dowm(newA, 0, newA.length);
			}
		}
		return newA[0];
	}
	private static void dowm(int[] newA, int i, int j) {
		int child;
		while(2 * i + 1 < j){
			child = 2 * i + 1;
			if(child != j - 1 && newA[child] < newA[child + 1]){
				child++;
			}
			if(newA[i] < newA[child]){
				newA[i] = newA[i] + newA[child] - (newA[child] = newA[i]);
			}
			i = child;
		}	
	}

	public static void main(String[] args) {
		int[] a = {0, 4, 5, 2, 7, 8, 8, 9, 9, 10, 23, 6};
		System.out.println(medianNum1(a));
		System.out.println(medianNum2(a)); 
	}
}
