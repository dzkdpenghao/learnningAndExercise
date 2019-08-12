package producerandconsumer.method1;

/**
 * 〈一句话功能简述〉:
 * 〈消费者〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/12  15:04
 */
public class Consumer implements Runnable {
    private Box box;

    public Consumer(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (true) {
            try {
                box.consumeApple();
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
