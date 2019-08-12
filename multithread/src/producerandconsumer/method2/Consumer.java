package producerandconsumer.method2;

import java.util.concurrent.BlockingQueue;

/**
 * 〈一句话功能简述〉:
 * 〈消费者〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/12  15:35
 */
public class Consumer implements Runnable {

    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + "消费掉苹果:\t"+queue.take().toString());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
