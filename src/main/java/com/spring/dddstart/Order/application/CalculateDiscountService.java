package com.spring.dddstart.Order.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculateDiscountService {
    private final RuleDiscounter ruleDiscounter; // 의존성 주입 dip

    public void calculateDiscount() {
        ruleDiscounter.calculate();
    }
}