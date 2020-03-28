package jdk8;

import java.time.*;
import java.time.format.DateTimeFormatter;

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


    }

}
