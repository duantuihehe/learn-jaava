package com.wcf.threah.main;

import com.wcf.threah.WaitTest;

public class WaitDemo {
    public static void main(String[] args) throws Exception {
        WaitTest t1 = new WaitTest();
        t1.setName("a");
//        WaitTest t2 = new WaitTest();
//        t2.setName("b");
        t1.start();
        Thread.sleep(10000);
//        t2.start();
//        Thread.sleep(1000);
        t1.test_notify();
        t1.wait();
    }
}
