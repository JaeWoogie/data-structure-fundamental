package dynamicProgramming;


public class FibonacciNumber {
	
	//Bottom up approach
	public int fid(int n) {
		int[] table = new int[n+1];
		
		table[0] = 0;
		table[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			table[i] = table[i - 1] + table[i - 2];
		}
		
		return table[n];
	}
	
	//Top down approach
	public int fib(int[] memo, int n) {
		if(memo[n] < 2) {
			if(n < 2) {
				memo[n] = n; //0 and 1
			}
			else {
				// Current number is sum of its preceding numbers
				int left = fib(memo, n - 1);
				int right = fib(memo, n - 2);
				memo[n] = left + right;
			}
		}	
		return memo[n];
	}
	
	
	public static void main(String[] args) {
		FibonacciNumber fn = new FibonacciNumber();
		
		System.out.println("The nth number is: " + fn.fid(6));
		
		
		System.out.println(fn.fib(new int[6+1], 6));
	}
}
