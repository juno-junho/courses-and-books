package com.junho.jpabook.chapter15;

import com.junho.jpabook.chapter15.visitorpattern.Book;
import com.junho.jpabook.chapter15.visitorpattern.Item;
import com.junho.jpabook.entity.Member;
import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        for (int i = 0; i < 100000; i++) {
            Book book = new Book("book" + i, "10000");
            em.persist(book);

            if (i % 100 == 0) {
                em.flush();
                em.clear();
            }

        }
        tx.commit();
        em.close();
    }

    public void usingPageingBatchQuery() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        int pageSize = 100;
        for (int i = 0; i < 10; i++) {
            List<Book> resultList = em.createQuery("select p from Book p", Book.class)
                    .setFirstResult(i * pageSize)
                    .setMaxResults(pageSize)
                    .getResultList();

            // 비즈니스 로직 실행
            for (Book book : resultList) {
                book.setIsbn(String.valueOf(book.getId() + 10000));
            }
            em.flush();
            em.clear();
        }
        tx.commit();
        em.close();
    }
}
