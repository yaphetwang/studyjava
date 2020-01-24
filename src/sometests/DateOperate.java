package sometests;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateOperate {

	public static void main(String[] args) {
		String today = "2017-01-08";  
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		Date date = null;  
		try {  
		    date = format.parse(today);  
		} catch (Exception e) {  
		    e.printStackTrace();  
		}  
		  
		Calendar calendar = Calendar.getInstance();  
//		calendar.setFirstDayOfWeek(Calendar.MONDAY);  
		calendar.setTime(date); 
		  
		System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));  
	}

}
