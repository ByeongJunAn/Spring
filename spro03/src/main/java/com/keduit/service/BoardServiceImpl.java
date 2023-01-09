package com.keduit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.keduit.domain.BoardVO;
import com.keduit.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;


@Log4j
@Service
@ToString
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardMapper mapper;
	
	@Override
	public Long register(BoardVO board) {
		log.info("------- register ------" + board );
		
		
		int result = mapper.insertSelectKey(board);
		log.info("---------게시물 등록 상태 :" + result);
		
		return (board.getBno());
	}

	@Override
	public BoardVO get(Long bno) { //하나 읽어오기
		log.info("---------get---------" + bno);
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) { // 수정
		log.info("modify...... " + board);
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) { // 삭제
		log.info("----- remove : " + bno);
		
		return mapper.delete(bno) == 1 ;
	}

	@Override
	public List<BoardVO> getList() {
		log.info("getList..........." );
		
		return mapper.getList();
	}

}
