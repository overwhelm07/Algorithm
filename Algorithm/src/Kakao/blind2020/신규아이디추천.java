package Kakao.blind2020;

public class 신규아이디추천 {

	public static void main(String[] args) {
		class Solution {
		    public String solution(String str) {
		        String answer = "";
		        
		        //step1
		        str = str.toLowerCase();
		        //System.out.println(inputStr);
		        //step2
		        StringBuffer strBuffer = new StringBuffer("");
		        for(int i=0; i<str.length(); ++i) {
		        	char c = str.charAt(i);
		        	if((c>='a'&&c<='z')
		        			||(c>='0'&&c<='9')||c=='-'||c=='_'||c=='.') {
		        		strBuffer.append(c);
		        	}
		        }
		        //step 3, 4
		        for(int i=0; i<strBuffer.length(); ++i) {
		        	char c = strBuffer.charAt(i);
		        	
		        	while(c=='.'&&i+1<strBuffer.length()&&strBuffer.charAt(i+1)=='.') {
		        		strBuffer.deleteCharAt(i+1);
		        	}
		        	
		        	if(i==0&&strBuffer.charAt(0) == '.') {
		        		strBuffer.deleteCharAt(0);
		        	}else if(i==strBuffer.length()-1 && strBuffer.charAt(strBuffer.length()-1)=='.') {
		        		strBuffer.deleteCharAt(strBuffer.length()-1);
		        	}
		        }
		        System.out.println("step3, 4: " + strBuffer.toString());
		        //step5
		        if(strBuffer.length()==0) {
		        	strBuffer.append("a");
		        }else if(strBuffer.length()>=16) {
		        	strBuffer = new StringBuffer(strBuffer.substring(0, 15));
		        	while(strBuffer.charAt(strBuffer.length()-1)=='.') {
		        		strBuffer = new StringBuffer(strBuffer.substring(0, strBuffer.length()-1));
		        	}
		        }
		        
		        //step7
		        if(strBuffer.length()<=2) {
		        	while(strBuffer.length()<3) {
		        		strBuffer.append(strBuffer.charAt(strBuffer.length()-1));
		        	}
		        }
		        answer = strBuffer.toString();
		        return answer;
		    }
		}
		
		Solution sol = new Solution();
		System.out.println(sol.solution("...!@BaT#*..y.abcdefghijklm"));
		System.out.println(sol.solution("..."));
		System.out.println(sol.solution("123_.def"));
		System.out.println(sol.solution("abcdefghijklmn.p"));
		
		

	}

}
