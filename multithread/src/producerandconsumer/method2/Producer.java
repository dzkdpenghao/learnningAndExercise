package producerandconsumer.method2;

import java.util.concurrent.BlockingQueue;

/**
 * 〈一句话功能简述〉:
 * 〈生产者〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/12  15:29
 */
public class Producer implements Runnable{
    private BlockingQueue queue;
    private static int i=0;
    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Apple apple=new Apple();
                queue.put(apple);
                System.out.println("**********"+Thread.currentThread().getName()+"生产出苹果:\t"+apple.toString());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
