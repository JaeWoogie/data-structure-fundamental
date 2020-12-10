package codingForFun;

import java.util.Scanner;

public class EvaForFun {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		
		String username = sc.next();
		
		if(!username.equalsIgnoreCase("Jae")) {
			throw new IllegalArgumentException("You have to type Jae !!!!!!!");
		}
		
		if(username.equalsIgnoreCase("Jae")) {
			System.out.println("I love you eva");
		}
		
	}
	
    

	

}
