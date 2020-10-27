package com.glaway.myspringboot.ymal;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @filename:       Person
 * @copyright:      版权所有 2020-2025 南京国睿信维软件有限公司
 * @version:        V1.0
 * @author:         FZH
 * @createtime:     2020年10月27日9:36
 * @description:   
 *        Person 实体
 *        封装yml配置文件数据
 */
@Component
@ConfigurationProperties(prefix="person")
@Data
@Slf4j
public class Person {
	private String lastname;
	private Integer age;
	private String boss;
	private Date birth;
	private Map<Object,Object> map;
	private List<Object> lists;
	private Dog dog;
    
}
