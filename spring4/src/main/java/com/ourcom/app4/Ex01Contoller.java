package com.ourcom.app4;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Ex01Contoller {
	
	//폼 (ex01.jsp문서)을 보여줘
	//get방식
	@GetMapping("/ex01")
	public String ex01(@ModelAttribute("goodsVO")GoodsVO goodsVO) {
	///요청주소~커페/
	return "ex01";
	}
	
	@PostMapping("/ex01")
	public String submit(@Valid @ModelAttribute("goodsVO")GoodsVO goodsVO
						 ,Errors errors) {
		System.out.println("goodsVO"+goodsVO);
		if(errors.hasErrors()) {
		//유효한 데이터가 아닐 경우 >>>왔던 페이지로 이동 ex01.jsp
			return "ex01";
		}else{
		
		//유효한 데이터로 통과가 되면 이동하는 page >> result
			return "result";
	
	}//submit() 끝
	

	}
}