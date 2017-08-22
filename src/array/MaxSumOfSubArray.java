package array;

public class MaxSumOfSubArray {
	// 1暴力
	public static int maxSumOfSubArray1(int[] a){
		int maxSum = a[0];
		for(int i = 0; i < a.length; i++){
			int maxI = 0;
			for(int j = i; j < a.length; j++){
				maxI = maxI + a[j];
				if(maxI > maxSum){
					maxSum = maxI;
				}
			}
		}
		return maxSum;
	}
	// 2分支界定
	public static int maxSumOfSubArray2(int[] a, int i, int j){
		if(j == i){
			return a[i];
		}
		int mid = (i + j) / 2;
		int r1 = maxSumOfSubArray2(a, i, mid);
		int r2 = maxSumOfSubArray2(a, mid + 1, j);
		int r3 = maxSumOfSubArryOnCross(a, i, mid, j);
		return Math.max(Math.max(r1, r2),r3);
	}

	private static int maxSumOfSubArryOnCross(int[] a, int i, int mid, int j) {
		// TODO Auto-generated method stub
		int leftMaxSum = a[mid];
		int rightMaxSum = a[mid + 1];
		int leftSum = 0;
		int rightSum = 0;
		for(int m = mid; m >= 0; m--){
			leftSum = leftSum + a[m];
			if(leftSum > leftMaxSum){
				leftMaxSum = leftSum;
			}
		}
		for(int n = mid + 1; n <= j; n++){
			rightSum = rightSum + a[n];
			if(rightSum > rightMaxSum){
				rightMaxSum = rightSum;
			}
		}
		return leftMaxSum + rightMaxSum;
	}
	public static void main(String[] args) {
		int[] a = {0, 34, -90, 45, -8, 7, 34, 43, -10, 100};
		System.out.println(maxSumOfSubArray2(a, 0, a.length - 1));
		System.out.println(maxSumOfSubArray1(a));
	}
}
