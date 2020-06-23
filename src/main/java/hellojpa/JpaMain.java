package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
  public static void main(String[] args) {
    // 만드는 순간 DB랑 연동 다 된거
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello"); // 얘는 app 당 한개만 있어야 함

    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();

    try {
      // Create
//      Member member = new Member();
//      member.setId(2L);
//      member.setName("HelloB");
//      member.setId(2L);
//      member.setName("HelloB");
//      em.persist(member);

      // Select
//      Member m = em.find(Member.class, 1L);
//      System.out.println(m.getId());
//      System.out.println(m.getName());

      // Update
//      Member m = em.find(Member.class, 1L);
//      m.setName("HelloJPA modified");

      // JPQL 객체를 대상으로 query
//      List<Member> results = em.createQuery("select m from Member as m", Member.class)
//        .setFirstResult(1)
//        .setMaxResults(10)
//        .getResultList();
//
//      for (Member member : results) {
//        System.out.println("member.name : " + member.getName());
//      }

      // 비영속
      /*
      Member member = new Member();
      member.setId(6L);
      member.setName("HelloD");

      // 영속
      System.out.println("---------- before");
      em.persist(member);
      System.out.println("---------- after");
       */

//      Member mm1 = em.find(Member.class, 6L);
//      Member mm2 = em.find(Member.class, 6L);

      /*
      System.out.println(mm1.getId());
      System.out.println(mm1.getName());
      System.out.println(mm2.getId());
      System.out.println(mm2.getName());
      System.out.println(mm1 == mm2); // true
       */

      /*
      Member member1 = new Member();
      Member member2 = new Member();
      System.out.println(member1);
      System.out.println(member2);
      System.out.println(member1 == member2); // false
       */

      /*
      Member member1 = new Member(101L, "A");
      Member member2 = new Member(102L, "B");

      em.persist(member1);
      em.persist(member2);
      System.out.println("============================");
       */

      Member member = em.find(Member.class, 101L);
      member.setName("ZZZ");

      System.out.println("============================");



      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    // code


    em.close();
    emf.close();
  }
}
