package com.leon.concurrencydemo.example.publish;

import com.leon.concurrencydemo.annotation.ThreadNotSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 对象逸出
 */

@Slf4j
@ThreadNotSafe
public class Escape {
    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass{
        public InnerClass(){
            log.info("num: {}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }

}
