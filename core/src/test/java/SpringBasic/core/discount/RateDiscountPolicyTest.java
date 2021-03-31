package SpringBasic.core.discount;

import SpringBasic.core.member.Grade;
import SpringBasic.core.member.Member;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인 적용이 필요함")
    void vip_o() {
        //given
        Member member = new Member(1L, "member_vip", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 아니면 10% 할인 적용이 안됨")
    void vip_x() {
        //given
        Member member = new Member(1L, "member_basic", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }

}