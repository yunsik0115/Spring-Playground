package SpringBasic.core;

import SpringBasic.core.discount.DiscountPolicy;
import SpringBasic.core.discount.FixDiscountPolicy;
import SpringBasic.core.discount.RateDiscountPolicy;
import SpringBasic.core.member.MemberService;
import SpringBasic.core.member.MemberServiceImpl;
import SpringBasic.core.member.MemoryMemberRepository;
import SpringBasic.core.order.OrderService;
import SpringBasic.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정 정보(Via Spring)

public class AppConfig { // 역할이 다 드러나게 Refactor
    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()
    // 각각이 두번 호출하면 싱글톤 디자인 패턴이 깨지는게 아닐까?
    // 이럴땐 바로 테스트코드로 실험을 해보면 명쾌하게 해결됨.

    // call Appconfig.memberService
    // call Appconfig.memberRepository
    // call Appconfig.memberRepository
    // call Appconfig.orderService
    // call Appconfig.memberRepository => 현실 한번씩만 호출됨 어떻게....?

    @Bean // -> Spring Conatiner에 등록된다.
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); // ctrl + alt + m -> Refactoring
        //MemberServiceImpl을 만들고 MemoryMemberRepository를 사용함.
    }

    @Bean
    public MemoryMemberRepository memberRepository() { // DB 변경시 이 코드만 바꾸면 됨.
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
