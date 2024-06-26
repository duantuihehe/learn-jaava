package com.wcf.threah;

/**
 * yield 不会释放锁
 *
 */
public class YieldTest extends Thread {
    @Override
    public void run() {

        try {
            a();

            b();
            sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public synchronized void a(){
        System.out.println("a 方法拿到锁");
        int i=0;
        while (i++<20){
            System.out.println("i="+i);
            if(i==10){
                System.out.println("执行yield ");
                yield();
            }

        }
        System.out.println("退出a方法");
    }
    public synchronized void b(){
        System.out.println("b 方法拿到锁");
    }

}
