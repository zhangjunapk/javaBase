package sync;

/**
 * @BelongsProject: javabase
 * @BelongsPackage: sync
 * @Author: ZhangJun
 * @CreateTime: 2019-07-08 11:41
 * @Description: 实例级别
 */
public class UtilInstance {
    private int num;

    public  synchronized void pp() {//这是实例级别的
        try {
            Thread.sleep(5000);
            System.out.println("休眠五秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num++;
        System.out.println("pp " + num);
    }

    public  synchronized void ss() {//这是实例级别的
        num++;
        System.out.println("ss -->" + num);
    }
}
