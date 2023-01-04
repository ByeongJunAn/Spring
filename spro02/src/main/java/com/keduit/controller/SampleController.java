package com.keduit.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.keduit.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*") //주소의 /sample/다음에 오는 모든 것들은 아래의 클래스를 실행한다.
@Log4j
public class SampleController {
	@RequestMapping("") // /sample/다음에 아무것도 안넣었을때
	public void basic() {
		log.info("basic---------------");	
	}
	
	@RequestMapping(value="/basic", method= {RequestMethod.GET,
			RequestMethod.POST})// /sample/ 다음에 basic이 올때
	public void basicGet() {
		log.info("basic get...........");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("dto..........." + dto);
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, 
					   @RequestParam("age") int age) {
		log.info("name : " + name );
		log.info("age : " + age);
		
		return "ex02";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids : " + ids);
		return "ex02List";
		
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("array ids : " + Arrays.toString(ids));
		return "ex02Array";
	}
	
	
	
}
