package com.keduit.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.keduit.domain.BoardVO;
import com.keduit.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Test
	public void testGetTime() {
		log.info(mapper.getClass().getName());
		log.info(mapper.getTime());
	}

	@Test
	public void testGetList() {
//		mapper.getList().forEach(board -> log.info(board));
		mapper.getListWithPaging(new Criteria(5, 10))
			   .forEach(board -> log.info(board));
	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		cri.setPageNum(5);
		cri.setAmount(10);
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}

	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("test 작성 글 ");
		board.setContent("test작성글 내용");
		board.setWriter("user09");

		mapper.insert(board);

		log.info("------testInsert()-----" + board);

	}

	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글 select key test");
		board.setContent("새로 작성하는 글 sodyd select key test");
		board.setWriter("user99");

		mapper.insertSelectKey(board);

		log.info("-----------testInsertSelectKey---------" + board);
	}

	@Test
	public void testRead() {
		BoardVO board = new BoardVO();
		board = mapper.read(22L);
		log.info("-----------test Read---------" + board);
	}

	@Test
	public void testDelete() {
		int result = mapper.delete(4L);
		log.info("delete....");

	}

	@Test
	public void TestUpdate() {
		BoardVO board = new BoardVO();
		board.setTitle("수정된 제목 :   +TestUpdate");
		board.setContent("수정된 내용 :  + Testcontent");
		board.setWriter("tester00");
		board.setBno(3L);

		int result = mapper.update(board);

	}
	
	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("테스트");
		cri.setType("TC");
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
	

}
