package com.junho.jpabook.chapter15;

import com.junho.jpabook.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class NoResultExceptionTestRepository {

    @PersistenceContext
    EntityManager em;

    // JPA 예외 - NoResultException 발샏 -> Processor에 의해서 AOP 인터셉터가 동작해 EmptyResultDataAccessException 예외 변환해 반환.
    public Member findMember() {
        return em.createQuery("select m from Member m", Member.class)
                .getSingleResult();
    }

    public Member findMember1() throws NoResultException { // 예외 변환 x
        return em.createQuery("select m from Member m", Member.class)
                .getSingleResult();
    }
}
