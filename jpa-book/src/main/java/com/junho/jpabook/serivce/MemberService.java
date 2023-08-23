package com.junho.jpabook.serivce;

import com.junho.jpabook.entity.Member;
import com.junho.jpabook.repository.MemberRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRespository memberRespository;

    public void test() {
        // Custom Repository 사용 가능
        List<Member> members = memberRespository.customFindMember();
    }
}
