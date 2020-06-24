package hellojpa.practice;

import javax.persistence.*;

@Entity // JPA 를 사용하는 애구나
@TableGenerator(
        name = "TEAM_SEQ_GENERATOR",
        table = "TEAM_SEQ",
        pkColumnValue = "TEAM_SEQ", allocationSize = 1)
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "TEAM_SEQ_GENERATOR")
  private Long id;

  @Column(name = "name")
  private String username;

  public Company() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
