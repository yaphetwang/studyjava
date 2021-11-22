package jdk8.stream;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wyf
 * @date 2020/2/2 5:39 下午
 * @description 演示 流的典型用法
 */
public class StreamTest2 {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("a", "b", "c");

        //map,它的作用就是把 input Stream的每一个元素，
        // 映射成 output Stream 的另外一个元素
        list = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(list);

        List<Long> longs = Lists.newArrayList(111L);
        List<BigInteger> bigIntegers = longs.stream().map(BigInteger::valueOf).collect(Collectors.toList());
        System.out.println(bigIntegers);


        //filter,对原始 Stream 进行某项测试，通过测试的元素被留下来生成一个新 Stream
        List<Integer> list1 = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        list1.stream().filter(a -> (a < 4)).forEach(System.out::print);


        //forEach 是终止操作，因此它执行后，Stream 的元素就被“消费”掉了，
        // 你无法对一个 Stream 进行两次 terminal 运算
        Stream stream = list.stream();
        stream.forEach(System.out::println);
//        stream.forEach(System.out::print);


        //reduce, 主要作用是把 Stream 元素组合起来。它提供一个起始值（种子），然后依照运算规则
        //（BinaryOperator），和前面 Stream 的第一个、第二个、第 n 个元素组合。
        // 从这个意义上说，字符串拼接、数值的 sum、min、max、average 都是特殊的 reduce
        Integer sum = list1.stream().reduce(0, (integer, integer2) -> {
            return integer + integer2;
        });
        System.out.println(sum);

        Integer sum1 = list1.stream().reduce(0, Integer::sum);
        Integer sum2 = list1.stream().reduce(Integer::sum).get();
        System.out.println(sum1);
        System.out.println(sum2);

        //
        String ss = "15446577379557037702";
        System.out.println(new BigInteger(ss));
        System.out.println((new BigInteger(ss)).toString());


        Double dd = 0.0;
        BigDecimal bb = new BigDecimal(dd.toString()).
                divide(new BigDecimal("100"), 4, BigDecimal.ROUND_HALF_UP);
        System.out.println(bb);

        BigDecimal bd = new BigDecimal("0.2255");
        Double d = bd.multiply(new BigDecimal("100")).doubleValue();
        System.out.println(d);

    }
}