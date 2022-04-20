package com.hamilton.j.alex.springgraphqlbatchloadingdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

import java.util.List;

@GraphQlRepository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query("""
            SELECT 
                c
            FROM
                Customer c
            LEFT JOIN FETCH 
                c.orders o
            """)
    Iterable<Customer> findAllWithOrders();

}
