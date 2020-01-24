package sometests.classloader;

/**
 * @author wyf
 * @date 2019/10/2 10:36
 * @description
 */
public class TestClassLoader {

    public static void main(String[] args) {

        /**
         * 第一种情况:
         * 这是因为对于静态字段，
         * 只有直接定义这个字段的类才会被初始化（执行静态代码块），
         * 因此通过其子类来引用父类中定义的静态字段，
         * 只会触发父类的初始化而不会触发子类的初始化。
         */
        System.out.println("爸爸的岁数:" + Son.factor);    //入口

        System.out.println("----------------------------");

        /**
         * 第二种情况:
         * 首先在入口这里我们实例化一个 Son 对象，
         * 因此会触发 Son 类的初始化，
         * 而 Son 类的初始化又会带动 Father 、Grandpa 类的初始化，
         * 从而执行对应类中的静态代码块。
         * 因此会输出：「爷爷在静态代码块」、「爸爸在静态代码块」、「儿子在静态代码块」。
         * 当 Son 类完成初始化之后，
         * 便会调用 Son 类的构造方法，
         * 而 Son 类构造方法的调用同样会带动 Father、Grandpa 类构造方法的调用，
         * 最后会输出：「我是爷爷~」、「我是爸爸~」、「我是儿子~」。
         */
//        new Son();
    }
}