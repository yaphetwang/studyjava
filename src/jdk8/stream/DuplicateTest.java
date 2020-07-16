package jdk8.stream;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import jdk8.Person;
import jdk8.Son;

import java.util.*;
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
        persons = persons.stream().filter(person8 -> person8.getAge() > 17).sorted(Comparator.comparing(Person::getAddress).reversed()).collect(Collectors.toList());
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
        System.out.println(persons);


        Map<String, List<Person>> itemMap = Maps.newHashMap();
        itemMap.put("persons", persons);
        String ss = JSON.toJSONString(itemMap);
        System.out.println(ss);

        itemMap = JSONObject.parseObject(ss, Map.class);
        System.out.println(itemMap.get("persons"));

        System.out.println("===============================");


        Person p = new Person("w", "addr", 20L);

        Son son = new Son("son", "addr", 2L);
        List<Son> sons = Lists.newArrayList(son);

        p.setSon(sons);
        String pp = JSON.toJSONString(p);
        System.out.println("pp:" + pp);
        Person ppp = JSONObject.parseObject(pp, Person.class);
        System.out.println(JSON.toJSONString(ppp));
        System.out.println(JSON.toJSONString(ppp.getSon()));


        System.out.println(persons.stream().min(Comparator.comparing(Person::getAge)).get().getAge());


    }

}
