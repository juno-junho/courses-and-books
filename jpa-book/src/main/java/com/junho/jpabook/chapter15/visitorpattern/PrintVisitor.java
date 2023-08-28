package com.junho.jpabook.chapter15.visitorpattern;

public class PrintVisitor implements Visitor{
    @Override
    public void visit(final Book book) {
        // 넘어오는 book은 프록시가 아닌 원본 엔티티다
        System.out.println("book.getClass() = " + book.getClass());
        System.out.println("book.getName() + book.getAuthor() = " + book.getName() + book.getAuthor());
    }

    @Override
    public void visit(final Album album) {
        System.out.println("album.getClass() = " + album.getClass());
        System.out.println("album.getName() + album.getArtist() = " + album.getName() + album.getArtist());
    }

    @Override
    public void visit(final Movie movie) {
        System.out.println("movie.getClass() = " + movie.getClass());
        System.out.println("movie.getName() + movie.getDirector() = " + movie.getName() + movie.getDirector());
    }
}
