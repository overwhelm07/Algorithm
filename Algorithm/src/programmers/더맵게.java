package programmers;

import java.util.PriorityQueue;
import java.util.Queue;

public class 더맵게 {

	//섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
	public static void main(String[] args) {
		class Solution {
			public int solution(int[] scoville, int K) {
				
				
				Queue<Integer> q = new PriorityQueue<Integer>(1000001);
				
				for(int i=0; i<scoville.length; ++i) {
					q.add(scoville[i]);
				}
				
				int answer = 0;
				int t = 0;
				while(q.peek() < K) {
					if(q.size()<=1) {
						return -1;
					}
					
					Integer min = q.poll(), min2 = q.poll();
					t = min + (min2*2);
					q.add(t);					
					answer++;
//					System.out.println(ret + " a:" + min + " b:" + min2 + " t:" +t);
				}
				
				return answer;
			}
		}
		
		Solution s = new Solution();
//		System.out.println(s.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
		System.out.println(s.solution(new int[]{10, 10, 10, 10, 10}, 100));
//		System.out.println(s.solution(new int[]{2, 3, 7, 10, 15}, 3));
	}

	
}
