package com.junho.tx;

import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RequiredArgsConstructor
public class JDBCTransaction {

    private final DataSource dataSource;

    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
        Connection connection = dataSource.getConnection();

        try {
            connection.setAutoCommit(false);
            bizLogic(connection, fromId, toId, money);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw new IllegalArgumentException(e);
        } finally {
            connection.close();

        }

    }

    private void bizLogic(final Connection connection, final String fromId, final String toId, final int money) {
        // business logic
    }
}
