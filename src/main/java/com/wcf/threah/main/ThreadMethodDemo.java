package com.wcf.threah.main;

import com.wcf.threah.*;

/**
 * 验证多线程中常用方法
 * start
 * sleep
 * currentName
 * yield
 * interrupt
 * wait
 * join
 * notify
 * notifyall
 *
 */
public class ThreadMethodDemo {
    public static void main(String[] args) {
        test_daemon();
//        YieldTest yieldTest = new YieldTest();
//        yieldTest.start();
//        test_interrupt2();
//        test_interrupt();
//        test_join();
        System.out.println("在main方法");
//        testSleepAndWait();

    }

    /**
     * 守护线程：当其他线程都执行完成之后就会退出
     * t5虽然是个死循环，但是程序还是会退出
     */
    public static void test_daemon(){
        MyThread1 t1 = new MyThread1();
        MyThread1 t3 = new MyThread1();
        MyThread1 t4 = new MyThread1();
        Thread t5 = new Thread("5"){
            @Override
            public void run() {
                while(true){
                    System.out.println(currentThread().getName());
                }
            }
        };

        MyRunnable r1 = new MyRunnable();
        Thread t2 = new Thread(r1);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.setDaemon(true);
        t5.start();

    }


    public static void test_interrupt2(){
        InterruptTest2 t1 = new InterruptTest2("a");
        InterruptTest2 t2 = new InterruptTest2("b");
        t1.start();
        try {
            Thread.sleep(1000);
            t2.start();
            int i=0;
            while(true){
                Thread.sleep(1000);
                System.out.println(t1.getName()+":i="+i+t1.getState()+":"+t1.isInterrupted());
                System.out.println(t2.getName()+":i="+i+t2.getState()+":"+t2.isInterrupted());

                if(i==10){
                    t2.interrupt();
                }
                i++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    /**
     * wait timed_wait 状态时调用会抛出异常
     * 中断需在异常处理中 中断
     */
    public static void test_interrupt( ){
        InterruptTest interruptTest = new InterruptTest();
        interruptTest.start();
        try {
            Thread.sleep(1000*10);
            System.out.println("调用interrupt");
            interruptTest.interrupt();
//            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * Thread,join 方法是阻塞当前线程，等调用join的thread 执行完成之后再往下执行
     *
     *
     * 在下面的的例子中在main方法中调用t1.join
     * 结果为等t1的逻辑全部执行完成之后再执行main方法后面的逻辑
     */
    public  static  void test_join(){
        MyThread1 t1 = new MyThread1();
        t1.start();
        //需求是 t1执行完再执行main方法的打印
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * sleep 不会释放锁
     * wait 会释放锁
     * 无论是sleep 还是wait  都会释放CPU资源
     *
     * 在MyThread1 中选择是sleep 还是 wait
     */
    public static  void testSleepAndWait(){
        MyThread1 myThread1 = new MyThread1();
        MyThread1 myThread2 = new MyThread1();

        myThread1.start();
        try {
            Thread.sleep(1);// 确保myThread1先拿到锁
            myThread2.start();//尝试去拿锁

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
