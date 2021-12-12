package Kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 실패율 {
	public static void main(String[] args) {
		class Solution {
			class Stage {
				int stageNum;
				double failRate;
				
				public Stage(int stageNum, double failRate) {
					this.stageNum = stageNum;
					this.failRate = failRate;
				}

				@Override
				public String toString() {
					return stageNum + " " + failRate;
				}
			}
		    public int[] solution(int N, int[] stages) {
		        int[] answer = new int[N];
		        int[] userNum = new int[N+1];
		        int[] notClearUserNum = new int[N+1];
		        
		        //O(n^2)
		        for(int i=0; i<stages.length; ++i) {
		        	for(int j=1; j<=stages[i]&&j<=N; ++j) {
		        		userNum[j]++;
		        	}
		        	if(stages[i] <= N) {
		        		notClearUserNum[stages[i]]++;
		        	}
		        }
		        
		        List<Stage> stageList = new ArrayList<>();
		        for(int i=1; i<=N; ++i) {
		        	if(userNum[i] == 0) {
		        		stageList.add(new Stage(i, 0.0));
		        		continue;
		        	}
		        	
		        	stageList.add(new Stage(i, (double)notClearUserNum[i] / (double)userNum[i]));
		        	//System.out.println(notClearUserNum[i] + " " + userNum[i]);
		        	System.out.println(stageList.get(i-1).toString());
		        }
		        
		        //O(nlogn)
		        Collections.sort(stageList, new Comparator<Stage>() {

					@Override
					public int compare(Stage o1, Stage o2) {
						if(o1.failRate == o2.failRate) {
							//stageNum ascending
							return o1.stageNum - o2.stageNum;
						}
						//failRate descending
						double val = o2.failRate - o1.failRate;

						if(val > 0) {
							return 1;
						}else {
							return -1;
						}
					}
		        	
				});

		        int idx = 0;
				for(Stage s : stageList) { 
					answer[idx++] = s.stageNum; 
				}
		        return answer;
		    }
		}
		
		
		Solution sol = new Solution();
		
		System.out.println(Arrays.toString(sol.solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3})));
//		System.out.println(Arrays.toString(sol.solution(1, new int[] {2})));
	}
}
