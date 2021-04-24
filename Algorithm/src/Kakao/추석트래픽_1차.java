package Kakao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 추석트래픽_1차 {
	/**
	 * 
	 * @param args
	트래픽 문제 
	사용 자료구조: 우선순위 Queue (시작/종료 시간 오름차순)
	
	Sol: 주어진 입력값에 시간을 변환하여 Queue에 모두 넣고 하나씩 순차적으로 빼면서 시작시간일 경우 해당 시점에서 진행중인 처리개수를 확인하여 해결
	 */
	
	public static void main(String[] args) {
		class Solution {
			int ans = 0;
			Queue<Type> info = new PriorityQueue<Type>(10, new Comparator<Type>() {
				@Override
				public int compare(Type o1, Type o2) {
					//sort by ascending time 
					if (o1.time > o2.time) {
						return 1;
					}else if(o1.time < o2.time) {
						return -1;
					}
					return 0;
				}
			});
			
			class Type{
				public static final char TYPE_START = 's';
				public static final char TYPE_END = 'e';
				
				public char type;
				public long time;
				
				public Type(char type, long time) {
					this.type = type;
					this.time = time;
				}
			}
			public int solution(String[] lines) {
				final String dateFormat = "yyyy-MM-dd hh:mm:ss.SSS";
		        
		        for(String line : lines) {
		        	String[] split = line.split(" ");
		        	
		        	String endDate = split[0] + " " + split[1];
		        	String executeTime = split[2].substring(0, split[2].length()-1);
		        	
		        	Calendar cal = Calendar.getInstance();
		        	DateFormat df = new SimpleDateFormat(dateFormat);
		            try {
		            	cal.setTime(df.parse(endDate));
		            	long endMilisSecond = cal.getTimeInMillis();
		            	long startMilisSecond = endMilisSecond - getMilisByString(executeTime)+1; 
		            	endMilisSecond+=1000;
		            	
		            	info.add(new Type(Type.TYPE_START, startMilisSecond));
		            	info.add(new Type(Type.TYPE_END, endMilisSecond));
		            	/**
		            	 01:00:02.003 ~ 01:00:04.002 2sec
		            	 01:00:05.001 ~ 01:00:07.000 2sec
		            	 */
		            	
					} catch (ParseException e) {
						e.printStackTrace();
					}
		        }
		        
		        int executingCount = 0;
		        
		        while(!info.isEmpty()) {
		        	Type t = info.poll();
		        	System.out.println(t.type + " " + t.time);
		        	
		        	if(t.type == Type.TYPE_START) {
		        		executingCount++;
		        	}else {
		        		if(ans < executingCount) {
		        			ans = executingCount;
		        		}
		        		executingCount--;
		        	}
		        }
		        return ans;
		    }

			public long getMilisByString(String s) {
				//case 2
				if(s.length()<=1) {
					return Long.valueOf(s)*1000;
				}
				//case 2.0
				long second = s.charAt(0)-48;
				long milisSecond = Long.valueOf(s.substring(2, s.length()));
				//System.out.println(second + " " + milisSecond);
				if(milisSecond == 0) {
					return second*1000;
				}
				return second*1000 + milisSecond; 
				
			}
		}
		
		
		String[] intputParm = new String[]{
				//"2016-09-15 23:59:59.999 0.001s"
				"2016-09-15 01:00:04.002, 2.0s"
				, "2016-09-15 01:00:07.000, 2s"
				};
		//최대 처리 개수
		Solution s = new Solution();
		
		System.out.println(s.solution(intputParm));
	}

	
}
