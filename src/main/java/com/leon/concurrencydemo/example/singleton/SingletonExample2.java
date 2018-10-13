package com.leon.concurrencydemo.example.singleton;

import com.leon.concurrencydemo.annotation.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 * 线程安全，但会影响加载时的性能和可能的资源浪费，如果未被使用
 */

@ThreadSafe
public class SingletonExample2 {

    // 私有构造函数，无法通过new实例化对象
    private SingletonExample2(){

    }

    // 单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    // 静态工厂方法
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
