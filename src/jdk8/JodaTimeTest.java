package jdk8;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

/**
 * @author wangyafei
 * @date 2021/4/21 下午3:01
 * @description joda-time 使用
 */
public class JodaTimeTest {

    public static void main(String[] args) {
        //增加一个月
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse("2021-02-02 00:00:00", dtf);
        System.out.println(localDateTime.plusMonths(1).toString(dtf));

        //下个月第一天
        System.out.println(localDateTime.plusMonths(1).withDayOfMonth(1).toString(dtf));

        System.out.println(LocalDateTime.now().withDayOfMonth(1).toString(dtf));

        /**
         * LocalDate  不包含时分秒
         */
        System.out.println("=======LocalDate=======");
        DateTimeFormatter dtf1 = DateTimeFormat.forPattern("yyyy-MM-dd");
        LocalDate localDate = new LocalDate(new Date());
        System.out.println(localDate.toString(dtf1));
        System.out.println(localDate.toDate());
        System.out.println(LocalDate.now().toString(dtf1));
        System.out.println(LocalDate.now().toDate());
        System.out.println(LocalDate.parse("20210401").toDate());

        //给定日期零点
        System.out.println("===当天日期零点===");
        System.out.println(new LocalDate(LocalDate.parse("2021-04-01").toDate()).toDateTimeAtStartOfDay().toDate());
        System.out.println(new LocalDate(LocalDate.parse("2021-04-01").toDate()).plusDays(1).toDateTimeAtStartOfDay().toDate());

        //传值为null的日期对象，处理成当前日期
        Date date = null;
        System.out.println(new LocalDate(date).toDate());



        /**
         * DateTime    包含时分秒
         */
        System.out.println("=======DateTime=======");
        DateTime dateTime = new DateTime(new Date());
        System.out.println(dateTime.toString(dtf));


        String p = "100.0";
        System.out.println(p.substring(0, p.indexOf(".")));

        System.out.println(getNo("NO.000010"));

        String s = "20210130";
        String ss = s.substring(0, 4) + "-" + s.substring(4, 6) + "-" + s.substring(6, 8);
        System.out.println(ss);
        System.out.println(LocalDate.parse(ss).toDate());
        System.out.println(new Date());

        //大于10000000时
        Double prince = 999999999999D;
        Double prince1 = 111.00000000000001D;
        Double prince2 = 111.6D;
        System.out.println(prince1 + "");
        System.out.println(new BigDecimal(prince1.toString()).toString());
        System.out.println(new BigDecimal(prince.toString()).toString());
        System.out.println(new BigDecimal(prince2.toString()).setScale(0, RoundingMode.DOWN).toString());

    }

    public static String getNo(String certificateNo) {
        certificateNo = certificateNo.substring(3);
        String no = "";
        for (int index = 0; index <= certificateNo.length() - 1; index++) {
            //将字符串拆开成单个的字符
            String w = certificateNo.substring(index, index + 1);
            if (!w.equals("0")) {
                no = certificateNo.substring(index);
                break;
            }
        }
        return no;
    }
}
