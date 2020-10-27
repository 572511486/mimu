package com.glaway.myspringboot.ymal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class PersonTest {
	@Autowired
	private Person person;
	@Test
	public void readYml() {
		log.info("yml中person数据==>" + person.toString());
	}

}