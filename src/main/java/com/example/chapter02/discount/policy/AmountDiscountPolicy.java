package com.example.chapter02.discount.policy;

import com.example.chapter02.Money;
import com.example.chapter02.Screening;
import com.example.chapter02.discount.condition.DiscountCondition;

/*
    할인 정책 - 금액 할인 정책
 */
public class AmountDiscountPolicy extends DiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
