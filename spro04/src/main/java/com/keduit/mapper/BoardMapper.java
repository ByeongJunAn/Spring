package com.keduit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.keduit.domain.BoardVO;

public interface BoardMapper {
		
	@Select("select sysdate from dual")
	public String getTime();
	
//	@Select("select * from tbl_tododate order by bno DESC")
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
}
