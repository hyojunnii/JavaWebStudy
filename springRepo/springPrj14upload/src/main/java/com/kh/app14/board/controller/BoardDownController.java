package com.kh.app14.board.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
public class BoardDownController {
	
	@GetMapping("down")
	public void down(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		System.out.println("서블릿 이용해서 다운로드 ~");
		
		String fileName = URLEncoder.encode("한글.png", "UTF-8");
		fileName = "\"" + fileName + "\"";
		
		resp.setHeader("Content-Type", "application/octet-stream");
		resp.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		resp.setHeader("Content-Length", "54997");
		
		String rootPath = req.getServletContext().getRealPath("/resources/upload/");
		
		File target = new File(rootPath + "img01.png");
		byte[] data = FileUtils.readFileToByteArray(target);
		
		ServletOutputStream x = resp.getOutputStream();
		x.write(data);
		
		/*
		 * Content-Type : MIME타입 설정 (==클라이언트에게 알려주는 응답할 데이터의 타입)
		 * Content-Disposition : 클라이언트에 표시되는 파일 이름
		 * Content-length : 데이터의 크기 (클라이언트측에서 다운로드 상황 파악 가능)
		 * 
		 * * 띄어쓰기가 정상적으로 인식되려면, 
		 * filename="파일명" 형태로 따옴표로 감싸져야함
		 *  
		 * 한글 등 유니코드가 정상처리되려면 다음과 같은 처리가 필요하다.
		 * URLEncoder.encode(값,"UTF-8");
		 * 위의 명령은 주소에 포함될 수 없는 형태의 글자들(%,? 등)을 가능한 형태로 변환
		 */
	}
	
	//스프링에서 권장하는 다운로드 방식 (DispatcherServlet)
	//ResponseEntity : 응답정보들이 모여있는 객체
	@GetMapping("download")
	public ResponseEntity<ByteArrayResource> download(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		//파일 객체 준비
		String rootPath = req.getServletContext().getRealPath("/resources/upload/");
		File target = new File(rootPath + "img01.png");
		
		//파일 -> 바이트 -> 리소스
		byte[] data = FileUtils.readFileToByteArray(target);
		ByteArrayResource res = new ByteArrayResource(data);
		
//		result = new ResponseEntity();
//		result.setContentType("application/octet-stream");
//		result.setContentLength(54997);
//		result.setHttpHeaders("k1", "v1");
//		result.setHttpHeaders("k2", "v2");
//		result.setBody(바이트 배열 리소스);
//		return result;
		
		
		return ResponseEntity
			.ok()
			.contentType(MediaType.APPLICATION_OCTET_STREAM)
			.contentLength(54997L)
			.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=abc.png")
			.header(HttpHeaders.CONTENT_ENCODING, "UTF-8")
			.body(res);
	}
	
}//class
