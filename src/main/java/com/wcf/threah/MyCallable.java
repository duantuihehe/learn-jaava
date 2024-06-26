package com.wcf.threah;

import java.util.concurrent.Callable;

/**
 * 多线程实现第三种方式
 * callable  并且有返回值
 */
public class MyCallable implements Callable<String> {
    public String call() {
        System.out.println(Thread.currentThread().getName()+":通过 Callable 方式实现多线程");
        return "Callable  方式是有返回值的";
    }
}
