package edu.spring.ex02.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.ex02.domain.ReplyVO;
import edu.spring.ex02.service.ReplyService;

// REST API(URL 매핑)
// ex03/replies (POST): createReply()
//	댓글을 DB에 저장
// ex03/replies/all/번호 (GET): readReplies()
//	해당 번호의 게시글의 모든 댓글을 리턴
// ex03/replies/번호 (PUT): updateReply()
//	해당 번호의 댓글의 내용을 수정
// ex03/replies/번호 (DELETE): deleteReply()
//	해당 번호의 댓글을 삭제

@RestController
@RequestMapping(value="/board/detail")
public class ReplyRESTController {
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyRESTController.class);
	
	@Autowired
	private ReplyService service;
	
	// 댓글 등록 콘트롤러 메소드
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Integer> createReply(
			@RequestBody ReplyVO vo) {
		// ResponseEntity 클래스:
		//  응답(response)와 함께 HTTP 결과 코드도 지정해서 보내줄 수 있는 클래스
		// @RequestBody:
		//	요청 본체(request body) 안에 포함된 JSON 객체를
		//	선언된 클래스 타입으로 변환하겠다는 어노테이션
		
		logger.info("createReply() 호출...");
		logger.info("bno: " + vo.getBno());
		logger.info("rtext: " + vo.getRtext());
		logger.info("replier: " + vo.getReplier());
		
		ResponseEntity<Integer> entity = null;
		int result = service.create(vo);
		if (result == 1) { // DB insert 성공
			entity = new ResponseEntity<Integer>(1, HttpStatus.OK);
		} else { // DB insert 실패
			entity = new ResponseEntity<Integer>(0, HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	} // end createReply()
	
	// 해당 게시글의 모든 댓글 목록을 읽어오는 메소드
	@RequestMapping(value="/all/{no}", method=RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> readReplies(
			@PathVariable("no") Integer bno) {
		logger.info("readReplies() bno=" + bno);
		
		List<ReplyVO> list = service.read(bno);
		
		ResponseEntity<List<ReplyVO>> entity = null;
		if (list != null) { // select 성공
			entity = new ResponseEntity<>(list, HttpStatus.OK);
		} else { // select 실패
			entity = new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	// 해당 rno 댓글을 수정
	@RequestMapping(value="/{no}", method=RequestMethod.PUT)
	public ResponseEntity<String> updateReply(
			@PathVariable("no") Integer rno, 
			@RequestBody ReplyVO vo) {
		ResponseEntity<String> entity = null;
		
		vo.setRno(rno);
		int result = service.update(vo);
		if (result == 1) { // update 성공
			entity = new ResponseEntity<>("success", HttpStatus.OK);
		} else { // update 실패
			entity = new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/{no}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteReply(
			@PathVariable("no") Integer rno) {
		ResponseEntity<String> entity = null;
		
		logger.info("deleteReply(): rno=" + rno);
		
		int result = service.delete(rno);
		if (result == 1) { // delete 성공
			entity = new ResponseEntity<>("success", HttpStatus.OK);
		} else { // delete 실패
			entity = new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
} // end class ReplyRESTController

























