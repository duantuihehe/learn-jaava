package com.wcf.threah;

/**
 * 测试 blocked 状态时 调用interrupt
 *
 * blocked 状态时调用interrupt 只是修改了标志位 但不会真正的终止线程，
 * 线程的状态也不会变化
 */
public class InterruptTest2 extends Thread {
    public  static  Object obj = new Object();

    public InterruptTest2(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (obj){
            System.out.println(currentThread().getName());
            try {
                if(currentThread().getName().matches("a")){
                    sleep(1000*20);//使的另外一个线程进入blocked状态
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
