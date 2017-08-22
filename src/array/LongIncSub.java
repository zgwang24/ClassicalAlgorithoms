package array;

public class LongIncSub {
	/**
	 * ͳ���������������������Ԫ�صĸ���
	 * @param peaches
	 * @return
	 */
	static int pick(int[] peaches) {
		int count = 0, n = peaches.length;
		int[] memo = new int[n];
		for(int i = 0; i < n; i++){
			memo[i] = 1;
			for(int j = 0; j < i; j++){
				if(peaches[j] < peaches[i] && (memo[j] + 1 > memo[i])){
					memo[i] = memo[j] + 1;
				}
			}
		}
		for(int i = 0; i < n; i++){
			if(memo[i] > count){
				count = memo[i];
			}
		}		
		return count;
    }
}
