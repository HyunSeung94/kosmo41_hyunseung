package com.study.jsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//커넥션풀 적용! 

public class BDao {

	private static BDao instance = new BDao();
	DataSource dataSource = null;
	int listCount = 10; // 한페이지당 보여줄 게시물의 갯수
	int pageCount = 5; // 하단에 보여줄 페이지 리스트 갯수
	int searchcount= 0;

	private BDao() {
		try {
			// lookup 함수의 파라메터는 context.xml에 설정된
			// name(jdbc/Oracle11g)과 동일해야 한다.
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			// 접속 정보만 가지고 있음
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static BDao getInstance() {
		return instance;
	}

	public void Write(String bName, String bTitle, String bContent) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into mvc_board " + "(bId,bName,bTitle,bContent, bGroup, bStep, bIndent)" + " values "
				+ " ( mvc_board_seq.nextval, ?, ?, ?, mvc_board_seq.currval,0,0)";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			int rn = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// private Connection getConnection() {
	//
	// Context context = null;
	// DataSource dataSource = null;
	// Connection con = null;
	//
	// try {
	// // lookup 함수의 파라메터는 context.xml에 설정된
	// // name(jdbc/Oracle11g)과 동일해야 한다.
	// context = new InitialContext();
	// dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
	// con = dataSource.getConnection();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// return con;
	// }

	public ArrayList<BDto> list(int curPage, String search, String condition) {

		ArrayList<BDto> dtos = new ArrayList<BDto>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String query = null;

		int nStart = (curPage - 1) * listCount + 1;
		int nEnd = (curPage - 1) * listCount + listCount;

		try {

			con = dataSource.getConnection();
			if (search == null) {
				System.out.println("search : true");
				query = "select * " + "  from ( " + "   select rownum num, A.*" + "     from ( " + "        select *"
						+ "          from mvc_board" + "         order by bgroup desc, bstep asc ) A "
						+ "    where rownum <= ? ) B" + " where B.num >= ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, nEnd);
				pstmt.setInt(2, nStart);
				resultSet = pstmt.executeQuery();
			} else if (search.equals("0")) {
				System.out.println("search : 0");
				query = "select * " + "  from ( " + "   select rownum num, A.*" + "     from ( " + "        select *"
						+ "          from mvc_board where bTitle like ? "
						+ "         order by bgroup desc, bstep asc ) A " + "    where rownum <= ? ) B"
						+ " where B.num >= ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, nEnd);
				pstmt.setInt(3, nStart);
				resultSet = pstmt.executeQuery();

			} else if (search.equals("1")) {
				System.out.println("search : 1");
				query = "select * " + "  from ( " + "   select rownum num, A.*" + "     from ( " + "        select *"
						+ "          from mvc_board where bContent like ? "
						+ "         order by bgroup desc, bstep asc ) A " + "    where rownum <= ? ) B"
						+ " where B.num >= ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, nEnd);
				pstmt.setInt(3, nStart);
				resultSet = pstmt.executeQuery();
			} else if (search.equals("2")) {
				System.out.println("search : 2");
				query = "select * " + "  from ( " + "   select rownum num, A.*" + "     from ( " + "        select *"
						+ "          from mvc_board where bName like ? "
						+ "         order by bgroup desc, bstep asc ) A " + "    where rownum <= ? ) B"
						+ " where B.num >= ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, nEnd);
				pstmt.setInt(3, nStart);
				resultSet = pstmt.executeQuery();
			} else if (search.equals("3")) {
				System.out.println("search : 3");
				query = "select * " + "  from ( " + "   select rownum num, A.*" + "     from ( " + "        select *"
						+ "          from mvc_board where bTitle like ? or bContent like ? "
						+ "         order by bgroup desc, bstep asc ) A " + "    where rownum <= ? ) B"
						+ " where B.num >= ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setString(2, "%"+condition+"%");
				pstmt.setInt(3, nEnd);
				pstmt.setInt(4, nStart);
				resultSet = pstmt.executeQuery();
			} else if (search.equals("all")) {
				System.out.println("search : all");
				query = "select * " + "  from ( " + "   select rownum num, A.*" + "     from ( " + "        select *"
						+ "          from mvc_board where bName like ? or bTitle like ? or bContent like ? "
						+ "         order by bgroup desc, bstep asc ) A " + "    where rownum <= ? ) B"
						+ " where B.num >= ? ";

				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setString(2, "%"+condition+"%");
				pstmt.setString(3, "%"+condition+"%");
				pstmt.setInt(4, nEnd);
				pstmt.setInt(5, nStart);
				resultSet = pstmt.executeQuery();
			}
			while (resultSet.next()) {
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}

	/*
	 * public ArrayList<BDto> Search(String search, String condition, int curPage) {
	 * 
	 * ArrayList<BDto> dtos = new ArrayList<BDto>(); Connection con = null;
	 * PreparedStatement pstmt = null; ResultSet resultSet = null; String query =
	 * null;
	 * 
	 * try {
	 * 
	 * con = dataSource.getConnection();
	 * 
	 * if (search.equals("0")) { query = "select * " + "  from ( " +
	 * "   select rownum num, A.*" + "     from ( " + "        select *" +
	 * "          from mvc_board where bTitle like'%?%' " +
	 * "         order by bgroup desc, bstep asc ) A " + "    where rownum <= ? ) B"
	 * + " where B.num >= ? "; pstmt = con.prepareStatement(query);
	 * pstmt.setString(1, condition); pstmt.setInt(2, nEnd); pstmt.setInt(3,
	 * nStart); resultSet = pstmt.executeQuery();
	 * 
	 * } else if (search.equals("1")) { query = "select * " + "  from ( " +
	 * "   select rownum num, A.*" + "     from ( " + "        select *" +
	 * "          from mvc_board where bContent like'%?%' " +
	 * "         order by bgroup desc, bstep asc ) A " + "    where rownum <= ? ) B"
	 * + " where B.num >= ? "; pstmt = con.prepareStatement(query);
	 * pstmt.setString(1, condition); pstmt.setInt(2, nEnd); pstmt.setInt(3,
	 * nStart); resultSet = pstmt.executeQuery(); } else if (search.equals("2")) {
	 * query = "select * " + "  from ( " + "   select rownum num, A.*" +
	 * "     from ( " + "        select *" +
	 * "          from mvc_board where bName like'%?%' " +
	 * "         order by bgroup desc, bstep asc ) A " + "    where rownum <= ? ) B"
	 * + " where B.num >= ? "; pstmt = con.prepareStatement(query);
	 * pstmt.setString(1, condition); pstmt.setInt(2, nEnd); pstmt.setInt(3,
	 * nStart); resultSet = pstmt.executeQuery(); } else if (search.equals("3")) {
	 * query = "select * " + "  from ( " + "   select rownum num, A.*" +
	 * "     from ( " + "        select *" +
	 * "          from mvc_board where bTitle like'%?%' or bContent like'%?%' " +
	 * "         order by bgroup desc, bstep asc ) A " + "    where rownum <= ? ) B"
	 * + " where B.num >= ? "; pstmt = con.prepareStatement(query);
	 * pstmt.setString(1, condition); pstmt.setString(2, condition); pstmt.setInt(3,
	 * nEnd); pstmt.setInt(4, nStart); resultSet = pstmt.executeQuery(); } else if
	 * (search.equals("all")) { query = "select * " + "  from ( " +
	 * "   select rownum num, A.*" + "     from ( " + "        select *" +
	 * "          from mvc_board where bName like'%?%' or bTitle like'%?%' or bContent like'%?%' "
	 * + "         order by bgroup desc, bstep asc ) A " +
	 * "    where rownum <= ? ) B" + " where B.num >= ? ";
	 * 
	 * pstmt = con.prepareStatement(query); pstmt.setString(1, condition);
	 * pstmt.setString(2, condition); pstmt.setString(3, condition); pstmt.setInt(4,
	 * nEnd); pstmt.setInt(5, nStart); resultSet = pstmt.executeQuery(); }
	 * 
	 * while (resultSet.next()) { int bId = resultSet.getInt("bId"); String bName =
	 * resultSet.getString("bName"); String bTitle = resultSet.getString("bTitle");
	 * String bContent = resultSet.getString("bContent"); Timestamp bDate =
	 * resultSet.getTimestamp("bDate"); int bHit = resultSet.getInt("bHit"); int
	 * bGroup = resultSet.getInt("bGroup"); int bStep = resultSet.getInt("bStep");
	 * int bIndent = resultSet.getInt("bIndent");
	 * 
	 * BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep,
	 * bIndent); dtos.add(dto); }
	 * 
	 * int rn = pstmt.executeUpdate(); } catch (Exception e) { e.printStackTrace();
	 * } finally { try { if (pstmt != null) pstmt.close(); if (con != null)
	 * con.close(); } catch (Exception e2) { e2.printStackTrace(); } } return dtos;
	 * }
	 */

	public BPageInfo articlePage(int curPage, String search, String condition) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String query = null;
		/*
		 * 공통으로사용하는 변수 상단으로 올림 int listCount = 10; // 한페이지당 보여줄 게시물의 갯수 int pageCount =
		 * 10; // 하단에 보여줄 페이지 리스트 갯수
		 */

		// 총 게시물의 갯수
		int totalCount = 0;

		try {
			con = dataSource.getConnection();

			if(search == null) {
			query = "select count(*) as total from mvc_board";
			pstmt = con.prepareStatement(query);
			resultSet = pstmt.executeQuery();
			} else if (search.equals("0")) {
				query = "select count(*) as total from mvc_board where bTitle like ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%"+condition+"%");
				resultSet = pstmt.executeQuery();
				System.out.println("제목 토탈페이지확인");

			} else if (search.equals("1")) {
				query = "select count(*) as total from mvc_board where bContent like ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%"+condition+"%");
				resultSet = pstmt.executeQuery();
				System.out.println("내용 토탈페이지확인");
			} else if (search.equals("2")) {
				query = "select count(*) as total from mvc_board where bName like ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%"+condition+"%");
				resultSet = pstmt.executeQuery();
				System.out.println("네임 토탈페이지확인");
			} else if (search.equals("3")) {
				query = "select count(*) as total from mvc_board where bTitle like ? or bContent like ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setString(2, "%"+condition+"%");
				resultSet = pstmt.executeQuery();

			} else if (search.equals("all")) {
				System.out.println("all 페이지 확인");
				query = "select count(*) as total from mvc_board where bName like ? or bTitle like ? or bContent like ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setString(2, "%"+condition+"%");
				pstmt.setString(3, "%"+condition+"%");
				resultSet = pstmt.executeQuery();
			}

			if (resultSet.next()) {
				totalCount = resultSet.getInt("total");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// 총 페이지 수
		int totalPage = totalCount / listCount; //
		if (totalCount % listCount > 0) {
			totalPage++;
		}

		// 현재 보고 있는 페이지
		int mycurPage = curPage;
		if (mycurPage > totalPage)
			mycurPage = totalPage;
		if (mycurPage < 1)
			mycurPage = 1;

		// 시작 페이지
		int startPage = ((mycurPage - 1) / pageCount) * pageCount + 1;

		// 끝 페이지
		int endPage = startPage + pageCount - 1;
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		BPageInfo pinfo = new BPageInfo();
		pinfo.setTotalCount(totalCount);
		pinfo.setListCount(listCount);
		pinfo.setTotalPage(totalPage);
		pinfo.setCurPage(mycurPage);
		pinfo.setPageCount(pageCount);
		pinfo.setStartPage(startPage);
		pinfo.setEndPage(endPage);

		return pinfo;
	}

	public BDto contentView(String strID) {
		upHit(strID);

		BDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			con = dataSource.getConnection();

			String query = "select * from mvc_board where bId = ? ";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(strID));
			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}

	public void modify(String bId, String bName, String bTitle, String bContent) {

		Connection con = null;
		PreparedStatement pstmt = null;

		String query = "update mvc_board " + "set bName = ?, " + " 	  bTitle = ?, " + "	  bContent = ? "
				+ " where bId = ?";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bId)); // 스트링을 인티저로 바꿔줌
			int rn = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void upHit(String bId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();

			String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(bId)); // 스트링을 인티저로 바꿔줌

			int rn = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void delete(String bId) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "delete from mvc_board where bId = ?";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(bId)); // 스트링을 인티저로 바꿔줌
			int rn = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public BDto reply_view(String str) {

		BDto dto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			con = dataSource.getConnection();

			String query = "select * from mvc_board where bId = ? ";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(str));
			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}

	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep,
			String bIndent) {

		replyShape(bGroup, bStep);

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();

			String query = "insert into mvc_board " + "(bId, bName, bTitle, bContent, bGroup, bStep, bIndent) "
					+ " values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bGroup));
			pstmt.setInt(5, Integer.parseInt(bStep) + 1);
			pstmt.setInt(6, Integer.parseInt(bIndent) + 1);

			int rn = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private void replyShape(String strGroup, String strStep) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();

			String query = "update mvc_board " + " set bStep = bSTep + 1 " + " where bGroup = ? and bStep > ?";
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, Integer.parseInt(strGroup));
			pstmt.setInt(2, Integer.parseInt(strStep));

			int rn = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
