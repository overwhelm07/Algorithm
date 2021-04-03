package programmers;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수{
	
	public static void main(String[] args) {
		
	}
	
	
	class Solution {
	    public String solution(String[] participant, String[] completion) {
	        
	    	String answer = "";
	    	
	    	Map<String, Integer> partMap = new HashMap();
	    	
	    	for(String name : participant) {
	    		if(!partMap.containsKey(name)) {
	    			partMap.put(name, 1);
	    		}else {
	    			partMap.put(name, partMap.get(name)+1);
	    		}
	    	}
	    	
	    	for(String name : completion) {
	    		int dupNameCnt = partMap.get(name); 
	    		if(dupNameCnt==1) {
	    			partMap.remove(name);
	    		}else {
	    			partMap.put(name, dupNameCnt-1);
	    		}
	    	}
	        
	    	answer =partMap.keySet().iterator().next();
	    	
	        return answer;
	    }
	}
}
