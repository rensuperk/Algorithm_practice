/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */

import java.util.PrimitiveIterator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author rensu
 * @date 2021/9/10 10:57
 **/
public class CyclePrint {
    public static void main(String[] args) {
        //多个线程交替打印
        String s1 = "123456789";
        String s2 = "abcdefg";
        String s3 = "ABCDEFG";
        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();
        new Thread(()->{
            for (int i = 0; i < s1.length(); i++) {
                lock.lock();
                System.out.print(s1.charAt(i));
                c2.signal();
                if (i < s2.length()){
                    try {
                        c1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.unlock();
            }
        },"t1").start();
        new Thread(()->{
            for (int i = 0; i < s2.length(); i++) {
                lock.lock();
                System.out.print(s2.charAt(i));
                c3.signal();
                if (i < s3.length()){
                    try {
                        c2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                lock.unlock();
            }
        },"t2").start();
        new Thread(()->{
            for (int i = 0; i < s3.length(); i++) {
                lock.lock();
                System.out.print(s3.charAt(i));
                c1.signal();
                if (i < s1.length()){
                    try {
                        c3.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                lock.unlock();
            }
        },"t3").start();
    }
}
