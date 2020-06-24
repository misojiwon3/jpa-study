package hellojpa.practice;

import javax.persistence.*;

@Entity
public class Person {

  @Id
  @GeneratedValue
  @Column(name = "PERSON_ID")
  private Long id;

  @Column(name = "USERNAME")
  private String username;

  // fk 를 그대로 설정하는 것은 객체지향 방식과 맞지 않는 부분이 있음
//  @Column(name = "TEAM_ID")
//  private Long teamId;

  @ManyToOne
  @JoinColumn(name = "TEAM_ID") // 참조하는 객체의 FK가 Join Column이 된다.
  private Team team;

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

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }
}
