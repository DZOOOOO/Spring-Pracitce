package com.springpractice.basic.order;

import com.springpractice.basic.member.Grade;
import com.springpractice.basic.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 10% 할인이 적용되어야 한다.")
    void vip_o() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        int discount = rateDiscountPolicy.discount(member, 10000);
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.BASIC);
        int discount = rateDiscountPolicy.discount(member, 10000);
        assertThat(discount).isEqualTo(0);
    }

}