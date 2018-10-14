package com.leon.concurrencydemo.example.immutable;

import com.google.common.collect.Maps;
import com.leon.concurrencydemo.annotation.ThreadNotSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@ThreadNotSafe
public class ImmutableExample1 {
    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static{
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
        // a = 2;
        // b = "3";

        // final修饰的引用类型不允许指向新的对象，本身内容可发生变化
        // map = Maps.newHashMap();

        log.info("{}", map.get(1));
        map.put(1, 3);
        log.info("{}", map.get(1));
    }

    private void finalParam(final int num) {
        // 传入的实参不可变
        // num = 1;
    }
}
