package com.wcf.threah.demo;

/**
 * 模拟死锁的场景
 */
public class DeadlockDemo {
    public static Object lock1= new Object();
    public static Object lock2= new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName()+"in lock1");
                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName()+"in lock2");
                    lock2.notifyAll();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName()+"in lock2");
                long time = System.currentTimeMillis();
                int i =0;
                while (i++<10){
                    try {
                        System.out.println("----->");
                        lock2.wait(1000);
                        System.out.println("<----------");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName()+"in lock1");
                }
            }
        });
        t1.setName("A");
        t2.setName("B");
        t1.start();
        t2.start();
    }
}
