package com.junho.jpabook.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Slf4j
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    @OrderBy("username desc, id asc")
    private List<Member> members = new ArrayList<>();

    // 연관관계 편의 메서드
    public void addMember(Member member) {
        this.members.add(member);

        // 무한 루프 체크
        if (member.getTeam() != this) {
            member.setTeam(this);
        }
    }
}
