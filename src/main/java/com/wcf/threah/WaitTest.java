package com.wcf.threah;

/**
 * 主要是想测试在wait之后重新拿到锁代码是怎么继续执行的
 * notify 方法要在有锁的前提下使用
 */
public class WaitTest extends Thread {
    @Override
    public void run() {
    synchronized (this){
        System.out.println(currentThread().getName()+"获得锁");
        try {

                System.out.println(currentThread().getName()+"wait前");
                wait();
                System.out.println(currentThread().getName()+"wait后");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        System.out.println(currentThread().getName()+"锁后");
    }
    public  synchronized void test_notify(){
        System.out.println(currentThread().getName());
        notify();
    }
}
