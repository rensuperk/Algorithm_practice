/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author rensu
 * @date 2021/9/10 10:35
 **/
public class ProduceConsumerTest {

    public static void main(String[] args) {
         int MAX_COUNT = 3;
         AtomicInteger count = new AtomicInteger();
         ReentrantLock lock = new ReentrantLock();
        Condition pc = lock.newCondition();
        Condition cc = lock.newCondition();
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                while (count.get() > MAX_COUNT -1){
                    try {

                        pc.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count.getAndIncrement();
                System.out.println(Thread.currentThread().getName()+"生产了产品，count="+count.get());
                cc.signalAll();
                lock.unlock();
            }
        },"t1").start();
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                while (count.get() < 1){
                    try {

                        cc.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count.decrementAndGet();
                System.out.println(Thread.currentThread().getName()+"消费了产品，count="+count.get());
                pc.signalAll();
                lock.unlock();
            }
        },"t2").start();
    }
}
