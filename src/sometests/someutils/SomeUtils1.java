package sometests.someutils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

/**
 * @author wangyafei
 * @date 2020/3/9 4:15 下午
 * @description 一些工具方法记录
 */
public class SomeUtils1 {
    public static void main(String[] args) {

        int a = 23;
        int b = 89;
        DecimalFormat df = new DecimalFormat(".##");
        String dis = df.format((double) a / b);
        System.out.println((int) (Double.valueOf(dis) * 100));


        //这里的数后面加“D”是表明它是Double类型，否则相除的话取整，无法正常使用
        double percent = (double) a / b;
        //输出一下，确认你的小数无误
        System.out.println("小数：" + percent);
        //获取格式化对象
        NumberFormat nt = NumberFormat.getPercentInstance();
        //设置百分数精确度2即保留两位小数
        nt.setMinimumFractionDigits(0);
        //最后格式化并输出
        System.out.println("百分数：" + nt.format(percent));

    }

    static Long getDiffDays(Date date1, Date date2) {
        //默认date2时间在后
        long betweenDays = (date2.getTime() - date1.getTime()) / (1000L * 3600L * 24L);
        return betweenDays;
    }
}
