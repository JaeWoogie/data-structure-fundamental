package codingForFun;

public class CheckSales {
	
	
	
	public static void main(String[] args) {
		int[] p = {5,5,5,5,11};
		int[] c = {10,11,16,22,10};
		int n = p.length;
		
		System.out.println(solution(p,c,n));
	}
	
	public static String solution(int[] p, int[] c, int n) {
		double resultInt=0;
		double finalResult=0;
		String result="";
		
		int countDay=0;
		int leftOver=0;
		
		double firstDay = 100;
		double secondDay = 50;
		double fourthDay = 25;
		
		for(int i=0; i<n; i++) {
			if(p[i]+leftOver<c[i]) {
				countDay++;
				leftOver += p[i] + leftOver + c[i];
			}
			else if(p[i]>=c[i]) {
				resultInt += c[i] * firstDay;
				leftOver += p[i] + leftOver -c[i];
			}
		}
		
		for(int i=0; i<n; i++) {
			if(countDay == 1 && p[i]+leftOver>=c[i]) {
				resultInt += c[i] * secondDay;
				leftOver += p[i]+leftOver - c[i];
				countDay=0;
			}
			else if((countDay>=2 && countDay<=3) && p[i]+leftOver>=c[i]) {
				resultInt += c[i] * fourthDay;
				leftOver += p[i]+leftOver - c[i];
				countDay=0;
			}
			if(countDay>=4) {
				resultInt += resultInt;
				break;
			}
		}
		
		finalResult = resultInt/n;
		
		result = String.valueOf(finalResult);
		result = String.format("%.2f", finalResult);
		return result;
	}
}
