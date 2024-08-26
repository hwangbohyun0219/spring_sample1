package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test1.mapper.StudentMapper;
import com.example.test1.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentMapper studentMapper;
	
	@Override
	public List<Student> searchStudentList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return studentMapper.selectStudentList();
	}

	@Override
	public Student searchQwer() {
		// TODO Auto-generated method stub
		Student s = studentMapper.qwer();
		return s;
	}
	
	@Override
	public HashMap<String, Object>  searchSubject() {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap
		 = new HashMap<String, Object>();
		List<Student> subject = studentMapper.selectSubject();
		List<Student> student = studentMapper.selectStudentList();
		
		resultMap.put("subList", subject);
		resultMap.put("stuList", student);
		
		return resultMap;
	}
	
	
	

	@Override
	public HashMap<String, Object> searchStu(HashMap<String, Object> map) {

		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			// db 호출 데이터,
			// 결과(성공, 실패), 메시지(성공메시지, 오류메시지)
			Student s = studentMapper.selectStu(map);
			resultMap.put("stu", s);
			resultMap.put("result", "success");
			resultMap.put("message", "조회했습니다");
			String msg = s!= null ? "조회했습니다" : "학번을 확인해주세요";
			resultMap.put("message",msg);
		} catch(Exception e) {
			resultMap.put("result", "fail");
			resultMap.put("Message", "db 조회 오류");
		}
		return resultMap;
	}

}







