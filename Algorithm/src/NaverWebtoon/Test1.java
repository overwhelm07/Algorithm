package NaverWebtoon;

import java.util.Arrays;
import java.util.Collections;

public class Test1 {
	public static void main(String[] args) {
		class Solution {
		    public int solution(int[] prices, int[] discounts) {
		        
		    	int answer = 0;
		    	prices = Arrays.stream(prices).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
		    	discounts = Arrays.stream(discounts).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
		        
		        //System.out.println(Arrays.toString(prices));
		        
		        int discountIdx = 0;
		        
		        for(Integer price : prices) {
		        	
		        	if(discountIdx < discounts.length) {
		        		price = price - (price * discounts[discountIdx] / 100);
		        		discountIdx++;
		        	}
		        	answer += price;
		        }
		        
		        return answer;
		    }
		}
		
		Solution sol = new Solution();
		
		System.out.println(sol.solution(new int[] {13000, 88000, 10000}, new int[] {30, 20}));
		
	}
}
