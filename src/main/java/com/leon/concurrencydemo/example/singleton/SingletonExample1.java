package com.leon.concurrencydemo.example.singleton;

import com.leon.concurrencydemo.annotation.ThreadNotSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时实例化，多线程环境下不安全
 */

@ThreadNotSafe
public class SingletonExample1 {

    // 私有构造函数，无法通过new实例化对象
    private SingletonExample1(){

    }

    // 单例对象
    private static SingletonExample1 instance = null;

    // 静态工厂方法
    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
