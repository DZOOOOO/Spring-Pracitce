package com.springpractice.basic.order;

import com.springpractice.basic.member.Member;

public interface DiscountPolicy {
    // 등급에 따른 할인율 체크 메서드
    int discount(Member member, int price);
}
