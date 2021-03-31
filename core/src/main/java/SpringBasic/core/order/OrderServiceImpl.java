package SpringBasic.core.order;

import SpringBasic.core.discount.DiscountPolicy;
import SpringBasic.core.member.Member;
import SpringBasic.core.member.MemberRepository;
import SpringBasic.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    /* 추상 인터페이스 뿐 아니라, 구체(구현) 클래스에도 의존하고 있음
    * DiscountPolicy-> 추상, FixDiscountPolicy, RateDiscountPolicy -> 구현 클래스
    * Interface만 의존한게 아니라 구체 클래스까지도 함께 의존함 (DIP 위반)
    * DIP 의존관계를 역전해서 해야함(구체 의존 말고 항상 추상화에 의존하라!)
    * 따라서 아래 코드는 망한 코드
    * FixDiscountPolicy를 변경하는 순간 orderImpl소스도 변경해야 함 => OCP 위반 */

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy;
    /* 누군가 OrderServiceImpl에 DiscountPolicy의 구현 객체를 대신 생성하고 넣어줘야 */

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
