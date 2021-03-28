package jpabook.jpashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter // 이 두가지 이용시 method로 따로 만들 필요없음 getdata set data로 해결 가능!
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String username;
}
