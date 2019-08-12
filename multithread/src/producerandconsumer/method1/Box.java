package producerandconsumer.method1;

/**
 * 〈一句话功能简述〉:
 * 〈用于存放苹果的盒子〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/12  14:54
 */
public class Box {

    private int appleCount = 0;

    public synchronized void produceApple() {
        while (appleCount >= 10) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        appleCount++;
        System.out.println("************"+Thread.currentThread().getName() + ":生产出第" + appleCount + "个苹果!");
        this.notifyAll();
    }

    public synchronized void consumeApple() {
        while (appleCount <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":消费了第" + appleCount + "个苹果!");
        appleCount--;
        this.notifyAll();
    }

    public static void main(String[] args) {

        Box box=new Box();

        Thread p1=new Thread(new Produer(box),"生产者1");
        Thread p2=new Thread(new Produer(box),"生产者2");
        Thread p3=new Thread(new Produer(box),"生产者3");

        Thread c1=new Thread(new Consumer(box),"消费者1");
        Thread c2=new Thread(new Consumer(box),"消费者2");
        Thread c3=new Thread(new Consumer(box),"消费者3");
        Thread c4=new Thread(new Consumer(box),"消费者4");
        Thread c5=new Thread(new Consumer(box),"消费者5");

        p1.start();
        p2.start();
        p3.start();

        c1.start();
        c2.start();
        c3.start();
        c4.start();
//        c5.start();

    }
}
