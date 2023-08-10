package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.model.Student;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
	@GetMapping(value = "/index")
	private String index(Model model) {
		model.addAttribute("form",new Student());
		model.addAttribute("",null);
		return "student/index";
	}

	
}
