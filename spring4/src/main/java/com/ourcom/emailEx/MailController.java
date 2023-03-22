package com.ourcom.emailEx;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
@EnableAsync //를 지정해서 메서드를 호출하면 비동기적으로 동작하게끔 한다(@Asynce)을 사용할 수 있다.
public class MailController {
	
	@Autowired
	private MailService mailService;
	
	
	@GetMapping("/sendMail")
	public void sendSimpleMail(HttpServletResponse response,HttpServletRequest request) throws IOException {
		PrintWriter out=response.getWriter();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		mailService.sendMail("doyoon718@naver.com","test메일","GoodMorning~ 테스트용 메일입니당");//송신메일주소,송신메일제목,메일초간단내용
		
		mailService.sendPreConfiguredMail("test mail 정기적 메일내용!");
		out.print("이메일 전송완료");
		
		
		
	}//sendSimpleMail()끝
	
	
	
	
	

}
