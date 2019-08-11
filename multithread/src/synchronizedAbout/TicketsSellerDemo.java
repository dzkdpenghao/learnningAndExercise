package synchronizedAbout;

/**
 * 〈一句话功能简述〉:
 * 〈模拟多窗口售票〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/10  17:11
 */
public class TicketsSellerDemo {
    private static int ticketCount = 50;

    public static void main(String[] args) {
        new TicketsSeller("售票员1").start();
        new TicketsSeller("售票员2").start();
        new TicketsSeller("售票员3").start();
        new TicketsSeller("售票员4").start();
    }


    static class TicketsSeller extends Thread {
        public TicketsSeller() {
        }

        public TicketsSeller(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (ticketCount>0) {
                synchronized (TicketsSeller.class) {
                    if(ticketCount>0)
                    System.out.println(Thread.currentThread().getName() + ":第" + (ticketCount--) + "张票");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
