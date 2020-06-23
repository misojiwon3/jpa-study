package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // JPA 를 사용하는 애구나
public class Member {

  @Id
  private Long id;

  @Column(name = "name")
  private String name;

  public Member() {
  }

  public Member(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Member{" +
      "id=" + id +
      ", name='" + name + '\'' +
      '}';
  }
}
