package com.spring.dddstart.Order.infrastructure;


import com.spring.dddstart.Order.domain.Order;
import com.spring.dddstart.Order.domain.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderJpaRepository implements OrderRepository {
    private final EntityManager entityManager;

    @Override
    public Optional<Order> findById(Long id) {
        Order order = entityManager.find(Order.class, id);
        return Optional.of(order);
    }
}