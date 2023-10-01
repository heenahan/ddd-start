package com.spring.dddstart.Order.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculateDiscountServiceTest {

    @InjectMocks
    private CalculateDiscountService calculateDiscountService;

    @Mock
    private RuleDiscounter ruleDiscounter; // 목으로 만듦으로써 테스트하기 쉬워짐

    @Test
    void calculateTest() {
        // given
        doNothing().when(ruleDiscounter).calculate();

        // when
        calculateDiscountService.calculateDiscount();

        // then
        verify(ruleDiscounter, times(1)).calculate();
    }
}