package hellojpa;

import hellojpa.domain.Order;
import hellojpa.domain.OrderItem;
import hellojpa.practice.Person;
import hellojpa.practice.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
  public static void main(String[] args) {
    // 만드는 순간 DB랑 연동 다 된거
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // 얘는 app 당 한개만 있어야 함

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

      /*
      Member member = em.find(Member.class, 2L);
      member.setName("ZZZA");

//      em.detach(member);
      em.clear();

      Member member2 = em.find(Member.class, 2L);

      System.out.println("============================");
       */

      /*
      Member member = new Member(2L, "member2");

      em.persist(member);

      em.flush(); // 쓰기 지연 SQL을 비우고 그 SQL들을 적용하는 과정?

      System.out.println("============================");
       */

      /*
      Member member = new Member();
      member.setUsername("C");

      System.out.println("===========================");
      em.persist(member);
      System.out.println("member.id : " + member.getId());
      System.out.println("===========================");
       */

      /*
      User user1 = new User();
      user1.setUsername("A");

      User user2 = new User();
      user2.setUsername("B");

      User user3 = new User();
      user3.setUsername("C");

      System.out.println("===========================");
      em.persist(user1);
      em.persist(user2);
      em.persist(user3);
      System.out.println("user id 1 : "+ user1.getId());
      System.out.println("user id 2 : "+ user2.getId());
      System.out.println("user id 3 : "+ user3.getId());
      System.out.println("===========================");
       */

//      Order order = em.find(Order.class, 1L);
//      Long memberId = order.getMemberId();

      // 저장
      Team team = new Team();
      team.setName("TeamA");
      em.persist(team);

//      Team team2 = new Team();
//      team.setName("TeamB");
//      em.persist(team2);

      Person person = new Person();
      person.setUsername("person1");
      person.setTeam(team);
      em.persist(person);

//      em.flush();
//      em.clear();

      Person findPerson = em.find(Person.class, person.getId());
      List<Person> persons = findPerson.getTeam().getPersons();

      System.out.println(persons.size());
      for (Person p : persons) {
        System.out.println("person = " + p.getUsername());
      }

      /*
      Team findTeam = findPerson.getTeam();
      System.out.println(findTeam.getName());

      Team newTeam = em.find(Team.class, 2L);

      findPerson.setTeam(newTeam);
       */

      Order order = new Order();
      order.addOrderItem(new OrderItem());

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
