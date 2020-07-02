package jdk8.stream;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import jdk8.Person;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author wangyafei
 * @date 2020/7/2 4:10 下午
 * @description stream 去重
 */
public class DuplicateTest {

    public static void main(String[] args) {
        Person person = new Person("wyf", "hz", 18L);
        Person person1 = new Person("wyf", "nj", 19L);
        Person person2 = new Person("wyf", "sz", 19L);
        Person person3 = new Person("wyf", "sz", 20L);
        List<Person> persons = Lists.newArrayList(person, person1, person2, person3);
        persons = persons.stream().filter(person8 -> person3.getAge() > 17).sorted(Comparator.comparing(Person::getAddress).reversed()).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(persons));

        //根据age去重
//        persons = persons.stream().collect(
//                Collectors.collectingAndThen(
//                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getAge))), ArrayList::new)
//        );
//        System.out.println(JSON.toJSONString(persons));

        //根据age，name去重，  age和name完全一样的过滤掉
        persons = persons.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getAge() + ";" + o.getName()))), ArrayList::new)
        );
        System.out.println(JSON.toJSONString(persons));

    }

}
