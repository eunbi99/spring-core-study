package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount =1000; //1000원 할인

    @Override
    public int discount(Member member,int price) {
        if (member.getGrade() == Grade.VIP) { //vip이면
            return discountFixAmount; // 1000원 리턴
        } else { // vip가 아니면
            return 0; // 0 리턴
        }
    }
}
