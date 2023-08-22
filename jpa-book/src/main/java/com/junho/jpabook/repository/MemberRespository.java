package com.junho.jpabook.repository;

import com.junho.jpabook.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRespository extends JpaRepository<Member, Long> {

    // NamedQuery with Param annotation
    List<Member> findByUsername(@Param("username") String username);

    // using Query annotation with JPQL
    @Query("select m from Member m where m.username = ?1")
    Member findByUsernameUsingQuery(String username);

    // using Query annotation with native query
    @Query(value = "select * from Member WHERE username = ?0", nativeQuery = true)
    Member findByUsernameUsingNativeQuery(String username);

    // bulk성 수정 쿼리
    @Modifying
    @Query("update Product p set p.price = p.price * 1.1 where p.stockAmount < :stockAmount")
    int bulkPriceUp(@Param("stockAmount") String stockAmount);
}
