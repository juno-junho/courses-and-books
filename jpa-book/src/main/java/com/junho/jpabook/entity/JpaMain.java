package com.junho.jpabook.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            logic(em);
            logic2(em, tx);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void logic(final EntityManager em) {
        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("준호");
        member.setAge(26);

        // 등록
        em.persist(member);

        // 수정
        member.setAge(20);

        // 한 건 조회
        Member findMember = em.find(Member.class, id);
        System.out.println("findMember.getUsername() = " + findMember.getUsername());
        System.out.println("findMember.getAge() = " + findMember.getAge());

        // 목록 조회
        List<Member> members =
                em.createQuery("select m from Member m", Member.class)
                .getResultList();
        System.out.println("members.size(); = " + members.size());

        TypedQuery<Member> selectMFromMemberM = em.createQuery("select m from Member m", Member.class);
//        Stream<Member> resultStream = selectMFromMemberM.getResultStream();
//        Member singleResult = selectMFromMemberM.getSingleResult();
//        Map<String, Object> hints = selectMFromMemberM.getHints();

        // 삭제
        em.remove(member);
    }

    private static void logic2(final EntityManager em, final EntityTransaction tx) {

        // 준영속 상태의 초기화 (chapter 8)
        Member member = em.getReference(Member.class, "id1");
        tx.commit();
        em.close();
        member.getUsername(); // 준영속 상태 초기화 시도. // LazyInitializationException 발생
    }
}
