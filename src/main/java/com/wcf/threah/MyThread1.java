package com.wcf.threah;

/**
 * 创建多线程的方式
 * 继承Thread
 */
public class MyThread1 extends Thread {
public  static  Object obj = new Object();
    @Override
    public void run() {
        System.out.println(currentThread().getName()+"：通过继承Thread 类创建多线程！！！");
//        test_sleep();
//        test_wait();
    }

    //sleep
    public void test_sleep(){
        synchronized (obj){
            try {
                System.out.println(currentThread().getName()+"拿到了锁，准备sleep");
                sleep(1000*20);
                System.out.println(currentThread().getName()+"slepp 结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void test_wait(){
        synchronized (obj){
            try {
                System.out.println(currentThread().getName()+"拿到了锁，准备wait");
                if(currentThread().getName().equals("Thread-0")){
                    System.out.println(currentThread().getName()+"拿到了锁，wait");
                    wait(100000000);
                    System.out.println(currentThread().getName()+"wait结束");
                }
                System.out.println(currentThread().getName()+"非wait结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
