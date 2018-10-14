package com.leon.concurrencydemo.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.leon.concurrencydemo.annotation.ThreadSafe;


@ThreadSafe
public class ImmutableExample3 {
    private final static ImmutableList LIST = ImmutableList.of(1, 2, 3);
    private final static ImmutableSet SET = ImmutableSet.copyOf(LIST);
    private final static ImmutableMap MAP = ImmutableMap.of(1, 2, 3, 4);

    public static void main(String[] args) {
        // 抛异常
        // LIST.add(4);
        // SET.add(4);
        // MAP.put(5, 6);
    }
}