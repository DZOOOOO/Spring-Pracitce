package com.springpractice.basic.singleton;

public class SingletonService {

    // 1. 딱 하나만 객체를 생성 해둔다.
    private static final SingletonService instance = new SingletonService();

    // 2. 외부에서 새로운 객체 생성을 막음.
    private SingletonService() {
    }

    // 3. 이 메서드를 통해서만 객체 조회가능.
    public static SingletonService getInstance() {
        return instance;
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
