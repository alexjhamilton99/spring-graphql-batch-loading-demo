package com.hamilton.j.alex.springgraphqlbatchloadingdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
