/**
 * Author:   80303990
 * Date:     2020/10/15 15:22
 * Description: 演示fork/join
 */
package forkjoin;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class DemoForkJoin {

    //fork/join方式
    class Fibonacci extends RecursiveTask<Integer> {
        int n;

        public Fibonacci(int n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {
            if (n <= 1) return n;

            Fibonacci f1 = new Fibonacci(n - 1);
            f1.fork();

            Fibonacci f2 = new Fibonacci(n - 2);
            f2.fork();

            return f1.join() + f2.join();
        }
    }

    //普通递归方式
    public int plaintRecursion(int n){
        if(n<=1)return  n;
        return plaintRecursion(n-1)+ plaintRecursion(n-2);
    }

    @Test
    public void testFibWithForkjoin() throws ExecutionException, InterruptedException {
        ForkJoinPool fjp=new ForkJoinPool();
        System.out.println("CPU核心数："+Runtime.getRuntime().availableProcessors());

        long start=System.currentTimeMillis();

        Fibonacci fb=new Fibonacci(40);
        ForkJoinTask<Integer> forkJoinTask = fjp.submit(fb);
        System.out.println("结果是："+forkJoinTask.get());

        long end =System.currentTimeMillis();
        System.out.println("总共用时："+(end-start)+"毫秒");
    }

    @Test
    public  void  testFibWithRecurse(){

        long start=System.currentTimeMillis();
        System.out.println(plaintRecursion(40));
        long end=System.currentTimeMillis();

        System.out.println("总共用时："+(end-start)+"毫秒");

    }


}