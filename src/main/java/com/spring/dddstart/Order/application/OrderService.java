package com.spring.dddstart.Order.application;

import com.spring.dddstart.Order.domain.Order;
import com.spring.dddstart.Order.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional // 구현의 편리함을 가져가기 위해 POJO로 만들기보다는 어느정도 스프링의 의존한다.
    public void cancelOrder(Long id) {
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("해당 아이디의 Order가 없습니다. orderId = %d".formatted(id)));
        order.cancel(); // 로직을 직접 수행하기보다는 도메인 모델에 로직 수행을 위임
    }
}
