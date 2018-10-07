package com.leon.concurrencydemo.example.atomic;

import com.leon.concurrencydemo.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicStampedReference;

@Slf4j
@ThreadSafe
public class AtomicExample6 {

    /**
     * AtomicStampedReference 解决 CAS 操作中的 ABA 问题
     * ABA问题：线程1对 A 修改成了 B，又将 B 修改成了 A。线程2会认为字段没发生过改变
     * 通过给字段加上版本号 stamp 的方式，每次更新操作都会对 stamp 也进行更新
     */
    private static AtomicStampedReference<Integer> count = new AtomicStampedReference<>(0,0);


    public static void main(String[] args) {
        count.compareAndSet(0, 1, 0, 1);
        count.compareAndSet(1, 0, 1, 2);
        count.compareAndSet(0, 1, 2, 3);
        log.info("count:{}, stamp:{}", count.getReference(),count.getStamp());
    }
}
