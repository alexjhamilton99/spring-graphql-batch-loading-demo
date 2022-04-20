package com.hamilton.j.alex.springgraphqlbatchloadingdemo;

import graphql.scalars.ExtendedScalars;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphQlConfig {

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return runtimeWiringConfigurer -> runtimeWiringConfigurer
                .scalar(ExtendedScalars.Date);
    }

}
