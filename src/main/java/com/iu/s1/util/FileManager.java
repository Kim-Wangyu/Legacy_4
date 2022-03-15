package com.iu.s1.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	@Autowired
	private ServletContext servletContext;   //내장객체
	
	
	public boolean remove(String path, String fileName)throws Exception{
		//파일을 HDD에서 삭제
		//저장된 폴더명, 저장된 파일명 
		path = servletContext.getRealPath(path);  //실제경로를 받아옴
		
		File file = new File(path, fileName);
		
		return file.delete();
		
	}

	public String save(MultipartFile multipartFile, String path)throws Exception{  //path 를service qna랑 notice한테서 받아옴,경로받아옴 변수로써야되니까
		//파일 저장은 tomcat이 아니라 OS에서 저장
		//1. 어디에 저장?? //path=/resources/upload/member
		String realPath=servletContext.getRealPath(path);
		System.out.println(realPath);
		
		File file= new File(realPath);
		
		if(!file.exists()) {
			//file.mkdir(); //중간 폴더가 없으면 에러
			file.mkdirs(); //중간폴더가 없으면 중간폴더도 생성해줌,그래서 더 안전함
			
		}
		//1. 시간
		Calendar ca = Calendar.getInstance();
		long l = ca.getTimeInMillis(); //현재시간을 밀리세컨으로 변환, 중복될일 X
		System.out.println("time : "+l);
		String oriName= multipartFile.getOriginalFilename(); //iu.jfif가 나올것 파일명
		String fileName = l +"_"+oriName;
		System.out.println("fileName : "+fileName);
		
		//2. UUID
		fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+oriName;
		System.out.println("UUID : " +fileName);
		
		//file HDD에 저장
		//1. MultipartFile 클래스의 transferTo 메서드 사용
//		file =new File(file,fileName);
//		multipartFile.transferTo(file);
		
		//2. FileCopyUtils
		file = new File(file,fileName);
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		return fileName;
	}
}
