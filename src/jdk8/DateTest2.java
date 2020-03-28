package jdk8;

import com.google.common.collect.Lists;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangyafei
 * @date 2020/2/28 10:04 下午
 * @description
 */
public class DateTest2 {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date endDate = new Date();
        System.out.println(sdf.format(endDate));
        Calendar date = Calendar.getInstance();
        date.setTime(endDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) - 7);
        Date startDate = date.getTime();
        System.out.println(sdf.format(startDate));


        Calendar date1 = Calendar.getInstance();
        date.setTime(new Date());
        date.set(Calendar.DATE, date.get(Calendar.DATE) + 30);
        System.out.println(sdf.format(date.getTime()));


        List<Date> dates = Lists.newArrayList();
        dates.add(sdf.parse("2020-02-20 12:23:23"));
        dates.add(sdf.parse("2020-02-22 12:23:23"));
        dates.add(sdf.parse("2020-02-19 12:23:23"));

        dates = dates.stream().sorted((date0, date2) -> date2.compareTo(date0)).collect(Collectors.toList());
        System.out.println(dates);

        dates = dates.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println(dates);
    }
}