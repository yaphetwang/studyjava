package jdk8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wyf
 * @date 2020/2/2 5:01 下午
 * @description 测试  jdk8中 stream API的使用
 */
public class StreamTest1 {

    public static void main(String[] args) {
        //构造流的几种常见方式
        // 1. Individual values
        Stream stream = Stream.of("a", "b", "c");
        System.out.println(stream.toArray()[0]);

        // 2. Arrays
        String[] strArr = new String[]{"d", "e", "f"};
        stream = Arrays.stream(strArr);
        System.out.println(stream.collect(Collectors.toList()));

        // 3. Collections
        List<String> list = Arrays.asList(strArr);
        stream = list.stream();
        System.out.println(stream.collect(Collectors.toCollection(ArrayList::new)));

        stream = Stream.of(strArr);
        Object str = stream.collect(Collectors.joining());
        System.out.println(str);
    }

}
