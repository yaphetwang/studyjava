package jdk8;

/**
 * @author wangyafei
 * @date 2020/7/2 4:14 下午
 * @description
 */
public class Person {

    private String name;
    private String Address;
    private Long age;

    public Person(String name, String address, Long age) {
        this.name = name;
        Address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
