package synchronizedAbout;

/**
 * 〈一句话功能简述〉:
 * 〈打印机类模拟多线程通信实现按顺序执行〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/12  14:08
 */
public class Printer {

    int flag = 1;

    public void print1() {
        synchronized (this) {
            while (flag != 1) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("打印机" + flag + "正在打印！");
            flag = 2;
            this.notifyAll();
        }
    }

    public void print2() {
        synchronized (this) {
            while (flag != 2) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("打印机" + flag + "正在打印！");
            flag = 3;
            this.notifyAll();
        }
    }

    public void print3() {
        synchronized (this) {
            while (flag != 3) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("打印机" + flag + "正在打印！");
            flag = 1;
            this.notifyAll();
        }
    }

//    class PrinterThread1 extends Thread {
//
//        private Printer printer;
//
//        public PrinterThread1(Printer printer) {
//            this.printer = printer;
//        }
//
//        @Override
//        public void run() {
//            printer.print1();
//        }
//    }
//
//    class PrinterThread2 extends Thread {
//
//        private Printer printer;
//
//        public PrinterThread2(Printer printer) {
//            this.printer = printer;
//        }
//
//        @Override
//        public void run() {
//            printer.print2();
//        }
//    }
//
//    class PrinterThread3 extends Thread {
//
//        private Printer printer;
//
//        public PrinterThread3(Printer printer) {
//            this.printer = printer;
//        }
//
//        @Override
//        public void run() {
//            printer.print3();
//        }
//    }

    public static void main(String[] args) {

        Printer p = new Printer();

        new Thread(() -> {
            while (true) {
                p.print1();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                p.print2();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                p.print3();
            }
        }).start();
    }
}
