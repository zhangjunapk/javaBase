package sync;

/**
 * @BelongsProject: javabase
 * @BelongsPackage: sync
 * @Author: ZhangJun
 * @CreateTime: 2019-07-08 17:10
 * @Description: 静态方法的sync
 */
public class UtilStaticMethod {
    private static int num;
    public static synchronized void syncMethod(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num++;
        System.out.println(num+"  syncMethod,休眠5秒后");
    }

    public static void syncClass(){
        synchronized (UtilStaticMethod.class){
            num++;
            System.out.println(num+" syncClass");
        }
    }
}
