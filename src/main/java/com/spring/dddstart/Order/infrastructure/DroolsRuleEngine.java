package com.spring.dddstart.Order.infrastructure;

import com.spring.dddstart.Order.application.RuleDiscounter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class DroolsRuleEngine implements RuleDiscounter { // 고수준 모듈인 추상체에 의존

    @Override
    public void calculate() {
        log.info("계산 중입니다...");
    }
}