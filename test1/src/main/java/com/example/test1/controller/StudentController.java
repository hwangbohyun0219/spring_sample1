package com.example.test1.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test1.dao.StudentService;
import com.example.test1.model.Student;
import com.google.gson.Gson;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/test.do")
	public String main(Model model) throws Exception {

		return "/test";
	}

	@RequestMapping("/student.do")
	public String main1(Model model) throws Exception {

		return "/student-list";
	}
	
	@RequestMapping("/subject.do")
	public String subject(Model model) throws Exception {

		return "/subject-list";
	}
	
	

	@RequestMapping(value = "/list.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String searchBbsList(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		List<Student> list = studentService.searchStudentList(map);
		resultMap.put("list", list);
		resultMap.put("result", "success");
		return new Gson().toJson(resultMap);
	}

	@RequestMapping(value = "/ok.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String qwer(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		Student stu = studentService.searchQwer();
		resultMap.put("stu", stu);
		resultMap.put("result", "success");
		// {stu : stuNo:1234567, stuName:옥한빛...}
		// result:success
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping(value = "/search.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String search(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		System.out.println(map);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		resultMap = studentService.searchStu(map);
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping(value = "/sub_list.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String sub_list(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap = studentService.searchSubject();
		
		return new Gson().toJson(resultMap);
	}
	
	

}


