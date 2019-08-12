package producerandconsumer.method2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 〈一句话功能简述〉:
 * 〈用阻塞队列实现的盒子〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/12  15:28
 */
public class QueueBox {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue<Apple>(5);

        new Thread(new Producer(queue),"生产者1").start();
        new Thread(new Producer(queue),"生产者2").start();
        new Thread(new Producer(queue),"生产者3").start();
        new Thread(new Consumer(queue),"消费者1").start();
        new Thread(new Consumer(queue),"消费者2").start();
        new Thread(new Consumer(queue),"消费者3").start();
        new Thread(new Consumer(queue),"消费者4").start();
    }
}
