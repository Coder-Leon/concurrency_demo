package com.leon.concurrencydemo.example.singleton;

import com.leon.concurrencydemo.annotation.ThreadSafe;

/**
 * 懒汉模式改进
 * 双重检测锁，同时防止指令重排，线程安全
 */

@ThreadSafe
public class SingletonExample5 {

    // 私有构造函数，无法通过new实例化对象
    private SingletonExample5(){

    }

    // 单例对象，volatile防止指令重排
    private volatile static SingletonExample5 instance = null;


    public static SingletonExample5 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample5.class) {
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
