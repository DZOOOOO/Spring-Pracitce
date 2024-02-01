package com.springpractice.jdbc.repository;

import com.springpractice.jdbc.connection.ConnectionConst;
import com.springpractice.jdbc.domain.Member;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static com.springpractice.jdbc.connection.ConnectionConst.*;
import static org.assertj.core.api.Assertions.*;

@Slf4j
class MemberRepositoryV1Test {

    MemberRepositoryV1 repository;

    @BeforeEach
    void beforeEach() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        repository = new MemberRepositoryV1(dataSource);
    }

    @Test
    void crud() throws SQLException {
        log.info("start");

        // create
        Member member = new Member("memberV1", 10000);
        repository.save(member);

        // read
        Member findMember = repository.findById(member.getMemberId());
        assertThat(findMember).isNotNull();

        // update
        repository.update(member.getMemberId(), 20000);
        Member updateMember = repository.findById(member.getMemberId());
        assertThat(updateMember.getMoney()).isEqualTo(20000);

        // delete
        repository.delete(member.getMemberId());
        assertThatThrownBy(() -> repository.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);
    }

}