package com.keduit.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.keduit.domain.BoardVO;
import com.keduit.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Autowired
	private BoardService service;

	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("test register에서 등록한 글");
		board.setContent("test register에서 등록한 글 내용");
		board.setWriter("tester1");
		
		long bno = service.register(board);
		log.info("생성된 게시물 번호 ======>" + bno);
	
	}
	
	@Test
	public void testGetList() {
//		service.getList().forEach(board->log.info(board));
		service.getList(new Criteria(5,10))
			   .forEach(board -> log.info(board));
	}
	
	
	@Test
	public void testGet() {
		log.info(service.get(22L));
		
	}
	
	@Test
	public void testUpdate() {
		BoardVO  board = service.get(22L);
		
		if(board == null) {
			return;
		}
		
		board.setTitle("modify한 제목임...");
		log.info("Modify result =====> " + service.modify(board));
	}
	
	
	@Test
	public void testDelete() {
		log.info("Remove result : " + service.remove(2L)  );
	}
	
}
