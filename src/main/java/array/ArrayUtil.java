package array;

public class ArrayUtil {

	//Resize the array
	public int[] resizeArray(int arr[], int capacity) {
		int[] temp = new int[capacity];
		
		for(int i=0; i<arr.length; i++) {
			temp[i] = arr[i];
		}
		arr=temp;
		return arr;
	}
	
	//Print the array
	public void printArray(int[] arr) {
		int n = arr.length;
		for(int i=0; i<n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	//Check palindrome
	public boolean isPalindrome(String s) {
		char[] charArray = s.toCharArray();
		
		int start =0;
		int end = s.length()-1;
		
		while(start < end) {
			if(charArray[start] != charArray[end]) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		ArrayUtil arrUtil = new ArrayUtil();
		
		arrUtil.printArray(new int[] {1,2,3,4,5});
		
		int[] original = new int[] {1,2,3,4,5};
		
		System.out.println("Size of the original Array " + original.length);
		
		original = arrUtil.resizeArray(original, 10);
		System.out.println("Size of the resize original Array " + original.length);
		
		
		String s = "check";
		boolean check = arrUtil.isPalindrome(s);
		System.out.println(check);
	}
}
