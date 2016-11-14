package edu.spring.ex02.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String openDetailUpload() {
		logger.info("uploadJSP불러오는 Controller 실행");
		return "/upload/upload";
	}

	@RequestMapping(value = "test", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam(value="name") String name, 
			@RequestParam(value="file") MultipartFile file){
		logger.info("mainUploadController 실행");
		logger.info("파일명: "+name);
		
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				System.getProperty("catalina.home");
				File dir = new File(
						"C:" + File.separator + "Study" + File.separator + "lab-web" + File.separator + "PdetailImage");
				if (!dir.exists())
					dir.mkdirs();

				File serverFile = new File(dir.getAbsolutePath() + File.separator + file);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("이미지 서버 주소 : " + serverFile.getAbsolutePath());

				return name + "의 업로드가 성공했습니다";

			} catch (Exception e) {
				return "파일 업로드 실패.. " + name + " => " + e.getMessage();
			}
		} else {
			return "파일 업로드 실패 : " + name;
		}
	}

}
