package sometests.io;

import java.io.*;

/**
 * @author wangyafei
 * @date 2021/11/22 下午4:46
 * @description
 */
public class TestIO {
    public static void main(String[] args) throws IOException {
        String path = "/Users/wangyafei/个人文件/个人文档/参保证明.jpg";
        String pathWrite = "/Users/wangyafei/个人文件/个人文档/参保证明1.jpg";
        InputStream is;
        is = new FileInputStream(path);
        FileOutputStream fos = null;
        fos = new FileOutputStream(pathWrite);
        int len;
        byte[] bytes = new byte[4096];
        while ((len = is.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        fos.flush();
        is.close();
        fos.close();
        System.out.println("写入完成");
    }
}
