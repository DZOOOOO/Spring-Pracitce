package com.springpractice.basic.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    void lifeCycleTest() {
        ConfigurableApplicationContext ac
                = new AnnotationConfigApplicationContext(LifeCycleConfig.class);

        NetWorkClient client = ac.getBean(NetWorkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {

        @Bean
        public NetWorkClient netWorkClient() {
            NetWorkClient netWorkClient = new NetWorkClient();
            netWorkClient.setUrl("http://hello-spring.dev");
            return netWorkClient;
        }
    }
}
