package array;

public class MaxDvalue {
	// method1
	public static int getMaxDvalue1(int[] a){
		int min = a[0];
		int val = a[1] - a[0];
		for(int i = 1; i < a.length; i++){
			if(a[i] < min){
				min = a[i];
			}
			if((a[i] - min) > val){
				val = a[i] - min;
			}
		}
		return val;
	}
	// method2
	public static int getMaxDvalue2(int[] a){
		int val = a[1] - a[0];
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a.length; j++){
				if((a[j] - a[i]) > val){
					val = a[j] - a[i];
				}
			}
		}
		return val;
	}
	public static void main(String[] args) {
		int[] a = { 1, 5, 7, 90, 45, 0, 100};
		System.out.println(getMaxDvalue1(a));
		System.out.println(getMaxDvalue2(a));
	}
}
