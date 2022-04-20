package com.hamilton.j.alex.springgraphqlbatchloadingdemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

import java.util.List;

@GraphQlRepository
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByCustomerIn(List<Customer> customers);

}
