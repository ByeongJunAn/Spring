package com.keduit.service;

import java.util.List;

import com.keduit.domain.Criteria;
import com.keduit.domain.ReplyPageDTO;
import com.keduit.domain.ReplyVO;

public interface ReplyService {
	
	public List<ReplyVO> getList (Criteria cri, Long bno);
	
	public ReplyVO get(Long rno);
	
	public int register(ReplyVO vo);
	
	public int modify(ReplyVO vo); 
	
	public int remove(Long rno);
	
	public ReplyPageDTO getListPage(Criteria cri, Long bno);
}
