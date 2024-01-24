package com.springpractice;

import com.springpractice.basic.AppConfig;
import com.springpractice.basic.member.Grade;
import com.springpractice.basic.member.Member;
import com.springpractice.basic.member.MemberService;
import com.springpractice.basic.order.Order;
import com.springpractice.basic.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        Order order = orderService.createOrder(findMember.getId(), "itemA", 10000);

        System.out.println("order = " + order);
    }
}
