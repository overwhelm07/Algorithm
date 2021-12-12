package programmers;

import java.util.HashSet;
import java.util.Set;

public class 전화번호목록 {
	public static void main(String[] args) {
		class Solution {
		    public boolean solution(String[] phoneNumList) {
		        
		        Set<String> set = new HashSet<String>();
		        
		        for(String num : phoneNumList) {
		        	set.add(num);
		        }
		        
		        for(String num : phoneNumList) {
		        	StringBuffer prefix = new StringBuffer();
		        	
		        	for(int i=0; i<num.length()-1; ++i) {
		        		prefix.append(num.charAt(i));
		        		
		        		if(set.contains(prefix.toString())) {
		        			return false;
		        		}
		        		//System.out.println(prefix.toString());
		        	}
		        }
		        
		        
		        return true;
		    }
		}
		
		Solution sol = new Solution();
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(sol.solution(phone_book ));
		System.out.println(sol.solution(new String[]{"123","456","789"}));
	}
}
