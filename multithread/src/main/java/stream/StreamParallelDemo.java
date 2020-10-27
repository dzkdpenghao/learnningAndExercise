/**
 * Author:   80303990
 * Date:     2020/10/15 16:51
 * Description:
 */
package stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class StreamParallelDemo {
    public static void main(String[] args) {
        System.out.println("本机核心数：" + Runtime.getRuntime().availableProcessors());

        Random r = new Random();
        List<Integer> list = new ArrayList<>(1000000);
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }

        //stream串行计算
        long preTime = getCurrentTime();
        list.stream().reduce((a, b) -> (a + b)).ifPresent(System.out::println);;
        System.out.println("串行计算耗时：" + (getCurrentTime() - preTime));

        //stream并行计算
        preTime = getCurrentTime();
        list.stream().parallel().reduce((a, b) -> a+b).ifPresent(System.out::println);
        System.out.println("并行计算耗时：" + (getCurrentTime() - preTime));
    }

    private static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    @Test
    public void testMethod() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).parallel().reduce((a, b) -> {
            System.out.println(String.format("%s: %d + %d = %d", Thread.currentThread().getName(), a, b, a + b));
            return a + b;
        }).ifPresent(System.out::println);
    }

    @Test
    public void testSize(){
        List l=new ArrayList(10);
        System.out.println(l.size());
    }

}