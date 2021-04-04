package SpringBasic.core.singleton;

import SpringBasic.core.AppConfig;
import SpringBasic.core.member.MemberRepository;
import SpringBasic.core.member.MemberServiceImpl;
import SpringBasic.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        Assertions.assertThat(memberRepository1).isEqualTo(memberRepository2);
        // ??? 같다??? 왜? new는 3번 호출되는데? 인스턴스가 같은게 생성이 될까....?
    }
}
