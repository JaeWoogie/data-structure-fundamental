package codingForFun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicate {

	
	public static List<Integer> solution(List<Integer> target) {
		
		List<Integer> getList = new ArrayList<Integer>();
		
		for(int check: target) {
			if(!getList.contains(check)) {
				getList.add(check);
			}	
		}
		return getList;
	}
	
	
	public static void main(String[] args) {
		List<Integer> 
        list = new ArrayList<Integer>( 
            Arrays 
                .asList(1, 10, 1, 2, 2, 3, 3, 10, 3, 4, 5, 5));
		
		// Print the Arraylist 
        System.out.println("ArrayList with duplicates: "
                           + list); 
  
        // Remove duplicates 
        List<Integer> 
            newList = solution(list); 
  
        // Print the ArrayList with duplicates removed 
        System.out.println("ArrayList with duplicates removed: "
                           + newList); 
	}
}
