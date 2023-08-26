package com.junho.jpabook.chapter14;

import jakarta.persistence.PrePersist;

public class DuckListener {

    @PrePersist // 특정 타입 확실하면 특정 타입 받을 수 있다.
    private void prePersist(Object object) {
        System.out.println("prePersist" + object);
    }
}
