package com.junho.jpabook.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
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
