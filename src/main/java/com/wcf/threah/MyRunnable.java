package com.wcf.threah;

public class MyRunnable implements  Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName()+":通过实现 Runnable 接口创建多线程！！！");
    }
}
