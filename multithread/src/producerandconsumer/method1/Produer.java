package producerandconsumer.method1;

/**
 * 〈一句话功能简述〉:
 * 〈生产者〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/12  15:01
 */
public class Produer implements Runnable {
    private Box box;

    public Produer(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (true) {
            try {
                box.produceApple();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
