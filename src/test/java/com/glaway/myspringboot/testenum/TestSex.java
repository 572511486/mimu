package com.glaway.myspringboot.testenum;

/**
 * @filename:       TestSex
 * @copyright:      版权所有 2020-2025 南京国睿信维软件有限公司
 * @version:        V1.0
 * @author:         ZF
 * @createtime:     2020年08月20日16:44
 * @description:   
 *                      
 */
public class TestSex {
	public static void main(String[] args) {
		Sex male = Sex.valueOf("MALE222");
		System.out.println("main.male.name()==>" + male.name());
		System.out.println("main.male.name()==>" + male.name() instanceof String);
		System.out.println("main.male.toString()==>" + male.toString());

		System.out.println("1111111111111111111111111111111111111111111111");
		Sex[] values = Sex.values();
		// for (Sex value : values) {
		// 	System.out.println("main.value==>" + value);
		// }

		System.out.println("main.Sex.UNKNOWN.toString()==>" + Sex.UNKNOWN.toString());
		System.out.println("main.Sex.UNKNOWN.toString()==>" + Sex.UNKNOWN.toString() instanceof String);
	}
}
