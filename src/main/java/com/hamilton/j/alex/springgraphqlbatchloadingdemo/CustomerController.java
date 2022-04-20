package com.hamilton.j.alex.springgraphqlbatchloadingdemo;

import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    private final OrderService orderService;

    public CustomerController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @QueryMapping
    public Iterable<Customer> allCustomers() {
        return customerService.fetchAll();
    }

    @BatchMapping
    public Map<Customer, List<Order>> orders(List<Customer> customers) {
        return customerService.fetchWithOrders(customers);
    }

    @QueryMapping
    public Iterable<Customer> allCustomersBad(DataFetchingEnvironment env) {
        return env.getSelectionSet().contains("orders") ?
                customerService.fetchAllWithOrdersLeftJoin() : customerService.fetchAll();
    }

}
