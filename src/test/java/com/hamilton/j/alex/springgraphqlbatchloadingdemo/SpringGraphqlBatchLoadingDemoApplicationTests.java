package com.hamilton.j.alex.springgraphqlbatchloadingdemo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringGraphqlBatchLoadingDemoApplicationTests {

	@Autowired
	private ApplicationContext ctx;

	@Test
	void contextLoads() {
		Assertions.assertThat(ctx).isNotNull();
	}

}
