package sync;

import java.util.concurrent.CountDownLatch;

/**
 * @BelongsProject: javabase
 * @BelongsPackage: sync
 * @Author: ZhangJun
 * @CreateTime: 2019-07-08 17:11
 * @Description: 静态方法的测试
 */
public class ContentStaticMethod {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch=new CountDownLatch(1);
        for(int i=0;i<1000;i++){
            new Thread(new Runnable() {
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    UtilStaticMethod.syncMethod();
                }
            }).start();
            new Thread(new Runnable() {
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    UtilStaticMethod.syncClass();
                }
            }).start();
        }
        countDownLatch.countDown();
    }
}
