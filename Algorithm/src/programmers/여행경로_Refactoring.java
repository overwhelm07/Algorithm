package programmers;

public class 여행경로_Refactoring {

	//https://programmers.co.kr/learn/courses/30/lessons/43165
	public static void main(String[] args) {
		class Solution {
		    public int solution(int[] numbers, int x) {
		        
		        //dfs	        
		    	if(numbers.length < 1) return 0;
		    	
		        return dfs(numbers, 1, numbers[0], x) + dfs(numbers, 1, -numbers[0], x);
		        
		    }
		    
		    int dfs(int[] numbers, int depth, int sum, int target) {

		    	if(numbers.length==depth) {
		    		if(sum == target) {
		    			return 1;
		    		}else {
		    			return 0;
		    		}
		    	}
		    	
		    	return dfs(numbers, depth+1, sum+numbers[depth], target) + dfs(numbers, depth+1, sum-numbers[depth], target); 
		    }
		}
		
		Solution sol = new Solution();
		System.out.println(sol.solution(new int[] {1, 1, 1, 1, 1}, 3));
	}
	
}
