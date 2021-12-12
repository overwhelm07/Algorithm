package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기능개발 {

	public static void main(String[] args) {
		
		class Solution {
		    public int[] solution(int[] progresses, int[] speeds) {
		        
		    	List<Integer> answer = new ArrayList<Integer>();
		    	
		    	int totalDay = 0, idx = 0, count = 0;
		    	
		    	for(int progress : progresses) {
		    		
		    		int speed = speeds[idx++];
		    		int needDay = (int) Math.ceil(((double)(100-progress)/(double)speed));
		    		//int needDay = (int) Math.ceil((double)((100-progress)/speed));
		    		System.out.println("totalday:" + totalDay + " progress:"+progress + " needDay:"+needDay);
		    		
		    		if(totalDay >= needDay) {
		    			count++;
		    		}else {
		    			totalDay+=(needDay-totalDay);
		    			if(count==0) {
		    				count++;
		    				continue;
		    			}
		    			answer.add(count);
		    			count = 1;
		    		}
		    	}
		    	
		    	if(count > 0) {
		    		answer.add(count);
		    	}
		    	
		        
		        return answer.stream().mapToInt(i->i).toArray();
		        
		    }

		}
		
		Solution sol = new Solution();
		
		System.out.println(Arrays.toString(sol.solution(new int[] {93,30,55}, new int[] {1,30,5})));
		System.out.println(Arrays.toString(sol.solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1})));

	}

}
