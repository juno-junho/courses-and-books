package com.junho.jpabook.chapter14;

import jakarta.persistence.*;

@Entity
@EntityListeners(DuckListener.class)
public class Duck {

    @Id
    @GeneratedValue
    public Long id;

    private String name;

    @PrePersist
    public void prePersist() {
        System.out.println("Duck.prePersist id=" + id);
    }

    @PostPersist
    public void postPersist() {
        System.out.println("Duck.postPersist id=" + id);
    }

    @PostLoad
    public void postLoad() {
        System.out.println("Duck.postLoad");
    }

    @PreRemove
    public void preRemove() {
        System.out.println("Duck.preRemove");
    }

    @PostRemove
    public void postRemove() {
        System.out.println("Duck.postRemove");
    }
}
