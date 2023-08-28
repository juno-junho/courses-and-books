package com.junho.jpabook.chapter15.visitorpattern;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("A")
@Getter
@Setter
public class Album extends Item {

    private String artist;
    private String etc;

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}
