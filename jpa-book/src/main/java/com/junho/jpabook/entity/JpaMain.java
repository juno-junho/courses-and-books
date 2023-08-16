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
}
