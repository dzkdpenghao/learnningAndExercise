/**
 * Author:   80303990
 * Date:     2020/9/29 17:18
 * Description: blocked测试
 */
package status;

public class StatusTestClass {
    public static void main(String[] args) throws InterruptedException {
        //test1();
        //test2();
        test3();
    }

    /**
     * TIMED_WAITING与RUNNABLE状态的转换
     * @throws InterruptedException
     */
    private static void test3() throws InterruptedException {
        Thread a=new Thread(()->synMethod(),"a");
        Thread b=new Thread(()->synMethod(),"b");
        a.start();
        //main线程被阻塞，a线程执行1秒，小于run方法中的sleep时间，所以是timed_waiting；b不一定，可能是runnable也可能blocked
        a.join(1000);
        b.start();

        System.out.println("status of thread a: "+a.getState());
        System.out.println("status of thread b: "+b.getState());
    }

    /**
     *  WAITING状态与RUNNABLE状态的转换
     * @throws InterruptedException
     */
    private static void test2() throws InterruptedException {
        Thread a=new Thread(()->synMethod(),"a");
        Thread b=new Thread(()->synMethod(),"b");
        a.start();
        //main线程被阻塞，其状态就是waiting，而a线程打印出terminal；b不一定，可能是runnable也可能timed_waiting
        a.join();
        b.start();

        System.out.println("status of thread a: "+a.getState());
        System.out.println("status of thread b: "+b.getState());
    }

    /**
     *  BLOCKED与RUNNABLE状态的转换
     * @throws InterruptedException
     */
    private static void test1() throws InterruptedException {
        Thread a=new Thread(()->synMethod(),"a");
        Thread b=new Thread(()->synMethod(),"b");
        a.start();
        b.start();

        //要让main线程sleep，否则都会打印为runnable：因为run()方法执行需要时间，在那之前线程状态都是runnable
        Thread.sleep(1000);

        System.out.println("status of thread a: "+a.getState());
        System.out.println("status of thread b: "+b.getState());
    }

    /**
     * 争夺锁同步方法
     */
    private static synchronized void synMethod() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}