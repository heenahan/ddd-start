package com.spring.dddstart.Order.domain.repository;

import com.spring.dddstart.Order.domain.Order;

import java.util.Optional;

public interface OrderRepository { // 영속 기능을 추상화 고수준 모듈에 속함

    Optional<Order> findById(Long id);
}