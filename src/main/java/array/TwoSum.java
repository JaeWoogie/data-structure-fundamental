package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static int[] twoSum(int[] num, int target) {
		int[] result = new int[2];
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i< num.length; i++) {
			if(!map.containsKey(target-num[i])) {
				map.put(num[i], i);
			}
			else {
				result[1] = i;
				result[0] = map.get(target-num[i]);
				return result;
			}
		}
		
		throw new IllegalArgumentException("Two number is not found");
	}
	
	public static void main(String[] args) {
		int[] number = new int[] {2,11,5,10,7,8};
		
		int[] result = twoSum(number, 9);
		
		System.out.println(result[0] + " "+ result[1]);
	}
}
