package edu.spring.ex02.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageMaker;
import edu.spring.ex02.pageutil.PaginationCriteria;
import edu.spring.ex02.service.BoardService;

@Controller // 스프링 프레임워크에 Controller bean 객체로 등록
@RequestMapping(value="/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	@RequestMapping(value="/list", method=RequestMethod.GET)// /board 아래쪽의 list
	public void list(Model model) {
		// 게시글 전체 목록
		List<BoardVO> list = boardService.read();
		// 게시글 목록을 Model 객체에 넣어서 View(JSP)에 전달
		model.addAttribute("boardList", list); // list.jsp 에서 boardList[EL]로 list를 받는다.
	}
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public void registerGET() {
		
	}
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String registerPOST(BoardVO vo, RedirectAttributes attr) {
		// 서비스 객체를 사용해서 DB insert
		int result = boardService.create(vo);
		
		if (result == 1) {
			attr.addFlashAttribute("insert_result", "success");
		} else {
			attr.addFlashAttribute("insert_result", "fail");
		}
		
		/*return "redirect:list";*/
		return "redirect:list-page";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public void detail(int bno, 
			@ModelAttribute("page")	int page, Model model) {
		// 
		BoardVO vo = boardService.read(bno);
		model.addAttribute("boardVO", vo);
		//model.addAttribute("page", page);
		// 컨트롤러 메소드의 매개변수를 선언할 때
		// @ModelAttribute 어노테이션을 사용하면,
		// 요청 파라미터로 받은 변수를 Model 객체에 속성(Attr)에 자동으로 추가해서
		// View(JSP)까지 전달하게 됨
		// -> model.addAttribute() 코드를 생략할 수 있다.
	}
	
/////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="update", method=RequestMethod.GET)
	public void update(int bno,
			@ModelAttribute("page") int page, Model model) {
		logger.info("updateGET(): bno = " + bno);
		
		// 해당 글 번호의 상세 검색
		BoardVO vo = boardService.read(bno);
		
		// DB에서 검색한 내용을 Model 객체에 attribute로 추가
		model.addAttribute("boardVO", vo);
		
		
	}
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String updatePOST(BoardVO vo, 
			int page, RedirectAttributes attr) {
		// regdate를 보내면 문제가 생긴다.
		
		logger.info("updatePOST(): bno = " + vo.getBno());
		int result = boardService.update(vo);
		if (result == 1) {
			attr.addFlashAttribute("update_result", "success");
		} else { 
			attr.addFlashAttribute("update_result", "fail");
		}
		attr.addFlashAttribute("bno", vo.getBno());
		return "redirect:list-page?page="+page;
		// 없데이트 성공/실패 후 list로 Redirect 
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String deletePOST(int bno, int page, RedirectAttributes attr) {
		// String 한 이유는 리스트로 리다이렉트 할것이기 때문
		logger.info("delete() 호출: bno = " + bno);
		int result = boardService.delete(bno);
		if (result == 1) {
			attr.addFlashAttribute("delete_result", "success");
		} else {
			attr.addFlashAttribute("delete_result", "fail");
		}
		attr.addFlashAttribute("bno", bno);
		
		return "redirect:list-page?page="+page;
	}
	
	
	// 해당 페이지 번호의 게시글만 보여주는 콘트롤러 메소드
	@RequestMapping(value="list-page", method=RequestMethod.GET)
	public void listPage(Integer page, Model model) {
		logger.info("list-page() 호출: page = " + page);
		
		PaginationCriteria c = new PaginationCriteria();
		if (page != null) { // 요청 파리미터에 현재 페이지 정보가 있는 경우
			c.setPage(page);
		}
		
		// 해당 페이지에 보여줄 게시글만 검색
		List<BoardVO> list = boardService.read(c);
		model.addAttribute("boardList", list); // jsp EL에 맞춰서
		
		// 페이지의 링크를 어떻게 표현할 지
		PageMaker maker = new PageMaker();
		maker.setCriteria(c);
		
		maker.setTotalCount(boardService.getNumOfRecords()); //
		maker.setPageData();// 순서가 바뀌면 안된다.// TotalCount변수를 사용하고 있기 때문
		
		model.addAttribute("pageMaker", maker);
		
	}
	
} // end class BoardController
































