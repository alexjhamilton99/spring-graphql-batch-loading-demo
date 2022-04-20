package com.hamilton.j.alex.springgraphqlbatchloadingdemo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Iterable<Order> fetchByCustomerIn(List<Customer> customers) {
        return orderRepository.findByCustomerIn(customers);
    }
}
