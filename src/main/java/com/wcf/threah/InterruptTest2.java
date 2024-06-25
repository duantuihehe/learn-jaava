package com.wcf.threah;

public class InterruptTest extends Thread {
    @Override
    public void run() {
        int i =0;
        while(!interrupted()){
            System.out.println(i++);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(currentThread().isInterrupted());
                e.printStackTrace();
                currentThread().interrupt();
            }
        }
    }
}
