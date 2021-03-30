package SpringBasic.core;

import SpringBasic.core.member.Grade;
import SpringBasic.core.member.Member;
import SpringBasic.core.member.MemberService;
import SpringBasic.core.member.MemberServiceImpl;
import SpringBasic.core.order.Order;
import SpringBasic.core.order.OrderService;
import SpringBasic.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order =" + order);
    }
}
