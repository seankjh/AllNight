package edu.spring.ex02.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.ex02.domain.MemberVO;
import edu.spring.ex02.domain.PostVO;
import edu.spring.ex02.service.MemberService;
/*
 * @Component는 어떤 스프링이 관리하는 컴포넌트를 나타내는 일반적인 스테레오 타입이다._[상위개념]
 * @Component의 구체화된 형태로 @Repository, @Service,  @Controller들이 있다._[하위개념]
 *  컴포넌트 클래스들에 @Component를 붙일 수 있지만, @Repository, @Service, @Controller를 붙인다면
 *    도구들이 클래스들을 처리하는데 더 적합하도록 할 수 있고 관점(aspects)에 더 연관성을 부여할 수 있다.
 */
//@Component
@Controller // 스프링 프레임워크가 Controller(Servlet) 빈으로 관리
// -> servlet-context.xml에서 bean 등록(context:component-scan)
@RequestMapping(value="/member") // 클래스 안의 모든 메소드의 공통 URL
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// MemberService 객체를 주입 받음
	@Autowired
	private MemberService memberService;
	
	// ex02/member/ 요청을 처리하는 메소드
	// -> DB에 회원 전체 검색을 해서 결과를 JSP로 보여줌
	@RequestMapping(value="/list", method=RequestMethod.GET) // value 이름에 .jsp 붙여서 찾는다. //servlet-context.xml
	// 클라이언트가 member라고 보낸 요청을 처리. 
	public void listAllMembersGET(Model model) {
		logger.info("listAllMembersGET() 호출...");
		
		List<MemberVO> list = memberService.read();
		model.addAttribute("memberList", list);
		// -> Model 객체가 View(JSP)까지 전달
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registerGET() {
		logger.info("registerGET() 호출...");
	}
	
	@RequestMapping(value="/registerpost", method=RequestMethod.GET)
	public void registerpostGET(){
		logger.info("registerPOST() 호출...");
	}
	
	@RequestMapping(value="address", method=RequestMethod.POST)
	public String resultaddress(Model model, PostVO vo){
		logger.info("우편번호 : "+vo.getPostcode());
		logger.info("지번주소 : "+vo.getJibunaddress());
		logger.info("도로명주소 : "+vo.getRoadaddress());
		logger.info("상세 주소 : "+vo.getDetailaddress());
		model.addAttribute("address", vo);
		return "resultaddress";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPOST(MemberVO vo, RedirectAttributes attr) { // 매개변수 - get해서 set이 바로된다.(Getter/Setter가 작동될 수 있도록 name이 필드와 같아야한다.)
		logger.info("registerPOST() 호출...");
		logger.info("아이디: " + vo.getUserid());
		logger.info("비밀번호: " + vo.getPassword());
		logger.info("이메일: " + vo.getEmail());
		
		int result = memberService.create(vo);// 진짜 심플하네
		// 리다이렉트하는 페이지에 추가 정보를 보내고 싶을 때
		// RedirectAttributes 객체에 속성을 추가하면 됨
		//	- addAttribute() : URL 주소 뒤에 쿼리 스트링으로 데이터를 전달
		//	- addFlashAttribute() : HTTP 응답 패킷에 데이터를 포함해서 전달
		if (result == 1) { // DB insert 성공
			attr.addFlashAttribute("insert_result", "success");
		} else { // DB insert 실패
			attr.addFlashAttribute("insert_result", "fail");
			// 사용자가 그냥 주소줄의 쿼리스트링에서 성공여부를 확인하기 위하여
		}
		return "redirect:/member/list";
	}
	
/*	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public void detail(@ModelAttribute("userid") String id, Model model) {
		// 요청 파라미터로 전달된 userid를 사용해서, DB검색 후
		// 회원 1명의 정보를 수정할 수 있는 페이지를 보여줌
		logger.info("detail() 호출...");
		MemberVO vo = memberService.read(id);
		logger.info("아이디: " + vo.getUserid());
		logger.info("비밀번호: " + vo.getpassword());
		logger.info("이메일: " + vo.getEmail());
		
		model.addAttribute("member", vo);
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.POST) // value 이름에 .jsp 붙여서 찾는다. //servlet-context.xml
	// 클라이언트가 member라고 보낸 요청을 처리. 
	public String listAllMembersPOST(MemberVO vo, RedirectAttributes attr) {
		logger.info("listAllMembersPOST() 호출...");
		logger.info("아이디: " + vo.getUserid());
		logger.info("비밀번호: " + vo.getpassword());
		logger.info("이메일: " + vo.getEmail());
		
		int result = memberService.update(vo);
		logger.info("Update 결과: " + result);
		// -> Model 객체가 View(JSP)까지 전달
		if (result == 1) { // DB insert 성공
			attr.addFlashAttribute("update_result", "success");
		} else { // DB insert 실패
			attr.addFlashAttribute("update_result", "fail");
			// 사용자가 그냥 주소줄의 쿼리스트링에서 성공여부를 확인하기 위하여
		}
		return "redirect:/member/list";
	}*/
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public void detail(String userid, Model model) {
		// 요청 파라미터로 전달된 userid를 사용해서, DB 검색 후
		// 회원 1명의 정보를 수정할 수 있는 페이지를 보여줌
		logger.info("detail() 호출: userid = " + userid);
		
		MemberVO vo = memberService.read(userid);
		model.addAttribute("vo", vo);
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(MemberVO vo, RedirectAttributes attr) {
		logger.info("update() 호출: userid = " + vo.getUserid());
		
		int result = memberService.update(vo);
		if (result == 1) { // 업데이트 성공
			attr.addFlashAttribute("update_result", "success");
		} else { // 업데이트 실패
			attr.addFlashAttribute("update_result", "fail");
		}
		attr.addFlashAttribute("userid", vo.getUserid());
		
		return "redirect:list";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String delete(String userid, RedirectAttributes attr) {
		logger.info("delete() 호출 userid = " + userid);
		int result = memberService.delete(userid);
		if (result == 1) {
			attr.addFlashAttribute("delete_result", "success");
		} else {
			attr.addFlashAttribute("delete_result", "fail");
		}
		attr.addFlashAttribute("userid", userid);
		return "redirect:list";
	}
} // end class MemberController
























