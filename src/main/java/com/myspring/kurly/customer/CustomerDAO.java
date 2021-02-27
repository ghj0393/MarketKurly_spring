package com.myspring.kurly.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO {

	@Autowired
	DataSource dataScoure;
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void finallyClose() {
		if(rs != null) {try {rs.close();}catch(SQLException sql) {}}
		if(pstmt != null) {try {pstmt.close();}catch(SQLException sql) {}}
		if(conn != null) {try {conn.close();}catch(SQLException sql) {}}
	}
	
	// 회원가입
	public void insertCustomer(CustomerDTO dto) {
		try {
			conn = dataScoure.getConnection();
			
			String sql = "INSERT INTO customer "
					+ "VALUES(?, ?, ?, now(), ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getAddress());
			pstmt.setString(6, dto.getEmail());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			finallyClose();
		}
	}
	// 회원가입--id중복체크
	public int checkDoubleId(String id) {
		int check = 0;
		try {
			conn = dataScoure.getConnection();
			
			String sql = "SELECT id FROM customer WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			finallyClose();
		}
		
		return check;
	}
	// 회원가입--email중복체크
	public int checkDoubleEmail(String email) {
		int check = 0;
		
		try {
			conn = dataScoure.getConnection();
			
			String sql = "SELECT email FROM customer WHERE email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			finallyClose();
		}
		
		return check;
	}
	// 로그인 id, pw 확인
	public int userCheck(String id, String pw) {
		int check = 0;
		try {
			conn = dataScoure.getConnection();
			
			String sql = "SELECT * FROM customer WHERE id=? AND pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = 1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			finallyClose();
		}
		
		return check;
	}
	// id에 해당하는 고객정보 가져오기
	public CustomerDTO getCustomerInfo(String id) {
		CustomerDTO dto = new CustomerDTO();
		
		try {
			conn = dataScoure.getConnection();
			
			String sql = "SELECT * FROM customer WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				dto.setEmail(rs.getString("email"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			finallyClose();
		}
		return dto;
	}
	
	// ID찾기
	public String findId(String name, String email) {
		String id = null;
		try {
			conn = dataScoure.getConnection();
			
			String sql = "SELECT id FROM customer WHERE name=? AND email=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				id = rs.getString(1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			finallyClose();
		}
		return id;
	}
	
	// PW찾기
	public String findPw(String name, String id, String email) {
		String pw = null;
		try {
			conn = dataScoure.getConnection();
			
			String sql = "SELECT pw FROM customer WHERE name=? AND id=? AND email=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				pw = rs.getString(1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			finallyClose();
		}
		return pw;
	}
	
}



















