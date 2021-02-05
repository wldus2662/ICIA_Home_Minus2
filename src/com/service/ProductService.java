package com.service;

import java.util.List;

import com.dao.ProductDao;
import com.dao.ProductDaoImpl;
import com.dto.ProductDto;

public class ProductService {
	ProductDao pDao = new ProductDaoImpl();

	//상품 추가 등록 메소드
	public String regProduct(ProductDto product) {
		String message = null;
		int result = pDao.insertProduct(product);

		if(result > 0) {
			message = "입력 성공";
		}
		else {
			message = "입력 실패";
		}
		return message;
	}//regProduct end

	//전체 상품 정보 조회 메소드	
	public List<ProductDto> getList() {
		List<ProductDto> pList = pDao.selectList();
		return pList;			
	}//productList end

	//특정 상품 정보 조회 메소드
	public ProductDto productInfo(String pid) {
		ProductDto product = null;
		product = pDao.selectInfo(pid);
		return product;
	}//productInfo end

	//상품 수정 메소드
	public String updatepro(ProductDto product) {
		String message = null;

		int result = pDao.updateProduct(product);

		if(result > 0) {
			message = "수정 성공";
		}
		else {
			message = "수정 실패";
		}

		return message;
	}

	//상품 삭제 메소드
	public String deletepro(String code) {
		String message = null;

		int result = pDao.deletePro(code);

		if(result > 0) {
			message = "삭제 성공";
		}
		else {
			message = "삭제 실패";
		}

		return message;
	}


}//class end
