package array;

public class ReverseArray {
	public static void reverseArray(int[] a, int lo, int hi){
		if(lo < hi){
			a[lo] = (a[lo] + a[hi]) - (a[hi] = a[lo]);
			reverseArray(a, lo + 1, hi - 1);
		}else{
			return ;
		}
		
	}
	public static void main(String[] args) {
		int[] a = {1, 3, 5, 7, 9, 11};
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		reverseArray(a, 0, a.length - 1);
		System.out.println();
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		
		
	}
}
