package com.wcf.threah.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 5. **Callable和Future**
 * 	编写一个使用`Callable`和`Future`接口的多线程程序，计算斐波那契数列的第N项，其中N由用户输入
 * 	斐波那契数列 f(n)=f(n-1)+f(n-2)
 * 	先实现斐波那契额数列的功能
 */
public class FibonacciSequence {
    public static void main(String[] args) throws Exception{
        FutureTask<Integer> f1 = new FutureTask<>(new Fs(9));
        Thread t1 = new Thread(f1);
        t1.start();
        System.out.println(f1.get());
    }

}

/**
 * 每次都new Fs所以也不存在内存泄漏的问题
 */
class Fs implements Callable<Integer> {
    private int n;

    public Fs(int n) {
        this.n = n;
    }

    @Override
    public Integer call() {
        if(n==1||n==2){
            return 1;
        }else {
            //n>=3
            int fn_1=1;
            int fn_2=1;
            int fn=0;
            for (int i = 3; i <= n; i++) {
                    fn=fn_1+fn_2;
                    fn_2=fn_1;
                    fn_1=fn;
            }
            return fn;
        }

    }
}