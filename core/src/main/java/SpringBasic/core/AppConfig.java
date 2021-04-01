package SpringBasic.core;

import SpringBasic.core.discount.DiscountPolicy;
import SpringBasic.core.discount.FixDiscountPolicy;
import SpringBasic.core.member.MemberService;
import SpringBasic.core.member.MemberServiceImpl;
import SpringBasic.core.member.MemoryMemberRepository;
import SpringBasic.core.order.OrderService;
import SpringBasic.core.order.OrderServiceImpl;

public class AppConfig { // 역할이 다 드러나게 Refactor

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository()); // ctrl + alt + m -> Refactoring
        //MemberServiceImpl을 만들고 MemoryMemberRepository를 사용함.
    }

    private MemoryMemberRepository memberRepository() { // DB 변경시 이 코드만 바꾸면 됨.
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
