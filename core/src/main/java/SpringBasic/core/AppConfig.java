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

    @Bean // -> Spring Conatiner에 등록된다.
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository()); // ctrl + alt + m -> Refactoring
        //MemberServiceImpl을 만들고 MemoryMemberRepository를 사용함.
    }

    @Bean
    public MemoryMemberRepository memberRepository() { // DB 변경시 이 코드만 바꾸면 됨.
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
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
