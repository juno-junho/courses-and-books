package com.junho.jpabook.chapter15.visitorpattern;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Entity
@DiscriminatorValue("M")
@Getter @Setter
public class Movie extends Item {

    private String director;
    private String actor;

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}
