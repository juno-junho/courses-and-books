package com.junho.jpabook.chapter15.visitorpattern;

public class TitleVisitor implements Visitor {

    private String title;

    public String getTitle() {
        return title;
    }

    @Override
    public void visit(final Book book) {
        title = "[제목 : " + book.getName() + " 저자 : " + book.getAuthor() + " ]";
    }

    @Override
    public void visit(final Album album) {
        title = "[제목 : " + album.getName() + " 작사 : " + album.getArtist() + " ]";
    }

    @Override
    public void visit(final Movie movie) {
        title = "[제목 : " + movie.getName() + " 감독 : " + movie.getDirector() + " ]";
    }
}
