package SpringBasic.core;

import SpringBasic.core.discount.FixDiscountPolicy;
import SpringBasic.core.member.MemberService;
import SpringBasic.core.member.MemberServiceImpl;
import SpringBasic.core.member.MemoryMemberRepository;
import SpringBasic.core.order.OrderService;
import SpringBasic.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
        //MemberServiceImpl을 만들고 MemoryMemberRepository를 사용함.
    }

    public OrderService orderService(){
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy());
    }

}
