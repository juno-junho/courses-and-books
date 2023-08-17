package com.junho.tx;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@SpringBootTest
class InternalCallV1Test {

    @Autowired
    CallService callService;

    @Test
    void printProxy() {
        log.info("callService class = {}", callService.getClass());
    }

    @Test
    void internalCall() {
        callService.internal();
        log.info("callService class = {}", callService.getClass());
    }

    @Test
    void externalCall() {
        callService.external();
        log.info("callService class = {}", callService.getClass());
    }

    @TestConfiguration
    @SpringBootConfiguration
    static class InternalCallV1Config {

        @Bean
        CallService callService() {
            return new CallService();
        }
    }



}

@Slf4j
class CallService {
    public void external() {
        log.info("call external");
        printTxInfo();
        internal();
    }

    @Transactional
    public void internal() {
        log.info("call internal");
        printTxInfo();
    }

    private void printTxInfo() {
        boolean isTxActive = TransactionSynchronizationManager.isActualTransactionActive();
        log.info("tx active={}", isTxActive);
    }
}
