package com.wcf.threah.demo;

/**
 * 2. **线程同步与共享资源**
 * 	 编写一个多线程程序，模拟多个线程同时对一个共享的整数变量进行累加操作，确保每次操作都是原子的，并且不会出现并发问题。
 */
public class CountDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(new CountingTask(counter));
        Thread t2 = new Thread(new CountingTask(counter));
        Thread t3 = new Thread(new CountingTask(counter));
        Thread t4 = new Thread(new CountingTask(counter));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t2.join();
            t1.join();
            t4.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getCount());


    }
}
 class Counter{
    private  int count =0;
    public  synchronized    void increment(){
        count++;
    }
    public int getCount(){
        return count;
    }
}

class CountingTask implements Runnable{
    private Counter counter;

    public CountingTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            counter.increment();
        }
    }
}
