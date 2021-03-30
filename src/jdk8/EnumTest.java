package jdk8;

/**
 * @author wangyafei
 * @date 2021/3/30 下午3:58
 * @description switch case 语句使用 枚举 测试
 */
public class EnumTest {
    public static void main(String[] args) {

        String s = "ADD";

        switch (TestEnum.getByName(s)) {
            case ADD:
                System.out.println("匹配到ADD");
                break;
            case UPDATE:
                System.out.println("匹配到UPDATE");
                break;
            case DELETE:
                System.out.println("匹配到DELETE");
                break;

        }

    }

}
