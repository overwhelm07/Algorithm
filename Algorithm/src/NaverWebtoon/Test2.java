package NaverWebtoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {
	public static void main(String[] args) {
		class Solution {
			
			final String ISSAME_IDX_OVER = "IDX_OVER";
			int beforeI = -1;
			private String isSame(String s, int startIdx, int len) {
		    	
		    	StringBuffer sb = new StringBuffer();
	    		int firstRightIdx = s.length()-startIdx-len;
	    		
		    	for(int i=startIdx, count = 0; i<s.length() && count<len; ++i, ++count) {
		    		
		    		int leftIdx = i;
		    		int rightIdx = s.length()-startIdx-len+count;
		    		
		    		if(leftIdx>=rightIdx) {
		    			return ISSAME_IDX_OVER;
		    		}
		    		
		    		//System.out.println(leftIdx + ", " + rightIdx);
		    		
		    		if(s.charAt(leftIdx) != s.charAt(rightIdx)) {
		    			return null;
		    		}
		    		sb.append(s.charAt(leftIdx));
		    	}
		    	
		    	beforeI=firstRightIdx;
		    	
		    	return sb.toString();
		    	
		    }
			
		    public String[] solution(String s) {
		    	
		        String[] answer = null;
		        
		        
		        //condition: 1<=i<=(n+1)/2, s(i)=s(n-i+1)
		        //n=6, s1=s6 s2=s5 s3=s4
		        System.out.println("s: "+s +  " len: " + s.length());
		        
		        boolean chk = false;
		        int len = 1;
		        String midStr = "";
		        List<String> tempAns = new ArrayList<String>();

		        for(int i=0; i<s.length()&&!chk; i+=len) {
		        	
		        	for(len = 1; len<s.length(); ++len) {
		        		String subString = isSame(s, i, len);
		        		if(subString!=null && subString.length()!=0) {
		        			System.out.println("i:" + i + " len:" + len + " subString: " + subString);
		        			if(ISSAME_IDX_OVER.equals(subString)) {
		        				//answer = tempAns.stream().toArray(String[]::new);
		        				chk = true;
		        				if(i<beforeI) {
		        					midStr = s.substring(i, i+len);
			        				System.out.println(midStr);
			        				
			        				System.out.println("beforeI: " + beforeI);
		        				}
		        			}else {
		        				tempAns.add(subString);
		        			}
		        			break;
		        		}
		        	}
	        	}
		        
		        int x = tempAns.size()-1;
		        if(midStr!=null && midStr.length()!=0) {
		        	tempAns.add(midStr);
		        }
		        for(; x>=0; x--) {
		        	tempAns.add(tempAns.get(x));
		        }
		        
		        if(tempAns.size()==0) {
		        	tempAns.add(s);
		        }
		        answer = tempAns.stream().toArray(String[]::new);
		        
		        return answer;
		    }
		    
		}
		
		Solution sol = new Solution();
		
//		System.out.println(Arrays.toString(sol.solution("abcdefaabaabcdef")));
		System.out.println(Arrays.toString(sol.solution("aaaaabaaaaabb")));
//		System.out.println(Arrays.toString(sol.solution("abcxyasdfasdfxyabc")));
		
		
//		System.out.println(Arrays.toString(sol.solution("abcxyqwertyxyabc")));
		
	}
}
