package com.springpractice.basic;

import com.springpractice.basic.member.MemberRepository;
import com.springpractice.basic.member.MemberService;
import com.springpractice.basic.member.MemberServiceImpl;
import com.springpractice.basic.member.MemoryMemberRepository;
import com.springpractice.basic.order.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 싱글톤을 보장받기 위해서는 꼭 등록해줘야 한다. 아니면 객체를 여러번 생성한다.!
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }


}
