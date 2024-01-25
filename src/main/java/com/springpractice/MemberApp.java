package com.springpractice;

import com.springpractice.basic.AppConfig;
import com.springpractice.basic.member.Grade;
import com.springpractice.basic.member.Member;
import com.springpractice.basic.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        // 1. 스프링 컨테이너 생성
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);

        // 2. 컨테이너에 빈 등록 및 의존관계 주입
        MemberService memberService
                = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(member.getId());
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
