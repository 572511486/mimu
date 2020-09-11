package com.glaway.myspringboot.controller;

import com.glaway.myspringboot.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件名称:       UserController
 * 版权:          版权所有 2020-2025 南京国睿信维软件有限公司
 * 文件版本号:     V1.0
 * 作者:          ZF
 * 创建时间:      2020年08月14日16:08
 * 描述：   
 *       用户相关控制器
 */
@Api
@RestController
public class UserController {


	@ApiOperation(value = "无注解方式")
	@GetMapping("/noannotation")
	public User noAnnotation(User user){
		return user;
	}

    
}
