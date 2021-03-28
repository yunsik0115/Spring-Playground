package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
// @Rollback(false) 이용시 데이터 롤백이 일어나지 않는다. --> commit 된다.
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional // Test Case에 있는 경우, 여기서 Transactional은 DB를 롤백해버림.
    // Data 존재시 반복해서 테스트가 안되는 문제점을 자동으로 해결해준다.
    // spring framework가 제공하는 transactional 쓰는것을 권장
    // Transaction안에서 모든 entitymanager의 활동이 일어남(반드시 써줘야)
    public void testMember() throws Exception {
        Member member = new Member();
        member.setUsername("memberA");

        //When
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);
        // ctrl + alt + v => 변수로 추출해줌.

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());

        /*
        Assertions.assertThat(findMember).isEqualTo(member); --> ?
        같다? 같지 않다? -> True가 나옴.
        같은 Transaction(영속성 안에서) Id값(식별자)이 같으면 같은 Entity로 식별한다.
        JPA 엔터티 동일성 보장을 참고하자.
        */
    }

}