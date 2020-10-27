package com.glaway.myspringboot.java8;
/**
 * @filename:       Lambda
 * @copyright:      版权所有 2020-2025 南京国睿信维软件有限公司
 * @version:        V1.0
 * @author:         FZH
 * @createtime:     2020年09月16日11:30
 * @description:   
 *      Lambda表达式测试
 */
public class MyLambda {
	public static void main(String[] args) {

		Runnable runnable = new Runnable(){
			@Override
			public void run() {
				System.out.println("run.==>Runnable");
			}
		};
		runnable.run();

		Runnable runnable1 = () -> System.out.println("main.==> lambds");
		runnable1.run();

	}


    
}
