package com.leon.concurrencydemo.example.singleton;

import com.leon.concurrencydemo.annotation.NotRecommend;
import com.leon.concurrencydemo.annotation.ThreadNotSafe;
import com.leon.concurrencydemo.annotation.ThreadSafe;

/**
 * 懒汉模式改进
 * 双重检测锁，但是线程不安全，原因：指令重排
 */

@ThreadNotSafe
public class SingletonExample4 {

    // 私有构造函数，无法通过new实例化对象
    private SingletonExample4(){

    }

    // 单例对象
    private static SingletonExample4 instance = null;

    /**
     * instance = new SingletonExample4() 过程
     * 1、memory = allocate() 分配对象空间
     * 2、ctorInstance() 初始化对象
     * 3、instance = memory 设置instance指向刚分配的内存
     * 多线程环境下，在可能发生的指令重排后，以上3个步骤可能不按顺序执行，此方法依旧会出现线程不安全
     * 可能出现的重排结果：
     * 1、memory = allocate() 分配对象空间
     * 2、instance = memory 设置instance指向刚分配的内存
     * 3、ctorInstance() 初始化对象
     * 可能存在的案例：线程A调用instance = new SingletonExample4()，进入以上指令的第2步
     * 与此同时线程B进入方法，发现不为null（分配到了内存），直接return instance
     * 但第3步并未执行，出现对象未被初始化的情况，造成潜在的问题
     */
    public static SingletonExample4 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample4.class) {
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
