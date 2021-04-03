package programmers;

import java.util.Arrays;

public class 모의고사 {

	public static void main(String[] args) {
		class Solution {
		    public int[] solution(int[] answers) {
		        
		    	
		    	/**
		    	 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 				 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
				 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
		    	 */
		    	
		    	int [] l1 = {1, 2, 3, 4, 5};
		    	int [] l2 = {2, 1, 2, 3, 2, 4, 2, 5};
		    	int [] l3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		    	int i1, i2, i3;
		    	int []correctCounts = new int[4]; 
		    	i1=i2=i3=0;
		    	
		    	for(int i=0; i<answers.length; ++i) {
		    		if(i1>= l1.length) i1=0;
		    		if(i2>= l2.length) i2=0;
		    		if(i3>= l3.length) i3=0;
		    		
		    		int answer = answers[i];
		    		if(answer == l1[i1++]) {
		    			correctCounts[1]++;
		    		}
		    		if(answer == l2[i2++]) {
		    			correctCounts[2]++;
		    		}
		    		if(answer == l3[i3++]) {
		    			correctCounts[3]++;
		    		}
		    	}
		        
		    	int []answer = new int[3];
		    	
		    	int maxCorrectCount = 0;
		    	for(int i=1; i<=3; ++i) {
		    		if(maxCorrectCount < correctCounts[i]) {
		    			maxCorrectCount = correctCounts[i];
		    		}
		    	}
		    	
		    	int idx = 0;
		    	for(int i=1; i<=3; ++i) {
		    		if(maxCorrectCount == correctCounts[i]) {
		    			answer[idx++] = i;
		    		}
		    	}
		    	
		    	int []ret = new int[idx];
		    	for(int i=0; i<answer.length && answer[i] != 0; ++i) {
		    		ret[i] = answer[i];
		    	}
		        
		        return ret;
		    }
		}
		
		Solution sol = new Solution();
//		System.out.println(Arrays.toString(sol.solution(new int[] {1,3,2,4,2})));
		System.out.println(Arrays.toString(sol.solution(new int[] {1,2,3,4,5})));
		
		
	}

}
