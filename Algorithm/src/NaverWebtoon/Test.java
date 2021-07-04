package NaverWebtoon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		class Solution {
		    public int[] solution(int[][] v) {
		        int[] answer = new int[2];
		        
		        Set<Integer> xt = new HashSet<Integer>();
		        Set<Integer> yt = new HashSet<Integer>();
		        //find x
		        for(int i=0; i<v.length; ++i) {
		        	if(!xt.contains(v[i][0])) {
	        			xt.add(v[i][0]);
	        		}else {
	        			xt.remove(v[i][0]);
	        		}
		        	
		        	if(!yt.contains(v[i][1])) {
	        			yt.add(v[i][1]);
	        		}else {
	        			yt.remove(v[i][1]);
	        		}
		        }
		        
		        answer[0] = xt.iterator().next();
		        answer[1] = yt.iterator().next();
		        

		        return answer;
		    }
		}
		
		Solution sol = new Solution();
		int[][] in = {{1, 4}, {3, 4}, {3, 10}}; 
		System.out.println(Arrays.toString(sol.solution(in)));
	}
}
