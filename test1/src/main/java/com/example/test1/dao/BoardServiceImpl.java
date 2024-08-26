package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test1.mapper.BoardMapper;
import com.example.test1.model.Board;
import com.example.test1.model.Student;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public HashMap<String, Object> searchBoardList(HashMap<String, Object> map) {
	
		HashMap<String, Object> resultMap = 
				new HashMap<String, Object>();
		List<Board> list = boardMapper.selectBoardList(map);
		resultMap.put("list", list);
		
		return resultMap;
		
	}
		
}