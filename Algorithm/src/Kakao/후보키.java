package Kakao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 후보키 {

	public static void main(String[] args) {
		class Solution {

			int row = 0, col = 0;
			/**
			 * 후보키 조건: 유일성, 최소성 
			 * @param relation
			 * @return
			 */
			public int solution(String[][] strings) {
				row = strings.length;
				col = strings[0].length;
				
				
				List<Integer> subsets = new ArrayList<Integer>();
				
				// 1 << 4 --> 10000 16 1~15 0001~1111 
				int ans = 0;
				//bitmasking 
				for(int i=1; i<(1<<col); ++i) {
					System.out.println(Integer.toBinaryString(i));
					
					boolean isDup = false;
					
					//check unique
					Set<String> set = new HashSet<>();
					for(int r=0; r<row; ++r) {
						StringBuffer sb = new StringBuffer();
						for(int c=0; c<col; ++c) {
							if((i & (1<<c)) > 0) {
								sb.append(strings[r][c]);
							}
						}
						
						if(!set.contains(sb.toString())){
							set.add(sb.toString());
							System.out.println("add : " + sb.toString());
						}else {
							isDup = false;
							break;
						}
					}
					
					if(set.size()==row && !isDup) {
						boolean isNotSubset = true;
						//check minimulism
						for(Integer subset : subsets) {
							System.out.println(subset + " " + (subset&i));
							if((subset&i)==subset) {
								isNotSubset = false;
								break;
							}
						}
						
						if(isNotSubset) {
							subsets.add(i);
							ans++;
						}
					}
					
				}
				
				return ans;
			}
			
			
		}
		
		Solution sol = new Solution();
		System.out.println(sol.solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}));

	}

}
