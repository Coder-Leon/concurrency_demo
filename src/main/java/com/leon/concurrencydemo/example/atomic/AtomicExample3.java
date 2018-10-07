package com.leon.concurrencydemo.example.atomic;

import com.leon.concurrencydemo.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

@Slf4j
@ThreadSafe
public class AtomicExample3 {
    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;


    /**
     * JDK8 新增 LongAdder 类 ，默认值0
     * 传统的AtomicLong类，采用死循环的方式不断 compareAndSwapLong，性能受到影响
     * 优点：适合更高并发的场景。将64位的long类型拆分为两个32位的value，将单点更新的压力分散到了各节点，读取时再统计数字
     * 缺点：统计时如果有并发更新，会造成统计结果存在误差；生成序列号等场景全局唯一应该选择AtomicLong
     */
    public static LongAdder count = new LongAdder();

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}", count);
    }

    public static void add() {
        count.increment();
        // 等同于 count.add(1L)
    }
}
