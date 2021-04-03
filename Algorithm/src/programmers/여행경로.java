package programmers;

import java.util.ArrayList;
import java.util.List;

public class 여행경로 {

	//https://programmers.co.kr/learn/courses/30/lessons/43165
	public static void main(String[] args) {
		class Solution {
			
			int answer = 0;
			int target = 0;
			List<Integer> l = new ArrayList<Integer>();
			
		    public int solution(int[] numbers, int x) {
		        

		        for(int i=0; i<numbers.length; ++i) {
		        	l.add(numbers[i]);
		        }
		        
		        this.target = target;
		        //+(1) or -(0)
		        //dfs	        
		        dfs(0, 0, 0);
		        dfs(1, 0, 0);
		        
		        return answer;
		    }
		    
		    void dfs(int op, int depth, int sum) {
//		    	System.out.println(op + " " + depth  + " " +sum);
		    	if(l.size()==depth) {
		    		return;
		    	}
		    	
		    	if(op==1) {
		    		sum+=l.get(depth);
		    	}else {
		    		sum-=l.get(depth);
		    	}
		    	
		    	if(l.size()==depth+1) {
		    		if(sum == target) {
//		    			System.out.println("dep!" + sum);
		    			answer++;
		    		}
		    		return;
		    	}
		    	
		    	dfs(0, depth+1, sum);
		    	dfs(1, depth+1, sum);
		    	
		    	
		    }
		}
		
		Solution sol = new Solution();
		System.out.println(sol.solution(new int[] {1, 1, 1, 1, 1}, 3));
	}
	
	
	
	
}
