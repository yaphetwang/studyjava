package jdk8;

/**
 * @author wangyafei
 * @date 2021/3/30 下午3:52
 * @description
 */
public enum TestEnum {

    ADD,
    UPDATE,
    DELETE;

    private String name = name();

    TestEnum() {
    }

    public String getName() {
        return this.name;
    }

    public static TestEnum getByName(String name) {
        return TestEnum.valueOf(name);
    }
}
