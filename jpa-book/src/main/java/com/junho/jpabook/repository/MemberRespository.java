package com.junho.jpabook.repository;

import com.junho.jpabook.entity.Member;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRespository extends JpaRepository<Member, Long>, JpaSpecificationExecutor<Member>, CustomMemberRepository{

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

    // 페이징 - count 쿼리 사용
    @QueryHints(
            value = {
                    @QueryHint( name = "org.hibername.readOnly", value = "true")
            },
            forCounting = true
    )
    @Lock(LockModeType.PESSIMISTIC_WRITE) // Lock 설정 가능
    Page<Member> findByUsername(String username, Pageable pageable);
    // 페이징 - cout 쿼리 사용 x (List, Slice)
//    List<Member> findByUsername(String username, Pageable pageable);

    List<Member> findByUsername(String username, Sort sort);
}
