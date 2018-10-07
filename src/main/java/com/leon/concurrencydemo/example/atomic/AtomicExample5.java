package com.leon.concurrencydemo.example.atomic;

import com.leon.concurrencydemo.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.LongAdder;

@Slf4j
@ThreadSafe
public class AtomicExample5 {

    // AtomicIntegerFieldUpdater 原子性的更新某个实例的某个字段，且要求字段被 volatile 修饰
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    public volatile int count = 100;

    public static void main(String[] args) {

        AtomicExample5 atomicExample5 = new AtomicExample5();

        if (updater.compareAndSet(atomicExample5, 100, 120)) {
            log.info("update success, {}", atomicExample5.getCount());
        }
        if (updater.compareAndSet(atomicExample5, 100, 120)) {
            log.info("update success, {}", atomicExample5.getCount());
        } else {
            log.info("update failed, {}", atomicExample5.getCount());
        }
    }
}
