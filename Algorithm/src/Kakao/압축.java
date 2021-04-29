package Kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 압축 {
	
	public static void main(String[] args) {
		class Solution {
			
			Map<String, Integer> map = new HashMap<>();
			int lastValueNum;
			
		    public int[] solution(String msg) {
		        List <Integer> answer = new ArrayList<Integer>();
		        
		        initSetting();
		        
		        StringBuilder str = new StringBuilder("");
		        
		        for(int i=0; i<msg.length(); ++i) {
		        	char c = msg.charAt(i);
		        	str.append(c);
		        	System.out.println(i + " " + str.toString());
		        	
		        	if(i==msg.length()-1) {
		        		answer.add(map.get(String.valueOf(c)));
		        		break;
		        	}
		        	
		        	//다음 글자 포함한 문자열이 사전에 있는 경우
		        	int t = i+1;
		        	while(t < msg.length()) {
		        		String newStr = str.toString()+msg.charAt(t);
		        		if(map.containsKey(newStr)) {
		        			str.append(msg.charAt(t));
		        			++i;
		        			if(t==msg.length()-1) {
		        				answer.add(map.get(str.toString()));
		        			}
		        		}else {
		        			answer.add(map.get(str.toString()));
		        			map.put(newStr, ++lastValueNum);
		        			
		        			//System.out.println("add " + newStr + " " + lastValueNum);
		        			
		        			str = new StringBuilder("");
		        			break;
		        		}
		        		t++;
		        	}
		        }
		        
		        return answer.stream().mapToInt(Integer :: intValue).toArray();
		    }
		    
		    public void initSetting() {
		    	int value = 1;
		    	for(char key='A'; key<='Z'; ++key) {
		    		map.put(String.valueOf(key), value);
//		    		System.out.println("put " + key + " " + value);
		    		lastValueNum = value;
		    		value++;
		    	}
		    }
		}
		Solution sol = new Solution();
		
		String str = "ABABABABABABABAB";
//		String str = "KAKAO";
		int[] solution = sol.solution(str);
		
		for(int i : solution) {
			System.out.print(i + " ");
		}
	}

}
