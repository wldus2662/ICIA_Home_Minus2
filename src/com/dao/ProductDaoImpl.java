package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.ProductDto;

public class ProductDaoImpl implements ProductDao {	

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "DEV";
	private String password = "1234";

	Connection conn = null;//데이터베이스와 연결하는 객체
	PreparedStatement pstmt = null;
	ResultSet rs = null; //select 할때만 필요하다.

	public ProductDaoImpl() {		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("드라이버 로드 실패");
		}		
	}

	//상품 등록 INSERT 메소드
	@Override
	public int insertProduct(ProductDto product) {
		int result = 0;
		String query = "INSERT INTO PT VALUES (?, ?, ?, ?, ?)";  // oracle의 insert를 가져오기 위한 문장
		try {
			conn = DriverManager.getConnection(url, user, password); 
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, product.getP_code());//product에서의 값을 가져와서 setString 한다.
			pstmt.setString(2, product.getP_name());
			pstmt.setInt(3, product.getP_price());			
			pstmt.setString(4, product.getP_type());			
			pstmt.setInt(5, product.getP_amount());

			result = pstmt.executeUpdate();
			conn.commit();			
		} catch (SQLException e) {			
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {				
				e1.printStackTrace();
			} finally {
				close();
			}
		}		
		return result;
	}

	@Override
	public List<ProductDto> selectList() {
		//상품 정보 목록 저장 List ,전체 조회

		List<ProductDto> pList = new ArrayList<ProductDto>();

		String query = "SELECT * FROM PT";

		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				ProductDto pd = new ProductDto();
				pd.setP_code(rs.getString(1));
				pd.setP_name(rs.getString(2));
				pd.setP_price(rs.getInt(3));
				pd.setP_type(rs.getString(4));
				pd.setP_amount(rs.getInt(5));
				pList.add(pd);				
			}//while			
		} catch (SQLException e) {			
			//e.printStackTrace();
		} finally {
			close();
		}		
		return pList;
	}	


	@Override
	public ProductDto selectInfo(String code) {
		//코드로 DB 검색하는 쿼리문
		String query = "SELECT * FROM PT WHERE P_CODE = ?";
		ProductDto product = null;

		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				product = new ProductDto();
				product.setP_code(rs.getString(1));
				product.setP_name(rs.getString(2));
				product.setP_price(rs.getInt(3));
				product.setP_type(rs.getString(4));
				product.setP_amount(rs.getInt(5));					
			}
		} catch (SQLException e) {			
			//e.printStackTrace();
		} finally {
			close();
		}		
		return product;
	}	

	@Override
	public int updateProduct(ProductDto Product) {
		int result = 0;
		String query = "UPDATE pt SET p_name=?, p_price=?, p_type=?, p_amount=?"
				+ " WHERE p_code=?";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, Product.getP_name());
			pstmt.setInt(2, Product.getP_price());
			pstmt.setString(3, Product.getP_type());
			pstmt.setInt(4, Product.getP_amount());
			pstmt.setString(5, Product.getP_code());
			result = pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				//e1.printStackTrace();
			}
		} finally {
			close();
		}
		
		return result;
	}

	//데이터 삭제
	@Override
	public int deletePro(String code) {
		int result = 0;
		String query = "DELETE FROM pt WHERE p_code=?";

		try {
			conn = DriverManager.getConnection(url, user, password);

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, code);

			result = pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}	

	//접속 해제 메소드 close
	private void close() {		
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}//try 끝
		catch (SQLException e) {			
			//e.printStackTrace();
		}//catch 끝
	}//close 메소드 끝

}//클래스 끝
