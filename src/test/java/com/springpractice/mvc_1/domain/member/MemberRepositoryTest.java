package com.springpractice.mvc_1.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Member member = new Member("memberA", 20);

        // then
        Member save = memberRepository.save(member);

        // when
        assertThat(save.getUsername()).isEqualTo("memberA");
        assertThat(save.getAge()).isEqualTo(20);
    }

    @Test
    void findById() {
        // given
        Member member = new Member("memberA", 20);
        memberRepository.save(member);

        // then
        Member findMember = memberRepository.findById(member.getId());

        // when
        assertThat(findMember).isNotNull();
    }

    @Test
    void findAll() {
        // given
        Member memberA = new Member("memberA", 20);
        Member memberB = new Member("memberB", 22);
        Member memberC = new Member("memberC", 24);
        memberRepository.save(memberA);
        memberRepository.save(memberB);
        memberRepository.save(memberC);

        // then
        List<Member> members = memberRepository.findAll();

        // when
        assertThat(members.size()).isEqualTo(3);
    }


}