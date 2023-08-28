package com.junho.jpabook.chapter15.visitorpattern;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("B")
@Getter
@Setter
public class Book extends Item {

    private String author;
    private String isbn;

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}
