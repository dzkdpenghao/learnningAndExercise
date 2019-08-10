package synchronizedAbout;

/**
 * 〈一句话功能简述〉:
 * 〈死锁演示〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/10  14:31
 */
public class DeadLock {

    private static Object leftChopticks=new Object();
    private static Object rightChopticks=new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (leftChopticks) {
                    System.out.println(Thread.currentThread().getName() + "拿到左筷子，等待右筷子！");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //同步代码嵌套，拿到一把锁还在等另一把锁
                    synchronized (rightChopticks) {
                        System.out.println(Thread.currentThread().getName() + "拿到右筷子，开吃！");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (rightChopticks){
                    System.out.println(Thread.currentThread().getName()+"拿到右筷子，等待左筷子！");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (leftChopticks){
                        System.out.println(Thread.currentThread().getName()+"拿到左筷子，开吃！");
                    }
                }
            }
        }).start();
    }

}
