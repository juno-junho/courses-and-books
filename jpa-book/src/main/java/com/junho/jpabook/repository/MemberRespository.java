package com.junho.jpabook.repository;

import com.junho.jpabook.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRespository extends JpaRepository<Member, Long> {

    // NamedQuery
    List<Member> findByUsername(@Param("username") String username);

}
