package jdk8;

import org.joda.time.format.DateTimeFormat;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

/**
 * @author wyf
 * @date 2020/1/31 9:24 下午
 * @description 测试 jdk8 time 包下的 时间API
 */
public class DateTest {

    public static void main(String[] args) {
        // LocalDate 类  LocaleDate只持有ISO-8601格式且无时区信息的日期部分
        LocalDate date = LocalDate.now();
        System.out.println(date.toString());

        date = date.plusDays(1); // 增加一天
        System.out.println(date);

        date = date.plusMonths(1); // 增加一月
        System.out.println(date);

        date = date.minusDays(1); // 减少一天
        System.out.println(date);

        date = date.minusMonths(1); // 减少一月
        System.out.println(date);

        //LocalTime类， LocaleTime只持有ISO-8601格式且无时区信息的时间部分
        LocalTime time = LocalTime.now();
        System.out.println(time);
        time = time.plusMinutes(5); //增加五分钟
        System.out.println(time);

        //LocalDateTime类，持有的是ISO-8601格式无时区信息的日期与时间
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime.plusDays(2L));
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        // Clock类，它通过指定一个时区，
        // 然后就可以获取到当前的时刻，日期与时间
        // Clock可以替换System.currentTimeMillis()与 TimeZone.getDefault()
        Clock utc = Clock.systemUTC();  //世界统一时间
        Clock shanghai = Clock.system(ZoneId.of("Asia/Shanghai")); // 上海时间
        System.out.println(LocalDateTime.now(utc));
        System.out.println(LocalDateTime.now(shanghai));

        //Duration类，Duration使计算两个日期间的不同 变的十分简单
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime from = LocalDateTime.parse("2020-01-30 18:50:50", formatter);
        LocalDateTime to = LocalDateTime.parse("2020-01-31 21:50:50", formatter);
        Duration duration = Duration.between(from, to);
        System.out.println("Duration in Millis: " + duration.toMillis()); //毫秒数
        System.out.println("Duration in days: " + duration.toDays());
        System.out.println("Duration in hours: " + duration.toHours());
        System.out.println("Duration in Minutes: " + duration.toMinutes());
        System.out.println("Duration: " + duration.toString());


        LocalDateTime now = LocalDateTime.now();
        System.out.println(Date.from(now.plusDays(2L).atZone(ZoneId.systemDefault()).toInstant()));
        System.out.println(now.plusDays(2L).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));


        System.out.println(Optional.ofNullable(0).orElse(0).equals(1));


        //计算一个时间点几个月之后的那天所在月的第一天
        Instant instant = new Date().toInstant();
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        Date fourMonthsAfterDate = Date.from(localDateTime.plusMonths(4).atZone(ZoneId.systemDefault()).toInstant());
        Calendar c = Calendar.getInstance();
        c.setTime(fourMonthsAfterDate);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        Date deadlineDate = c.getTime();
        System.out.println(deadlineDate);

        //使用joda-time LocalDateTime转date
        org.joda.time.format.DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");
        Date date1 = org.joda.time.LocalDateTime.parse("2021-03-23", dtf).toDate();
        System.out.println(date1);

    }

    //LocalDate -> Date
    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    //LocalDateTime -> Date
    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    //Date -> LocalDate
    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    //Date -> LocalDateTime
    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

}
