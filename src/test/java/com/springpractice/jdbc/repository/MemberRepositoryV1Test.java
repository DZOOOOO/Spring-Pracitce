package com.springpractice.jdbc.repository;

import com.springpractice.jdbc.domain.Member;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static com.springpractice.jdbc.connection.ConnectionConst.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
class MemberRepositoryV1Test {

    MemberRepositoryV1 memberRepositoryV1;

    @BeforeEach
    void beforeEach() {
        // 기본 DriverManager - 항상 새로운 커넥션을 획득
//        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);

        // 커넥션 풀링 - Hikari
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        memberRepositoryV1 = new MemberRepositoryV1(dataSource);
    }

    @Test
    void crud() throws SQLException {
        // save
        Member member = new Member("memberV1", 10000);
        memberRepositoryV1.save(member);

        // findById
        Member findMember = memberRepositoryV1.findById(member.getMemberId());
        log.info("findMember = {}", findMember);
        assertThat(findMember).isEqualTo(member);

        // update: money: 10000 -> 20000
        memberRepositoryV1.update(member.getMemberId(), 20000);
        Member updatedMember = memberRepositoryV1.findById(member.getMemberId());
        assertThat(updatedMember.getMoney()).isEqualTo(20000);

        // delete
        memberRepositoryV1.delete(member.getMemberId());
        assertThatThrownBy(() -> memberRepositoryV1.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);
    }
}