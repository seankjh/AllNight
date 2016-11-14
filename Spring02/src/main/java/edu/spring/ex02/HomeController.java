package edu.spring.ex02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String sample(){
		return "main";
	}

		@RequestMapping(value="check", method=RequestMethod.GET)
		public void openEmail(Model model) {
			
		}
		
		@RequestMapping(value="register", method=RequestMethod.GET)
		public String openIndex(Model model){
			return "register_bootstrap";
		}
		@RequestMapping(value="check", method=RequestMethod.POST)
		public String checkEmail(Model model, String email) {
			int code = (int) (Math.random()*10000);
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(email);
			logger.info("메일 주소 : "+email);
			message.setSubject("쇼핑몰 인증번호");
			message.setText("인증번호: "+code);
			logger.info("보낸 코드 : "+code);
			mailSender.send(message);
			model.addAttribute("code", code);
			return "result";	
		}

//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		

	
}
