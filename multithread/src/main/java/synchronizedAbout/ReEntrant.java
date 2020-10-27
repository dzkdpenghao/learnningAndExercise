package synchronizedAbout;

/**
 * 〈一句话功能简述〉:
 * 〈证明synchronized锁可重入〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/10  14:10
 */
public class ReEntrant {

    //有锁的方法之间相互调用
    static class Service {
        synchronized public void service1() {
            System.out.println("service1 run!");
            service2();
        }

        synchronized public void service2() {
            System.out.println("service2 run!");
            service3();
        }

        synchronized public void service3() {
            System.out.println("service3 run!");
        }
    }

    //自己的线程类
    static class myThread extends Thread {
        @Override
        public void run() {
            Service service = new Service();
            service.service1();
        }
    }

    public static void main(String[] args) {
        Thread thread=new myThread();
        thread.start();
    }

}
