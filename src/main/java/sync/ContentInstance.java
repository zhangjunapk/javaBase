package sync;

import java.util.concurrent.CountDownLatch;

/**
 * @BelongsProject: javabase
 * @BelongsPackage: sync
 * @Author: ZhangJun
 * @CreateTime: 2019-07-08 11:41
 * @Description: 测试实例级别
 */
public class ContentInstance {
    public static void main(String[] args) {
        final CountDownLatch latch=new CountDownLatch(1);
        final UtilInstance aaa = new UtilInstance();
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                public void run() {
                    try {
                        latch.await();
                       aaa.ss();//测试实例级别
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                public void run() {
                    try {
                        latch.await();
                        aaa.pp();
                        //测试实例级别
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            latch.countDown();
        }
    }
}
