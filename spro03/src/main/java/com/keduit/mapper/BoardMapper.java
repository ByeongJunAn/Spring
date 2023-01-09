package com.keduit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.keduit.domain.BoardVO;

public interface BoardMapper {
	
	@Select("select sysdate from dual")
	public String getTime();
	
	
//	@Select("select * from tbl_board order by bno DESC")
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public int insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
	
}
