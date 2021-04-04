package SpringBasic.core.singleton;

import SpringBasic.core.AppConfig;
import SpringBasic.core.member.Member;
import SpringBasic.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 생성")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);
        //같은 객체 인스턴스 반환을 확인할 수 있음!

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }


    // isequalto와 issameas 차이? -> same == // equals (equal 메소드 참고)
    // Spring Container의 경우 싱글톤 패턴을 자동으로 적용해줌!
    // 싱글톤의 경우 문제점?
    // 1. 코드가 길어짐
    // 2. 의존관계상 클라이언트가 구체 클래스 의존 -> DIP위반
    // 3. 클라이언트 구체클래스 위반 => OCP원칙 위반
    // 4. 싱글톤 테스트 하기 어려움
    // 5. private 생성자 -> 자식 생성 불가
    // 6. 유연성 떨어짐(내부 속성 변경 및 초기화가 어려움)
    // 7. 안티패턴으로 불리기도 함함
    // => Spring은 이거 다 해결하고 Singleton으로 관리해준다?!

    @Test
    @DisplayName("스프링 컨테이너에서 싱글톤 써보기")
    void springContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
