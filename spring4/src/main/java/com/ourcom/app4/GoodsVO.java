package com.ourcom.app4;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/*

@NotNull //값이 안 들어오면 오류발생
@Null //값이 들어오면 오류발생
@DecimalMax(value=값,inclusive=true|false)
//지정한 값보다 작은 값을 허용 inclusive가 true이면 이하 허용/ false 미만

@DecimalMin(value=값,inclusive=true|false)
//지정한 값보다 큰 값을 허용 inclusive=true이면 이상 허용 /false 초과
 
@Digits(integer=정수의 자릿수, fraction=실수의 자릿수)
 지정한 자릿수의 숫자가 아니면 오류발생
 
@AssertTrue : true가 아니면 오류발생
@AssertFalse : false가 아니면 오류발생

@Pattern(regexp=정규식) : 지정한 정규식에 위배되면 오류발생
 

*/


//Domain클래스
public class GoodsVO {
	
	//@Min(1)//지정값보다 작은 값이 들어오면 오류발생
	//@Max(10)//지정값보다 큰 값이 들어오면 오류발생
	
	@NotNull//값이 들어오지 않으면 오류발생
	@Size(min=1,max=10,message="1~10글자 사이로 입력해주세요.")
	private String goods_title;
	
	@Min(value=0,message="양수로 입력해주세요")
	private int goods_price;
	
	@NotNull
	@Digits(integer=8,fraction=2)
	private double unitPrice;
	
	@Pattern(regexp="ISBN[0-9]{3,}")//정규표현식 regexp 잘 이용할 것
	private String isbn;
	
	//기본생성자
	public GoodsVO() {
		
	}
	public GoodsVO(String goods_title, int goods_price) {
		this.goods_title = goods_title;
		this.goods_price = goods_price;
	}
	public String getGoods_title() {
		return goods_title;
	}
	public void setGoods_title(String goods_title) {
		this.goods_title = goods_title;
	}
	public int getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}
	
	public double getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return "GoodsVO goods_title=" + goods_title + ", goods_price=" + goods_price;
	}
	
}
