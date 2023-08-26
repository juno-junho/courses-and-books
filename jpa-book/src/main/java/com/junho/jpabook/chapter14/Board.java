package com.junho.jpabook.chapter14;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Board {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String content;

    @OneToMany(mappedBy = "board")
//    @OrderColumn(name = "POSITION") // PersistentList 사용 -> 순서가 있는 컬렉션으로 인식한다.
    private List<Comment> comments = new ArrayList<>();
}
