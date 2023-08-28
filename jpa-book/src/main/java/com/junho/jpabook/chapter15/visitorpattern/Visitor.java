package com.junho.jpabook.chapter15.visitorpattern;

public interface Visitor {

    void visit(Book book);
    void visit(Album album);
    void visit(Movie movie);


}
