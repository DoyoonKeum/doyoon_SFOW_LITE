package com.ourcom.emailEx;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
    private JavaMailSender mailSender;
    @Autowired
    private SimpleMailMessage preConfiguredMessage;
	
	
    @Async//@Async로 지정된 메서드는 비동기적으로 동작하고 컨트롤러에 @EnableAsync가 있어야 사용가능
    //다량의 메일을 전송할 때에는 메일을 보내는 작업만 따로 수행하므로 작업 끝날 때까지 기다릴 필요가 없다
    //사용시 주의사항: 1.이비동기 어노테이션 사용시 반드시 public으로 선언해야한다
    //2. 동일 클래스에서 호출하면 안된다!
	//송신메일주소,송신메일제목,메일초간단내용
	public void sendMail(String to,String subject,String body) throws UnsupportedEncodingException {	
		MimeMessage message=mailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true,"UTF-8");
			
			//보내는 사람 email주소, 보내는 사람
			messageHelper.setFrom("doyoon718@gmail.com","금도윤 대표");
			messageHelper.setSubject(subject);//이메일 제목
			messageHelper.setTo(to);//받는 이메일주소
			messageHelper.setText(body);//메일내용
			
			mailSender.send(message);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
    
	
    @Async
    public void sendPreConfiguredMail(String message) {
      SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
      mailMessage.setText(message);
      mailSender.send(mailMessage);
      
    }
    
    
}
