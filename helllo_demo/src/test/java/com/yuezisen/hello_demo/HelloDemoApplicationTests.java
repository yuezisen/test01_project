package com.yuezisen.hello_demo;

import com.yuezisen.hello_demo.POJO.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class HelloDemoApplicationTests {
	@Autowired
	Person person;
	@Test
	void contextLoads() {
		System.out.println(person);
	}
}
