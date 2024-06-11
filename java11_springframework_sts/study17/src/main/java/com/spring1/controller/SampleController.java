package com.spring1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring1.domain.Test;
import com.spring1.service.TestService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/sample/")
@Slf4j
public class SampleController {
		
	@Autowired
	private TestService testService;
	
	@GetMapping("list.do")
	public String getSampleList(Model model) {
		List<Test> list = testService.getTestList3();
		for(Test t:list) {
			log.info(t.toString());
		}
		model.addAttribute("list", list);
		return "sample/sampleList";
	}
}
