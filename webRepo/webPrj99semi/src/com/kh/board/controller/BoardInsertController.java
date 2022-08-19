package com.kh.board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.kh.attachment.vo.AttachmentVo;
import com.kh.board.service.BoardService;
import com.kh.board.vo.BoardVo;
import com.kh.category.vo.CategoryVo;
import com.kh.member.vo.MemberVo;

@MultipartConfig(
		//fileSizeThreshold = 1024 * 1024,
		//location = "/swy/temp",
		maxFileSize = 1024 * 1024 * 50, //50mb
		maxRequestSize = 1024 * 1024 * 50 * 5
		)
@WebServlet(urlPatterns = "/board/insert")
public class BoardInsertController extends HttpServlet{
	
	//일반 게시글 작성 화면 보여주기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//카테고리 정보 조회해서 전달
		List<CategoryVo> list = new BoardService().selectCategoryList();
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/views/board/boardEnrollForm.jsp").forward(req, resp);
	}
	
	//게시글 작성 (파일첨부)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String category = (String)req.getParameter("category");
		String title = (String)req.getParameter("title");
		String content = (String)req.getParameter("content");
		Part f = req.getPart("f");
		
		MemberVo m = (MemberVo)req.getSession().getAttribute("loginMember");
		
		BoardVo bvo = new BoardVo();
		bvo.setCategory(category);
		bvo.setTitle(title);
		bvo.setContent(content);
		bvo.setWriter(String.valueOf(m.getNo()));
		
		AttachmentVo avo = null;
		String savePath = "";
		//제출된 파일 있는 경우
		if(f.getSubmittedFileName().length() > 0) {
			//파일 업로드
			String originName = f.getSubmittedFileName();	//원본 파일명 얻기
			String changeName = new BoardService().createChangeName(originName);
			
			//인풋 스트림 준비
			InputStream is = f.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			
			//아웃풋 스트림 준비 (서버에 저장)
			String realPath = req.getServletContext().getRealPath("/resources/upload");
			savePath = realPath + File.separator + changeName;
			FileOutputStream os = new FileOutputStream(savePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			//실제 파일 업로드
			//(느린방식)
//			int data = 0;
//			while((data = is.read()) != -1) {
//				os.write(data);
//			}
			
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = bis.read(buf)) != -1) {
				bos.write(buf, 0, size);
			}
			
			bos.flush();
			bis.close();
			bos.close();
			
			//준비한 Attachment 테이블 관련 데이터(원본파일명, 변경파일명, 경로) 객체로 뭉치기
			avo = new AttachmentVo();
			avo.setOriginName(originName);
			avo.setChangeName(changeName);
			avo.setFilePath(realPath);
		}
		
		//Board 테이블 채우기(insert)
		int result = new BoardService().insertBoard(bvo, avo);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "게시글 작성 성공");
			resp.sendRedirect("/semi/board/list?p=1");
		} else {
			//첨부파일이 있었다면 파일 삭제해야함
			if(avo != null) {
				new File(savePath).delete();
			}
			req.setAttribute("errorMsg", "게시글 작성 실패");
			req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
		}
		
	}
	
}
