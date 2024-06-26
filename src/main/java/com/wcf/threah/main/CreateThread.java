package com.wcf.threah.main;

import com.wcf.threah.MyCallable;
import com.wcf.threah.MyRunnable;
import com.wcf.threah.MyThread1;

import java.util.concurrent.FutureTask;

/**
 * 创建多线程的四种方式
 * 1：继承Thread
 * 2: 实现 Runnable
 * 3: 实现 Callable
 * 4： 通过线程池 //后面补充
 */
public class CreateThread {
    public static void main(String[] args) throws  Exception{
        // 创建多线程的第一种方式
        MyThread1 myThread1 = new MyThread1();
//        myThread1.start();
        myThread1.run();//这种方式只是简单的方法调用，并不会新建线程
        //创建多线程的第二种
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        //第三种方式 有返回值
        FutureTask<String> callableFutureTask = new FutureTask<String>(new MyCallable());
        Thread thread1 = new Thread(callableFutureTask);
        thread1.start();
        System.out.println(callableFutureTask.get());// 会阻塞

        System.out.println(Thread.currentThread().getName()+":在main主类");


    }
}
