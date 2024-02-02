package com.springpractice.exception.basic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UnCheckedTest {


    static class MyUnCheckedException extends RuntimeException {
        public MyUnCheckedException(String message) {
            super(message);
        }
    }

    static class Service {
        Repository repository = new Repository();

        // 예외를 처리
        public void callCatch() {
            try {
                repository.call();
            } catch (MyUnCheckedException e) {
                log.info("예외 처리, message = {}", e.getMessage(), e);
            }
        }

        // 예외를 밖으로 던지기
        public void callThrow() {
            repository.call();
        }
    }

    static class Repository {
        public void call() {
            throw new MyUnCheckedException("ex");
        }
    }
}
