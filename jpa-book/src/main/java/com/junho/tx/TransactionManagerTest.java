package com.junho.tx;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.SQLException;

@RequiredArgsConstructor
public class TransactionManagerTest {

    private final DataSource dataSource;

    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
        PlatformTransactionManager transactionManager = new JdbcTransactionManager(dataSource);
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            bizLogic(fromId, toId, money);
            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw new IllegalStateException(e);
        }
    }

    private void bizLogic(final String fromId, final String toId, final int money) {
        // business logic
    }
}
