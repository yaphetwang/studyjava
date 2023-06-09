package sometests;

import com.google.common.collect.Lists;
import org.joda.time.LocalDateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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


        List<String> list = Lists.newArrayList("1", "2", "3", "4");
        System.out.println(String.join("-", list));

        System.out.println("Error validating access token: ffdfdfd".contains("Error validating access token"));

        System.out.println(LocalDateTime.now());
        List<Long> uidList = Lists.newArrayList(1L, 2L, 3L);
        uidList = uidList.stream().filter(uid -> !uid.equals(1L)).collect(Collectors.toList());
        System.out.println(uidList);
    }

}
