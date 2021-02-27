package com.myspring.kurly.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myspring.kurly.manager.ManagerDAO;
import com.myspring.kurly.manager.ManagerDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	DataSource dataSource;
	@Autowired
	ManagerDAO managerDAO;
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void finallyClose() {
		if(rs != null) {try {rs.close();}catch(SQLException sql) {}}
		if(pstmt != null) {try {pstmt.close();}catch(SQLException sql) {}}
		if(conn != null) {try {conn.close();}catch(SQLException sql) {}}
	}
	
	// 전체 게시글 수 반환
	public int getAllBoardCount() {
		int count = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT COUNT(*) FROM board";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyClose();
		}
		
		return count;
	}
	// 한 페이지에 보여줄 게시글 수 반환
	public ArrayList<BoardDTO> getAllBoardList(int start, int count){
		
		ArrayList<BoardDTO> boardList = new ArrayList<BoardDTO>();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT * FROM board ORDER BY ref DESC, re_level LIMIT ?, ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, count);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setPw(rs.getString("pw"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_level"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setContent(rs.getString("content"));
				
				boardList.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			finallyClose();
		}
		
		return boardList;
	}
	// 새 게시글 등록
	public void insertBoard(BoardDTO dto) {
		try {
			int ref = 0;
			int num = 0;

			conn = dataSource.getConnection();

			String numSql = "SELECT MAX(num) FROM board";
			pstmt = conn.prepareStatement(numSql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1) + 1;
			}

			String refSql = "SELECT MAX(ref) FROM board";
			pstmt = conn.prepareStatement(refSql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				ref = rs.getInt(1) + 1;
			}

			String sql = "INSERT INTO board (num , writer, title, pw, reg_date, ref, re_step, re_level, readcount, content) "
					+ "VALUES(?, ?, ?, ?, now(),?, 1, 1, 0, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getPw());
			pstmt.setInt(5, ref);
			pstmt.setString(6, dto.getContent());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyClose();
		}
	}
	
	public BoardDTO getOneBoard(int num) {
		
		BoardDTO dto = new BoardDTO();
		
		try {
			conn = dataSource.getConnection();
			
			String readSql = "UPDATE board SET readcount=readcount+1 WHERE num=?";
			pstmt = conn.prepareStatement(readSql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			String sql = "SELECT * FROM board WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setPw(rs.getString("pw"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_step"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setContent(rs.getString("content"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyClose();
		}
		
		return dto;
	}
	// 게시판 정보 수정
	public void updateBoard(int num, String title, String content) {
		try {
			conn = dataSource.getConnection();

			String sql = "UPDATE board SET title=?, content=? WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, num);

			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyClose();
		}
	}
	// 게시글 삭제하기
	public void deleteBoard(int num) {
		try {
			conn = dataSource.getConnection();
			
			String sql = "DELETE FROM board WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyClose();
		}
		
	}
	// 게시글 댓글달기 - 조회수 증가없이
	public BoardDTO getOneBoardReply(int num) {
		BoardDTO dto = new BoardDTO();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT * FROM board WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setPw(rs.getString("pw"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_level"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setContent(rs.getString("content"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			finallyClose();
		}
		
		return dto;
	}
	// 게시판 댓글달기
	public void boardReply(int num, String title, String content) {
		
		BoardDTO dto = getOneBoardReply(num);
		ManagerDTO manager = managerDAO.getManager();
		
		// 부모의  ref, re_step, re_level 값에 re_step, re_level 값1증가하기
		int ref = dto.getRef();
		int re_step = dto.getRe_step()+1;
		int re_level = dto.getRe_level()+1;

		System.out.println(dto);

		try {
			conn = dataSource.getConnection();

			String numSql = "SELECT MAX(num) FROM board";
			pstmt = conn.prepareStatement(numSql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1) + 1;
			}
			// 부모의 ref와 같으면서 부모의 relevel보다 큰값들 + 1하기 
			String levelsql = "UPDATE board SET re_level=re_level+1  WHERE ref=? AND re_level>?";

			pstmt = conn.prepareStatement(levelsql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, dto.getRe_level());

			pstmt.executeUpdate();

			String sql = "INSERT INTO board (num , writer, title, pw, reg_date, ref, re_step, re_level, readcount, content) "
					+ "VALUES(?, ?, ?, ?, now(),?, ?, ?, 0, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, manager.getId());
			pstmt.setString(3, title);
			pstmt.setString(4, manager.getPw());
			pstmt.setInt(5, ref);
			pstmt.setInt(6, re_step);
			pstmt.setInt(7, re_level);
			pstmt.setString(8, content);
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyClose();
		}
	}
	// 게시글 삭제할 경우 아래 댓글들 다 삭제 -- ref값은값들 다삭제.
	public void deleteBoardAll(int ref) {
		try {
			conn = dataSource.getConnection();
			
			String sql = "DELETE FROM board WHERE ref=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ref);
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyClose();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
