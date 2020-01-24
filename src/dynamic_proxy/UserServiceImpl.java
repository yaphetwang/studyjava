package dynamic_proxy;

/**
 * @author wb-wyf372433
 * @date 2019/7/1 10:37
 * @description
 */
public class UserServiceImpl implements UserService {
    @Override
    public void query() {
        System.out.println("查询用户信息");
    }
}
