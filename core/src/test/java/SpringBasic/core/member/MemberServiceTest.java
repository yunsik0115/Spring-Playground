package SpringBasic.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    /* JUnit을 이용해, 눈으로 보지 않고 코드가 제대로 작성하는지 TEST 가능
    * 실패시 원인 캐치가 빠르게 가능함. TEST 코드는 거의 필수로 알아야함.
    * 결론 = JUNIT을 눈여겨보도록 합시다.*/

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given 주어진 상황
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when 언제
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then 그러면
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
