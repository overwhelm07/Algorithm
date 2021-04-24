package Kakao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class 추석트래픽_1차 {

	public static void main(String[] args) {
		String[] intputParm = new String[]{
				"2016-09-15 01:00:04.002 2.0s",
				"2016-09-15 01:00:07.000 2s"};
		//최대 처리 개수
		solution(intputParm);
	}

	public static int solution(String[] lines) {
		final String dateFormat = "yyyy-MM-dd hh:mm:ss.SSS";
        int answer = 0;
        
        for(String line : lines) {
        	String[] split = line.split(" ");
        	
        	String endDate = split[0] + " " + split[1];
        	String executeTime = split[2].substring(0, split[2].length()-1);
        	
        	System.out.println(endDate + ", " + executeTime);
        	Calendar cal = Calendar.getInstance();
        	DateFormat df = new SimpleDateFormat(dateFormat);
            try {
            	cal.setTime(df.parse(endDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
            
        	String startDate;
        }
        
        return answer;
    }
	
	public long getMilisByString(String s) {
		return 0;
	}
}
