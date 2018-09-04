package com.sensetime.kafka_demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaDemoApplicationTests {

	@Autowired
	private Producer producer;
	@Test
	public void contextLoads() {
		producer.sendMsg("topic_1","hello");
	}

}
