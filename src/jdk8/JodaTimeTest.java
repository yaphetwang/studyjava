package jdk8;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author wangyafei
 * @date 2021/4/21 下午3:01
 * @description joda-time 使用
 */
public class JodaTimeTest {

    public static void main(String[] args) {
        //增加一个月
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2021-02-02 00:00:00", dtf);
        System.out.println(dateTime.plusMonths(1).toString(dtf));

        //下个月第一天
        System.out.println(dateTime.plusMonths(1).withDayOfMonth(1).toString(dtf));


    }
}
