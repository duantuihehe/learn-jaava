package com.wcf.threah.demo;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 3. **生产者-消费者问题**
 * 	使用线程和合适的同步机制实现一个简单的生产者-消费者模型，其中有一个生产者线程和一个消费者线程共享一个有限大小的缓冲区。
 */
public class ProductConsumer {
    public static void main(String[] args) {
        QuenKafka quenKafka = new QuenKafka(new ArrayBlockingQueue(10));
        Thread send = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                quenKafka.send(i);
            }

        });
        Thread take = new Thread(() -> {
            while (true) {
                quenKafka.take();
            }
        });
        send.start();
        take.start();
        try {
            send.join();
            take.join();
//            Thread.sleep(1000000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
class QuenKafka {
    private Queue buffer;

    public QuenKafka(Queue buffer) {
        this.buffer = buffer;
    }

    public synchronized void send(int data){
        if (buffer.size()<10){
            System.out.println(Thread.currentThread().getName()+"send:"+data);
            buffer.add(data);
        }else {
            try {
                Thread.currentThread().sleep(1000*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public  synchronized void take(){

        if (buffer.size()!=0){
            Object poll = buffer.poll();
//            try {
//                Thread.currentThread().sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName()+"take:"+poll.toString());
        }

    }
}
