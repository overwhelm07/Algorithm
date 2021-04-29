package Kakao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class 후보키 {

	public static void main(String[] args) {
		class Solution {
			/**
			 * 후보키 조건: 유일성, 최소성 
			 * @param relation
			 * @return
			 */
			static final int MAX_COL = 8;
			String[][] RELATION;
			int count[] = new int[MAX_COL+1];
			int row, col;
			
			class Info{
				List <Integer> sel;
				int ans;
				Set<String> set = new HashSet<>();
				
				public Info(List<Integer> sel) {
					this.sel = sel;
					ans = 0;
				}
				
				public boolean isUnique() {
					StringBuffer sb = new StringBuffer();
					
					for(int i=0; i<row; ++i) {
						
						for(Integer t : sel) {
							sb.append(String.valueOf(t)+RELATION[i][t]);
						}
						
						if(set.contains(sb.toString())) {
							return false;
						}else {
							set.add(sb.toString());
							sb = new StringBuffer();
						}
					}
					//System.out.println(sb.toString());
					set = null;
					return true;
				}
				
				public List<Integer> getCurrentSelInfo(){
					return sel;
				}
			
				public List<Integer> cloneSelInfo(){
					List<Integer> newCurrentSelInfo = new ArrayList<Integer>();
					for(int i=0; i<sel.size(); ++i) {
						newCurrentSelInfo.add(sel.get(i));
					}
					return newCurrentSelInfo;
				}
				
			}
		    public int solution(String[][] relation) {
		    	RELATION = relation.clone();
		    	
		        int answer = 0;
		        
		        row = relation.length;
		        col = relation[0].length;
		        
		        Queue <Info> q = new LinkedList<Info>();
		        
		        for(int i=0; i<col; ++i) {
		        	List<Integer> sel = new ArrayList<>();
		        	sel.add(i);
		        	q.add(new Info(sel));
		        	//System.out.println("insert q " + sel.size());
		        }
		        
		        while(!q.isEmpty()) {
		        	Info t = q.poll();
		        	if(t.isUnique()) {
		        		
		        		//최소성 검증
		        		for(Integer tSelVal : t.sel) {
		        			if(count[tSelVal] < t.sel.size()) {
		        				continue;
		        			}
		        		}
		        		
		        		for(Integer tSelVal : t.sel) {
		        			count[tSelVal] = t.sel.size();
		        		}
		        		
		        		answer++;
		        	}else {
		        		List<Integer> currentSelInfo = t.getCurrentSelInfo();
		        		int x = currentSelInfo.get(currentSelInfo.size()-1)+1;
		        		
		        		for(;x<col; ++x) {
		        			if(count[x]!=0)continue;
		        			List<Integer> newSelInfo = t.cloneSelInfo();
		        			newSelInfo.add(x);
		        			q.add(new Info(newSelInfo));
		        			//System.out.println("insert q " + newSelInfo.size());
		        		}
		        	}
		        }
		        
		        return answer;
		    }
			
		}
		
		Solution sol = new Solution();
		System.out.println(sol.solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}));

	}

}
