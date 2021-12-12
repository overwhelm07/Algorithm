package Kakao.blind2020;

public class 문자열압축 {
	
	public static void main(String[] args) {
		class Solution {
			StringBuffer answer = new StringBuffer();
			
		    public int solution(String inputStr) {
		        
		        int startIdx = 0;
		        int midIdx = inputStr.length()/2;
		        
		        while(startIdx<midIdx&&midIdx<inputStr.length()-1) {
		        	//String str = inputStr.substring(startIdx, inputStr.length());
		        	
		        	String s1 = inputStr.substring(startIdx, midIdx);
			        String s2 = inputStr.substring(midIdx, inputStr.length());
			        System.out.println(s1 + ", " + s2);
			        
			        //valid isSame
			       int code = getValidCode(s1, s2);
			       
			       if(code == -1) {
			    	   if(s1.length()==1) {
				        	answer.append(s1);
				        	startIdx++;
				        	midIdx++;
				        }else {
				        	midIdx--; 
				        }
			       }else {
			    	  answer.append(code);
			    	  answer.append(s1);
			    	  startIdx = startIdx + s1.length()*code;
			    	  midIdx = (startIdx + inputStr.length())/2;
			    	  System.err.println("rearrage startIdx: " + startIdx + ", midIdx: " + midIdx);
			       }
		        }
		        
		        System.out.println("ans: " +answer.toString() +", "+ answer.length());
		        return answer.length();
		    }
		    
		    public int getValidCode(String s1, String s2) {
		    	
		    	int ret = 1;
		    	int startIdx = 0, endIdx = s1.length();
		    	while(endIdx<=s2.length()&&s1.equals(s2.substring(startIdx, endIdx))) {
		    		ret++;
		    		startIdx=endIdx;
		    		endIdx+=s1.length();
		    	}
		    	
		    	if(ret==1) {
		    		return -1;
		    	}else {
		    		return ret;
		    	}
		    }
		    
		}
		
		Solution s = new Solution();
//		s.solution("aabbaccc");
		s.solution("abcabcdede");
//		s.solution("ababb");
	}
}
