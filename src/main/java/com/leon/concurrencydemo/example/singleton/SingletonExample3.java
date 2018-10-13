package com.leon.concurrencydemo.example.singleton;

import com.leon.concurrencydemo.annotation.NotRecommend;
import com.leon.concurrencydemo.annotation.ThreadSafe;

/**
 * 线程安全的懒汉模式改进
 * 直接锁住整个 getInstance ，不推荐
 */

@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    // 私有构造函数，无法通过new实例化对象
    private SingletonExample3(){

    }

    // 单例对象
    private static SingletonExample3 instance = null;

    // 静态工厂方法，添加syn同步锁住整个方法，但是性能低
    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
