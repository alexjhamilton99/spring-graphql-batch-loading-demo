package com.hamilton.j.alex.springgraphqlbatchloadingdemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
