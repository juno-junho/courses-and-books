package com.junho.jpabook.chapter15.visitorpattern;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("B")
@Getter
@Setter
@AllArgsConstructor
public class Book extends Item {

    private String author;
    private String isbn;

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}
