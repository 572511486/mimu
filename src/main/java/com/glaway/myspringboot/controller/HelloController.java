package com.glaway.myspringboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件名称:       HelloController
 * 版权:          版权所有 2020-2025 南京国睿信维软件有限公司
 * 文件版本号:     V1.0
 * 作者:          ZF
 * 创建时间:      2020年08月06日17:55
 * 描述：
 *
 */
@Api
@RestController
public class HelloController {

	@ApiOperation("Hello Spring boot 方法")
	@GetMapping("/")
	public String hello(@RequestParam(required = false) @ApiParam("名字") String name){
		if(name != null && name.length() > 0){
			return "hello" + name;
		}
		return "test hello11";
	}
}
