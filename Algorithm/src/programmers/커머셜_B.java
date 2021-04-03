package programmers;

import java.util.HashSet;
import java.util.Set;

public class 커머셜_B {
	public static void main(String[] args) {
		
		class Solution {
			
			int answer = 0, r;
			
			//needs 1<=row<=1,000   1<=col<=15
			public int solution(int[][] needs, int r) {
		        
				this.r = r; 
		        
				//DFS로 로봇 구매가 가능한 전체 경우의 수를 고려하여 검증
				Set availRobot = new HashSet<Integer>();
				dfs(needs, availRobot, 0, 0);
		        
		        return answer;
		    }

			private void dfs(int[][] needs, Set availRobot, int depth, int sumRobot) {
				
				if(depth >= needs[0].length) return;
				
				if(sumRobot == r) {
					int makeProductCount = 0;
					for(int i=0; i<needs.length; ++i) {
						makeProductCount++;
						for(int j=0; j<needs[i].length; ++j) {
							if(needs[i][j]==1 && !availRobot.contains(j)) {
								makeProductCount--;
								break;
							}
						}
					}
					
					if(makeProductCount > answer) {
						answer = makeProductCount;
					}
					
					return;
				}
				
				availRobot.add(depth);
				dfs(needs, availRobot, depth+1, sumRobot+1);
				availRobot.remove(depth);
				dfs(needs, availRobot, depth+1, sumRobot);
			}
		}

		Solution sol = new Solution();
		System.out.println(sol.solution(new int[][] {{ 1, 0, 0 }, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}}, 2));
	}
}
