package edu.spring.ex02.domain;

import org.springframework.web.multipart.MultipartFile;

public class FileVO {
	public FileVO(){};
	String name;
	MultipartFile file;
	
	public FileVO(String name, MultipartFile file){
		this.name=name;
		this.file=file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	
}
