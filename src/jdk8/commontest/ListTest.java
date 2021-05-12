package jdk8.commontest;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import jdk8.Son;

import java.util.*;

/**
 * @author wangyafei
 * @date 2020/5/9 10:40 上午
 * @description jdk一些常用工具测试
 */
public class ListTest {

    public static void main(String[] args) {
        //Arrays.asList() 的几个坑
        //1。生成的list不支持增删
        //2。改动内部元素将会同步影响原数组
        String[] arrays = {"1", "2", "3"};
        List<String> list = Arrays.asList(arrays);
        list.set(0, "modify_1");
        arrays[1] = "modify_2";
        System.out.println("arrays:" + Arrays.toString(arrays));
        System.out.println("list:" + list);

        //List.subList() 的坑
        //1。生成的新集合也会与原始 List 互相影响，
        // SubList 存放原始list元素饮用，强引用原始 List
        List<String> list1 = Lists.newArrayList(arrays);
        List<String> subList = list1.subList(0, 2);
        subList.set(0, "10");
        list1.set(1, "20");
        System.out.println("list1:" + list1);
        System.out.println("subList:" + subList);

        //Collections.unmodifiableList()不可变集合的坑
        List<String> unmodifiableList = Collections.unmodifiableList(list1);
        System.out.println("unmodifiableList:" + unmodifiableList);
        //操作unmodifiableList会抛出异常UnsupportedOperationException
//        unmodifiableList.set(2, "30");
        //但是如果原始集合变了，unmodifiableList也会变
        //由于不可变集合所有修改操作都会报错，所以不可变集合不会产生任何改动，所以并不影响的原始集合。
        // 但是防过来，却不行，原始 List 随时都有可能被改动，从而影响不可变集合。
        list1.set(2, "30");
        System.out.println("unmodifiableList:" + unmodifiableList);
        //推荐使用guava方式生成不可变集合
        List<String> unmodifiableList1 = ImmutableList.copyOf(list1);
//        unmodifiableList1.add("40");
        System.out.println("unmodifiableList1:" + unmodifiableList1);
        list1.add("40");
        System.out.println("list1:" + list1);
        System.out.println("unmodifiableList1:" + unmodifiableList1);

        //foreach 增加/删除元素大坑
        List<String> list2 = Lists.newArrayList();
        list2.add("1");
        list2.add("2");
        list2.add("3");
//        list2.add("4");
        try {
            for (String str : list2) {
                if (str.equals("1")) {
                    //3个元素时，删除第二个不会报错，原因如下：
                    //最后一个不报错是因为删除的时候数组重新整理了，变成[1, 3],
                    // 这时iterator的游标指针=2，所以hasNext()不满足循环，跳出循环了，
                    // 而hasNext不会校验expectedModCount== modCount 。所以没报错。
                    // 当你给数组多加几个数据，发现报错会复现
                    list2.remove(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("list2:" + list2);
        //推荐使用JDK1.8 List.removeIf删除元素
        list2.removeIf(s -> s.equals("1"));
        System.out.println("list2:" + list2);

    }

}