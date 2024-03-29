package com.study.jsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BDao {

	private static BDao instance = new BDao();
	DataSource dataSource = null;
	
	int listCount = 10;
	int pageCount = 10;
	
	private BDao() {
		try {
			// lookup 함수의 파라미터는 context.xml에 설정된 name과 동일해야 한다.
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static BDao getInstance() {
		return instance;
	}
	
	public void write(String bName, String bTitle, String bContent) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into mvc_board(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent)" +
					   "values(mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
		
		try {
//			con = getConnection();
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			int rn = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("1111");
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<BDto> list(int page){
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		int start = page*10-9;
		int end = start+10;
		
		try {
//			con = getConnection();
			con = dataSource.getConnection();
			
//			String query = "select * from mvc_board order by bGroup desc, bStep asc";
			String query = "select * " + 
				           "from ( select rownum num, A.* " + 
				           		  "from ( select * " + 
				           		  		 "from mvc_board " + 
				           		  		 "order by bGroup desc, bStep asc ) A " + 
				           		  "where rownum <= " + end + " ) B " + 
				           "where B.num >= " + start;
			pstmt = con.prepareStatement(query);
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				
				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}
	
	public BDto contentView(String strID) {
		upHit(strID);
		
		BDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		try {
//			con = getConnection();
			con = dataSource.getConnection();
			
			String query = "select * from mvc_board where bId=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(strID));
			resultSet = pstmt.executeQuery();
			
			if(resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				
				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	public void modify(String bId, String bName, String bTitle, String bContent) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "update mvc_board set bName=?, bTitle=?, bContent=? where bId=?";
		
		try {
//			con = getConnection();
			con = dataSource.getConnection();
	
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, bId);
			int rn = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void upHit(String bId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
//			con = getConnection();
			con = dataSource.getConnection();
			
			String query = "update mvc_board set bHit=bHit+1 where bId=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bId);
			int rn = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete(String bId) {

		Connection con = null;
		PreparedStatement pstmt = null;
			
		try {
//			con = getConnection();
			con = dataSource.getConnection();
			
			String query = "delete from mvc_board where bId=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bId);
			int rn = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public BDto reply_view(String str) {
		BDto dto = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		try {
//			con = getConnection();
			con = dataSource.getConnection();
			
			String query = "select * from mvc_board where bId=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(str));
			resultSet = pstmt.executeQuery();
			
			if(resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				
				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent) {
		replyShape(bGroup, bStep);
		
		Connection con = null;
		PreparedStatement pstmt = null;		
		
		try {
//			con = getConnection();
			con = dataSource.getConnection();
			
			String query = "insert into mvc_board(bId, bName, bTitle, bContent, bGroup, bStep, bIndent)" +
					   "values(mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bGroup));
			pstmt.setInt(5, Integer.parseInt(bStep)+1);
			pstmt.setInt(6, Integer.parseInt(bIndent)+1);
			
			int rn = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void replyShape(String strGroup, String strStep) {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
//			con = getConnection();
			con = dataSource.getConnection();
			
			String query = "update mvc_board set bStep = bStep+1 where bGroup=? and bStep > ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(strGroup));
			pstmt.setInt(2, Integer.parseInt(strStep));
		
			int rn = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public BPageInfo articlePage(int curPage) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		int totalCount = 0;
		
		try {
			con = dataSource.getConnection();
			
			String query = "select count(*) from mvc_board";
			pstmt = con.prepareStatement(query);
			resultSet = pstmt.executeQuery();
			resultSet.next();
			
			totalCount = resultSet.getInt("Count(*)");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		int totalPage = totalCount/listCount;		
		if(totalCount % listCount > 0)
			totalPage++;
		
		int myCurPage = curPage;
		if(myCurPage > totalPage)
			myCurPage = totalPage;
		if(myCurPage < 1)
			myCurPage = 1;
		
		int startPage = ((myCurPage-1)/pageCount)*pageCount+1;
		int endPage = startPage + pageCount-1;
		if(endPage>totalPage)
			endPage = totalPage;
		
		BPageInfo pInfo = new BPageInfo();
		pInfo.setTotalCount(totalCount);
		pInfo.setListCount(listCount);
		pInfo.setTotalPage(totalPage);
		pInfo.setCurPage(myCurPage);
		pInfo.setPageCount(pageCount);
		pInfo.setStartPage(startPage);
		pInfo.setEndPage(endPage);
		
		return pInfo;
	}
	
//	private Connection getConnection() {
//		Context context = null;
//		DataSource dataSource = null;
//		Connection con = null;
//		try {
//			// lookup 함수의 파라미터는 context.xml에 설정된 name과 동일해야 한다.
//			context = new InitialContext();
//			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
//			con = dataSource.getConnection();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return con;
//	}
}
