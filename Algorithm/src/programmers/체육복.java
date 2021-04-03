package programmers;

import java.util.Arrays;

public class 체육복 {
	public static void main(String[] args) {
		//Greedy Algorithm 
		class Solution {
			public int solution(int n, int[] lost, int[] reserve) {
				int ret = n - lost.length;

				Arrays.sort(lost);
				Arrays.sort(reserve);
				boolean[] isReserve = new boolean[reserve.length];
				boolean[] isLost = new boolean[lost.length];
				
				for(int i=0; i<reserve.length; ++i) {
					
					int t = Arrays.binarySearch(lost, reserve[i]);
					if(t>=0) {
						isReserve[i] = true;
						isLost[t] = true;
						ret++;
					}
				}
				
				for(int i=0; i<reserve.length; ++i) {
					if(isReserve[i]) continue;
					
					int id = reserve[i];
					
					for(int j=0; j<lost.length ; ++j) {
						if(isLost[j]) continue;
						
						if(lost[j]+1==id || lost[j]-1==id) {
							isLost[j] = true;
							isReserve[i] = true;
							ret++;
							break;
						}
					}
				}
				
				return ret;
			}
		}
		
		int n = 10;
		int[] lost = {5, 7, 9};
		int[] reserve = {1, 2, 3, 4, 6, 8};

		Solution sol = new Solution();

		System.out.println(sol.solution(n, lost, reserve));
		
	}
	
}

