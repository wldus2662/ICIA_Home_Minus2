package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.ProductDto;
import com.service.ProductService;

@WebServlet({"/datainput", "/dataoutput", "/deletePro", "/datasearch","/dataupdate","/updateproc"})
public class ProductController extends HttpServlet{
	ProductService pService = new ProductService();
	HttpSession session;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}

	private void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(session == null) {
			session = request.getSession();
		}

		String command = request.getServletPath();
		System.out.println("요청 : " + command);


		String result = null;
		RequestDispatcher rd = null;
		ProductDto ps = null;
		String code = null;

		switch(command) {
		case "/datainput"://데이터 입력
			ProductDto pd = (ProductDto)request.getAttribute("pd");
			result = insertData(pd);
			session.setAttribute("msg", result);
			response.sendRedirect("./");
			break;
		case "/dataoutput":
			List<ProductDto> pList = selectData();
			request.setAttribute("pList", pList);
			rd = request.getRequestDispatcher("./outputList.jsp");
			rd.forward(request, response);
			break;
		case "/deletePro" ://데이터 삭제			
			code = request.getParameter("p_code");
			result = deletepro(code);
			session.setAttribute("msg", result);
			response.sendRedirect("./");
			break;
		case "/datasearch": //데이터검색
			code = request.getParameter("p_code");
			ps = productSearch(code);
			request.setAttribute("resData", ps);
			rd = request.getRequestDispatcher("./outputData.jsp");
			rd.forward(request, response);
			break;
		case "/dataupdate"://데이터 수정
			//화면에 수정할 데이터를 보여주는 부분
			code = request.getParameter("p_code"); 
			System.out.println("검색 코드 : " + code);
			ps = updateData(code);
			request.setAttribute("upData", ps);
			rd = request.getRequestDispatcher("./updateFrm.jsp");
			rd.forward(request, response);
			break;
		case "/updateproc"://데이터 수정 처리
			//수정 화면에서 수정된 데이터를 DB에 처리하는 부분
			pd = (ProductDto)request.getAttribute("pd");
			result = updateProc(pd);
			session.setAttribute("msg", result);
			response.sendRedirect("./");			
			break;	
		}
		
	}
	private ProductDto productSearch(String code) {
		ProductDto pd = pService.productInfo(code);
		return pd;
	}
	private List<ProductDto> selectData() {
		List<ProductDto> pList = pService.getList();
		return pList;
	}

	private String insertData(ProductDto pd) {
		String result = pService.regProduct(pd);
		return result;
	}
	private String deletepro(String code) {
		String result = pService.deletepro(code);
		
		return result;
	}
	private ProductDto updateData(String code) {
		ProductDto pd = pService.productInfo(code);
		return pd;
	}
	private String updateProc(ProductDto pd) {
		String result = pService.updatepro(pd);

		return result;
	}
}
