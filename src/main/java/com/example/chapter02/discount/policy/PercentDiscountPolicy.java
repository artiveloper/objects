package com.example.chapter02.discount.policy;

import com.example.chapter02.Money;
import com.example.chapter02.Screening;
import com.example.chapter02.discount.condition.DiscountCondition;

/*
    할인 정책 - 비율 할인 정책
 */
public class PercentDiscountPolicy extends DiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
