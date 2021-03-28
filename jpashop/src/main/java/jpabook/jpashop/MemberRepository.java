package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member){
        em.persist(member); // 저장하는 코드(JPA)
        return member.getId();
        // Command와 Query를 분리하라. (원칙)
        // 저장을 하고 나면 가급적이면 Command성이기 때문에 Return 값을 만들지 않는것이 좋다.
        // SideEffect 발생 가능
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }

}
