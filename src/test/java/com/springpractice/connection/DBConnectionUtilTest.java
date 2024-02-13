package com.springpractice.connection;

import com.springpractice.jdbc.connection.DBConnectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class DBConnectionUtilTest {

    // 반드시 DB 연결하고 테스트 진행
    @Test
    void connection() {
        Connection connection = DBConnectionUtil.getConnection();
        assertThat(connection).isNotNull();
    }
}
