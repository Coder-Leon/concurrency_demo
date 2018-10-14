package com.leon.concurrencydemo.example.immutable;

import com.google.common.collect.Maps;
import com.leon.concurrencydemo.annotation.ThreadNotSafe;
import com.leon.concurrencydemo.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    private static Map<Integer, Integer> map = Maps.newHashMap();

    static{
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);

        /**
         * 利用容器的unmodifiableMap方法修饰为不可更改的对象，引用与内容都不可更改
         * 阅读源码，可发现也是返回final修饰过的新的map对象
         * 但是同时将put等方法的内容直接进行了重写，重写成了直接抛出异常，而不是更新内容
         */
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {

        log.info("{}", map.get(1));
        try {
            map.put(1, 3);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            log.info("{}", map.get(1));
        }

    }

}
