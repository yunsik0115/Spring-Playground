package SpringBasic.core.singleton;

import SpringBasic.core.AppConfig;
import SpringBasic.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        // 1. 조회 : 호출할 때마다 객체 생성?
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        // test 결과 두 객체가 서로 다르다는것을 알 수 있음.
        // 객체의 연속 생성 -> 효율상 좋지 못함.

        //memberService1 != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }
    // 순수 DI 컨테이너는 Appconfig 요청시마다 객체 새로 생성
    // 메모리 낭비가 매우 심함(고객 트래픽 초당 100 -> 객체 초당 100개 생성)
    // Singleton 패턴을 통해 객체가 한개만 생성되고 공유하도록 설계하면 됨.
}