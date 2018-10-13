package com.leon.concurrencydemo.example.singleton;

import com.leon.concurrencydemo.annotation.ThreadSafe;

/**
 * 使用枚举方式实例化对象
 * 最安全
 */

@ThreadSafe
public class SingletonExample6 {
    private SingletonExample6() {

    }

    public static SingletonExample6 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample6 singleton;

        // JVM保证方法只被调用一次
        Singleton() {
            singleton = new SingletonExample6();
        }

        public SingletonExample6 getInstance() {
            return singleton;
        }
    }
}
