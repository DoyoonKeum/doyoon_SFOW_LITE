package com.ourcom.emailEx;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@EnableAsync //를 지정해서 메서드를 호출하면 비동기적으로 동작하게끔 한다(@Asynce)을 사용할 수 있다.
public class MailController2 {
	
	
	@Autowired
	private MailService2 mailService2;

	
	@GetMapping("/sendMailForm")
	public String sendMailForm(HttpServletResponse response,HttpServletRequest request) {
		
		return "sendMailForm";
	}
	
	@PostMapping("/sendMailProc")
	public void sendMailProc(EmailDTO emailDTO,HttpServletResponse response,HttpServletRequest request) throws IOException {
		System.out.println("emailDTO안에 잘 들어갔니?"+emailDTO);
		
		PrintWriter out=response.getWriter();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		mailService2.sendMail(emailDTO);
		
		out.print("sended email.");
	}//sendMailProc()
	
	

}
