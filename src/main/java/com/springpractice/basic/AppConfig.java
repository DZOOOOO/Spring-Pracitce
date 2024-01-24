package com.springpractice.basic;

import com.springpractice.basic.member.MemberRepository;
import com.springpractice.basic.member.MemberService;
import com.springpractice.basic.member.MemberServiceImpl;
import com.springpractice.basic.member.MemoryMemberRepository;
import com.springpractice.basic.order.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }


}
