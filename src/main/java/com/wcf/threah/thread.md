# java 多线程相关的知识点
## 多线程的创建
1. 继承Thread
2. 实现Runnable接口
3. 实现Callable接口
4. 通过线程池(暂未学习)
## 常用方法
1. start() 进入RUNNABLE状态等待被调度
2. getCurrentThread()  获取当前线程
3. Object.wait() 属于Object的方法，配合synchronized使用否则报错java.lang.IllegalMonitorStateException，释放锁和CPU资源
4. sleep() 线程进入阻塞状态 不会释放锁，会释放CPU
5. interrupt() 线程终止 只是修改中断标记，并未真正的自动终止
需要手动判断标志来结束线程，在sleep，wait 之后调用interrupt会抛出异常，需要在
catch中进行中断的处理
6. synchronized 在通一个class中多个非静态的锁默认为synchronized(this)
7. Object.notify 配合synchronized使用否则报错java.lang.IllegalMonitorStateException，
唤醒的线程是随机的，存在不确定性
8. Object.notifyAll 唤醒所有线程
9. join() 阻塞当前线程 例如在a线程中调用b.join(),意味着等b线程结束之后才会继续执行a线程后面的逻辑
10. yield() 让出当前的CPU使用权，不会释放锁
11. setDaemon()  何为守护进程？最后退出的进程？
## 线程的状态
1. NEW
2. RUNNABLE
3. BLOCKED
4. WAITING
5. TIMED_WAITING
6. TERMINATED
## 锁相关 