package com.example.chapter02.discount.condition;

import com.example.chapter02.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
