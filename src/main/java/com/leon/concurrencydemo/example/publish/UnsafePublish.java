package com.leon.concurrencydemo.example.publish;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 不安全的发布
 */

@Slf4j
public class UnsafePublish {
    private String[] states = {"a", "b", "c"};

    public String[] getStatus(){
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStatus()));

        unsafePublish.getStatus()[0] = "d";
        log.info("states changes {}", Arrays.toString(unsafePublish.getStatus()));
    }
}
