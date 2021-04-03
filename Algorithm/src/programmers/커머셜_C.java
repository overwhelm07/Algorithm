package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class 커머셜_C {
	public static void main(String[] args) {
		
		class Solution {
			class Path{
				boolean visited[];
				int currentLoc, cost, destination;
				
				public Path() {
					visited = new boolean[100001];
					cost = 0;
					destination = -1;
				}
				
				public void print() {
					System.out.println(currentLoc + " " + cost);
				}
				
				
				
			}
			
			//2<=n<=100,000
			//1<=passenger<=10,000
		    public int[] solution(int n, int[] passenger, int[][] train) {
		    	//0: dest, 1:cost
		        int[] answer = {-1, -1};
		        
		        //철로 map 정보 만들기
		        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		        for(int i=0; i<train.length; ++i) {
		        	//양방향 고려
	        		List list = map.get(train[i][0]-1);
	        		if(list == null) {
	        			list = new ArrayList<Integer>();
	        		}
	        		list.add(train[i][1]-1);
	        		map.put(train[i][0]-1, list);
	        		
	        		list = map.get(train[i][1]-1);
	        		if(list == null) {
	        			list = new ArrayList<Integer>();
	        		}
	        		list.add(train[i][1]-1);
	        		map.put(train[i][1]-1, list);
		        }
		        
		        Queue <Path> q = new LinkedList<Path>();
		        
		        Path firstPath = new Path();
		        firstPath.visited[0] = true;
		        firstPath.cost += passenger[0];
		        firstPath.currentLoc = 0;
		        q.add(firstPath);
		        
		        while(!q.isEmpty()) {
		        	Path path = q.poll();
		        	path.print();
		        	List <Integer>l = map.get(path.currentLoc);
		        	boolean isGo = false;
		        	
		        	if(l != null) {
		        		for(int i=0; i<l.size(); ++i) {
			        		int nextLocation = l.get(i);
			        		if(!path.visited[nextLocation]) {
			        			Path newPath = new Path();
			        			newPath.cost = path.cost + passenger[nextLocation];
			        			newPath.visited = path.visited.clone();
			        			newPath.visited[nextLocation] = true;
			        			newPath.currentLoc = nextLocation;
			        			q.add(newPath);
			        		}
			        	}
		        	}
		        	
		        	if(!isGo) {
		        		path.destination = path.currentLoc;
		        		//update
		        		if(answer[1] < path.cost || (answer[1] == path.cost && answer[0] < path.destination)) {
		        			answer[0] = path.destination;
		        			answer[1] = path.cost;
		        		}
		        	}
		        	path = null;
		        }
		        
		        answer[0]+=1; 
		        return answer;
		    }
		}

		Solution sol = new Solution();
		int [] ans = sol.solution(6, new int[] {1,1,1,1,1,1}, new int[][] {{1,2},{1,3},{1,4},{3,5},{3,6}});
		System.out.println(ans[0] + " " + ans[1]);
	}
}
