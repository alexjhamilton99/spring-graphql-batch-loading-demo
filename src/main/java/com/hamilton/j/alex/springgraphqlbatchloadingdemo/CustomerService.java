package com.hamilton.j.alex.springgraphqlbatchloadingdemo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final OrderService orderService;

    public CustomerService(CustomerRepository customerRepository, OrderService orderService) {
        this.customerRepository = customerRepository;
        this.orderService = orderService;
    }

    public Iterable<Customer> fetchAll() {
        return customerRepository.findAll();
    }

    public Map<Customer, List<Order>> fetchWithOrders(List<Customer> customers) {
        var customersWithOrders = new HashMap<Customer, List<Order>>();

        var orders = orderService.fetchByCustomerIn(customers);

        customers.forEach(c -> {
            customersWithOrders.put(c, new ArrayList<>());

            orders.forEach(o -> {
                if (o.getCustomer().getId().equals(c.getId())) {
                    customersWithOrders.get(c).add(o);
                }
            });
        });

        return customersWithOrders;
    }

    // invoked in the bad approach
    public Iterable<Customer> fetchAllWithOrdersLeftJoin() {
        return customerRepository.findAllWithOrders();
    }

}
