package com.junho.jpabook.repository;

import com.junho.jpabook.entity.Member;

import java.util.Collections;
import java.util.List;

public class CustomMemberRepositoryImpl implements CustomMemberRepository {

    @Override
    public List<Member> customFindMember() {
        System.out.println("custom method ... ");
        System.out.println("custom method ... ");
        System.out.println("custom method ... ");
        return Collections.emptyList();
    }
}
