package array;

public class FindTopTwoMax {
	// 先将最大的找到，分别在其左右两侧找最大的即可
	public static int[] findTopTwoMax1(int[] a){
		int [] r= new int[2];
		int max = a[0];
		int maxIndex = 0;
		for(int i = 1; i < a.length; i++){
			if(a[i] > max){
				max = a[i];
				maxIndex = i;
			}
		}
		int sMax = a[0];
		for(int i = 0; i < maxIndex; i++){
			if(a[i] > sMax){
				sMax = a[i];
			}
		}
		for(int i = maxIndex + 1; i < a.length; i++){
			if(a[i] > sMax){
				sMax = a[i];
			}
		}
		r[0] = max;
		r[1] = sMax;
		return r;
	}
	// 迭代方式
	public static int[] findTopTwoMax2(int[] a){
		int[] r = new int[2];
		int max = a[0];
		int sMax = a[1];
		if(sMax > max){
			max = max + sMax - (sMax = max);
		}
		for(int i = 2; i < a.length; i++){
			if(a[i] > sMax){
				sMax = (sMax + a[i]) - (a[i] = sMax);
				if(sMax > max){
					max = max + sMax - (sMax = max);
				}
			}
		}
		r[0] = max;
		r[1] = sMax;
		return r;
	}
	// 分治
	public static int findTopTwoMax3(int[] a, int lo, int hi, int max, int sMax){
		if(lo + 2 == hi){
			return 0;
		}
		if(lo + 3 == hi){
			return 0;
		}
		int mi = (lo + hi) / 2;
		int max1 = 0, sMax1 = 0;
		findTopTwoMax3(a, lo, mi, max1, sMax1);
		int max2 = 0, sMax2 = 0;
		findTopTwoMax3(a, mi + 1, hi, max2, sMax2);
		if(max1 > max2){
			max = max1;
			sMax = (max2 > sMax1) ? max2 : sMax1;
		}else{
			max = max2;
			sMax = (max1 > sMax2) ? max1 : sMax2;
		}
		return max; 
	}
	public static void main(String[] args) {
		int[] a = {1, 3, 5, 8, 7, 10};
		int[] r = findTopTwoMax1(a);
		System.out.println(r[0]);
		System.out.println(r[1]);
		int[] r2 = findTopTwoMax2(a);
		System.out.println(r2[0]);
		System.out.println(r2[1]);
		System.out.println(findTopTwoMax3(a, 0, a.length - 1, 0, 0));
		
	}
}
