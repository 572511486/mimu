package com.glaway.myspringboot.ymal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class PersonTest {

	@Autowired
	private Person person;

	/**
	 * @author 		   FZH
	 * @date 		   2020/10/27
	 * @parameter 	   []
	 * @return 		   void
	 * @description
	 *      封装ymal数据导javabean
	 **/
	@Test
	public void readYaml() {
		log.info("yaml中person数据==>" + person.toString());
	}


	@Value("${person.dog.name}")
	private String dogName;

	@Test
	public void readSignalYaml() {
		log.info("yaml中单值==>" + dogName);
	}


}