package com.ulrica.springfox.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/rest/service")
public class TestCtl {

	@RequestMapping(value="/hello.do", method={RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value="test hello world method", response = String.class, notes="测试接口")
	public String helloworld(){
		
		return "test hello";
	}
}
