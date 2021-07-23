package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int dicountPercent = 10; //할인율 10%

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * dicountPercent / 100; // VIP일 경우 10% 할인
        } else {
            return 0;
        }
    }
}
