package thread;

import java.util.concurrent.Callable;

/**
 * @author wyf
 * @date 2019/7/10 14:59
 * @description
 */
public class Thread3 implements Callable {

    @Override
    public Object call() throws Exception {
        return "Thread3 run";
    }
}
