package com.wcf.threah.demo;

/**
 * 1. **基本多线程操作**
 * 编写一个Java程序，创建两个线程并使它们同时运行，每个线程简单地打印出一些数字。
 */
public class PrintNum {
    public static void main(String[] args) {
        Thread t1 = new Thread("线程1") {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(currentThread().getName() + "打印：" + i);

                }
            }
        };
        Runnable r1 = new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "打印：" + (char)i*30);

                }
            }
        };
        Thread t2 = new Thread(r1, "线程2");
        t1.start();
        t2.start();
    }
}
