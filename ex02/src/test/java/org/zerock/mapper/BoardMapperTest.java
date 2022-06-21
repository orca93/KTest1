package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class BoardMapperTest {
	
	@Autowired
	private BoardMapper mapper;

	@Test
	public void testGetList() {
		//log.info(mapper.getList());
		
/*		for(BoardVO vo : mapper.getList()) {
			log.info(vo);
		} */
		
		mapper.getList().forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testInsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("제목");
		vo.setContent("내용");
		vo.setWriter("테스트");
		
		mapper.insert(vo);
	}
	
	@Test
	public void testRead() {
		log.info("상세보기: " + mapper.read(3L));
	}
	
	@Test
	public void testDelete() {
		log.info("삭제된 글의 개수: " + mapper.delete(1L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO vo = new BoardVO();
		vo.setBno(5L);
		vo.setTitle("aaa");
		vo.setContent("bbb");
		vo.setWriter("ccc");
		log.info("수정된 글의 개수: " + mapper.update(vo));
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO vo = new BoardVO();
		vo.setTitle("제목");
		vo.setContent("내용");
		vo.setWriter("테스트");
		
		mapper.insertSelectKey(vo);
		log.info("등록된 글 번호: "+vo.getBno());
	}
	
	@Test
	public void testCount() {
		log.info("글 개수는: " + mapper.count());
	}
	
	@Test
	public void testCount1() {
		BoardVO vo = new BoardVO();
		vo.setWriter("user00");
		log.info("유저 글 개수: " + mapper.count1(vo));
	}
	
	@Test
	public void testQuiz1() {
		log.info("유저별 글 개수: " + mapper.quiz1());
	}
	
	@Test
	public void testQuiz2() {
		//log.info("제목, 작성자: " + mapper.quiz2());
		for(BoardVO vo : mapper.quiz2()) {
			log.info(vo.getTitle()+ "  "+ vo.getWriter());
		}
	}
}
