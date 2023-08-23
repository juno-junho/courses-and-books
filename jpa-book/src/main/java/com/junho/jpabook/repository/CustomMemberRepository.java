package com.junho.jpabook.repository;

import com.junho.jpabook.entity.Member;

import java.util.List;

public interface CustomMemberRepository {
    public List<Member> customFindMember();
}
