package com.dto;

public class ProductDto {
	
	private String p_code;
	private String p_name;
	private int p_price;
	private String p_type;
	private int p_amount;
	
	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getP_type() {
		return p_type;
	}

	public void setP_type(String p_type) {
		this.p_type = p_type;
	}

	public int getP_amount() {
		return p_amount;
	}

	public void setP_amount(int p_amount) {
		this.p_amount = p_amount;
	}

	
	@Override
	public String toString() {
		String str = "제품코드 : " + p_code + "\n"
				+ "제품명 : " + p_name + "\n"
				+ "가격 : " + p_price + "원\n"
				+ "제품 유형 : " + p_type + "\n"
				+ "수량 : " + p_amount + "개";				
		return str;
	}

}
