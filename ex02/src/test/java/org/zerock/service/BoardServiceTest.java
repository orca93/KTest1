package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

@Log4j
public class BoardServiceTest {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
	//목록보기
	@Test
	public void testGetList() {
		service.getList().forEach(vo -> log.info(vo));
	}
	//글 등록
	@Test
	public void testRegister() {
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트");
		vo.setContent("테스트 내용");
		vo.setWriter("테스트 작성자");
		
		service.register(vo);
		log.info("생성된 게시물 번호: " + vo.getBno());
	}
	//글 삭제
	@Test
	public void testDelete() {
		log.info("삭제된 글의 개수: " + service.remove(11L));
	}
	//글 수정
	@Test
	public void testModify() {
		BoardVO vo = new BoardVO();
		vo.setBno(15L);
		vo.setTitle("aaa");
		vo.setContent("bbb");
		vo.setWriter("ccc");
		log.info("수정된 글의 개수: " + service.modify(vo));
	}
	//글 상세보기
	@Test
	public void testRead() {
		log.info("상세보기: " + service.get(3L));
	}

}
