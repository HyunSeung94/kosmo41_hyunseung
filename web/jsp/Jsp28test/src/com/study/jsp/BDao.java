package com.study.jsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

//커넥션풀 적용! 

public class BDao {

	public static final int MEMBER_NONEXISTENT = 0;
	public static final int MEMBER_EXISTENT = 1;
	public static final int MEMBER_JOIN_FAIL = 0;
	public static final int MEMBER_JOIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
	public static final int MEMBER_LOGIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_IS_NOT = -1;

	private static BDao instance = new BDao();
	DataSource dataSource = null;
	int listCount = 10; // 한페이지당 보여줄 게시물의 갯수
	int pageCount = 5; // 하단에 보여줄 페이지 리스트 갯수
	int searchcount = 0;
	

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

	public int insertMember(BDto dto) {
		int ri = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into members values (?,?,?,?,?,?,0)";

		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.geteMail());
			pstmt.setTimestamp(5, dto.getrDate());
			pstmt.setString(6, dto.getAddress());
			
			pstmt.executeUpdate();
			ri = BDao.MEMBER_JOIN_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("11111");
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

		return ri;
	}

	public int confirmId(String id) {
		int ri = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select id from members where id = ?";

		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			if (set.next()) {
				ri = BDao.MEMBER_EXISTENT;
			} else {
				ri = BDao.MEMBER_NONEXISTENT;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("22222");
		} finally {

			try {
				set.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return ri;
	}

	public int userCheck(String id, String pw) {
		int ri = 0;
		String dbPw;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select pw from members where id = ?";

		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			if (set.next()) {
				dbPw = set.getString("pw");
				if (dbPw.equals(pw)) {
					System.out.println("login ok");
					ri = BDao.MEMBER_LOGIN_SUCCESS; // 로그인 OK
				} else {
					System.out.println("lohin fail");
					ri = BDao.MEMBER_LOGIN_PW_NO_GOOD; // 비밀번호 X
				}
			} else {
				System.out.println("login fail");
				ri = BDao.MEMBER_LOGIN_IS_NOT; // 아이디 X
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("33333");
		} finally {

			try {
				set.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return ri;
	}

	public BDto getMember(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select * from members where id = ?";
		BDto dto = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();

			if (set.next()) {
				dto = new BDto();
				dto.setId(set.getString("id"));
				dto.setPw(set.getString("pw"));
				dto.setName(set.getString("name"));
				dto.seteMail(set.getString("eMail"));
				dto.setrDate(set.getTimestamp("rDate"));
				dto.setAddress(set.getString("address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("55555");
		} finally {
			try {
				set.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return dto;
	}

	public int updateMember(BDto dto) {
		int ri = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "update members set pw=?, eMail=?, address=? where id=?";

		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.geteMail());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getId());
			ri = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ri;
	}

	private Connection getConnection() {

		Context context = null;
		DataSource dataSource = null;
		Connection con = null;

		try {
			// lookup 함수의 파라메터는 context.xml에 설정된
			// name(jdbc/Oracle11g)과 동일해야 한다.
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			con = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("444444");
		}

		return con;
	}

	public void Write(String bName, String bTitle, String bContent,String boardname,HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		HttpSession session = null;
		session = request.getSession();
		
		String name = (String) session.getAttribute("name");
		String Memberid = (String) session.getAttribute("id");
		session.setAttribute("id", Memberid);
		session.setAttribute("name", name);
		
		String query = "insert into mvc_board " + "(bId,bName,bTitle,bContent, bGroup, bStep, bIndent,boardname,Memberid)" + " values "
				+ " ( mvc_board_seq.nextval, ?, ?, ?, mvc_board_seq.currval,0,0,?,?)";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, boardname);
			pstmt.setString(5, Memberid);
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

	public ArrayList<BDto> list(int curPage, String search, String condition, String boardnamelist) {

		ArrayList<BDto> dtos = new ArrayList<BDto>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String query = null;

		int nStart = (curPage - 1) * listCount + 1;
		int nEnd = (curPage - 1) * listCount + listCount;

		try {
			
			// 전체글 쿼리문 !
			con = dataSource.getConnection();
			if (search == null && boardnamelist == null) {
				System.out.println(boardnamelist + "전체글 쿼리문!!");
				query = "select * " + "  from ( " + "   select rownum num, A.*" + "     from ( " + "        select *"
						+ "          from mvc_board " + "         order by bgroup desc, bstep asc ) A "
						+ "    where rownum <= ? ) B" + " where B.num >= ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, nEnd);
				pstmt.setInt(2, nStart);
				resultSet = pstmt.executeQuery();
				
				//게시판글 쿼리문
			} else if(search == null && boardnamelist != null) {
				System.out.println(boardnamelist + "글 쿼리문");
				query = "select * " + "  from ( " + "   select rownum num, A.*" + "     from ( " + "        select *"
						+ "          from mvc_board where boardname = '"+boardnamelist+"'"
						+ "         order by bgroup desc, bstep asc ) A " + "    where rownum <= ? ) B"
						+ " where B.num >= ? ";
				pstmt = con.prepareStatement(query);
				//pstmt.setString(1, boardnamelist);
				pstmt.setInt(1, nEnd);
				pstmt.setInt(2, nStart);
				resultSet = pstmt.executeQuery();
				
				//전체글 검색 쿼리문
			}else if (search.equals("0") && boardnamelist == null ) {
				System.out.println("search : 0이다");
				query = "select * " + "  from ( " + "   select rownum num, A.*" + "     from ( " + "        select *"
						+ "          from mvc_board where bTitle like ? "
						+ "         order by bgroup desc, bstep asc ) A " + "    where rownum <= ? ) B"
						+ " where B.num >= ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setInt(2, nEnd);
				pstmt.setInt(3, nStart);
				resultSet = pstmt.executeQuery();

			} else if (search.equals("1") && boardnamelist == null ) {
				System.out.println("search : 1");
				query = "select * " + "  from ( " + "   select rownum num, A.*" + "     from ( " + "        select *"
						+ "          from mvc_board where bContent like ? "
						+ "         order by bgroup desc, bstep asc ) A " + "    where rownum <= ? ) B"
						+ " where B.num >= ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setInt(2, nEnd);
				pstmt.setInt(3, nStart);
				resultSet = pstmt.executeQuery();
			} else if (search.equals("2") && boardnamelist == null ) {
				System.out.println("search : 2");
				query = "select * " + "  from ( " + "   select rownum num, A.*" + "     from ( " + "        select *"
						+ "          from mvc_board where bName like ? "
						+ "         order by bgroup desc, bstep asc ) A " + "    where rownum <= ? ) B"
						+ " where B.num >= ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setInt(2, nEnd);
				pstmt.setInt(3, nStart);
				resultSet = pstmt.executeQuery();
			} else if (search.equals("3") && boardnamelist == null ) {
				System.out.println("search : 3");
				query = "select * " + "  from ( " + "   select rownum num, A.*" + "     from ( " + "        select *"
						+ "          from mvc_board where bTitle like ? or bContent like ? "
						+ "         order by bgroup desc, bstep asc ) A " + "    where rownum <= ? ) B"
						+ " where B.num >= ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setString(2, "%" + condition + "%");
				pstmt.setInt(3, nEnd);
				pstmt.setInt(4, nStart);
				resultSet = pstmt.executeQuery();
			} else if (search.equals("all") && boardnamelist == null) {
				System.out.println("search : all");
				query = "select * " + "  from ( " + "   select rownum num, A.*" + "     from ( " + "        select *"
						+ "          from mvc_board where bName like ? or bTitle like ? or bContent like ? "
						+ "         order by bgroup desc, bstep asc ) A " + "    where rownum <= ? ) B"
						+ " where B.num >= ? ";

				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setString(2, "%" + condition + "%");
				pstmt.setString(3, "%" + condition + "%");
				pstmt.setInt(4, nEnd);
				pstmt.setInt(5, nStart);
				resultSet = pstmt.executeQuery();
				
				//게시판글 검색 쿼리문!
			}  else if (search.equals("0") && boardnamelist != null ) {
				System.out.println("search : 0");
				query = "select * " + "  from ( " + "   select rownum num, A.*" + "     from ( " + "        select *"
						+ "          from mvc_board where boardname = '"+boardnamelist+"' and bTitle like ? "
						+ "         order by bgroup desc, bstep asc ) A " + "    where rownum <= ? ) B"
						+ " where B.num >= ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setInt(2, nEnd);
				pstmt.setInt(3, nStart);
				resultSet = pstmt.executeQuery();

			} else if (search.equals("1") && boardnamelist != null) {
				System.out.println("search : 1");
				query = "select * " + "  from ( " + "   select rownum num, A.*" + "     from ( " + "        select *"
						+ "          from mvc_board where boardname = '"+boardnamelist+"' and bContent like ? "
						+ "         order by bgroup desc, bstep asc ) A " + "    where rownum <= ? ) B"
						+ " where B.num >= ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setInt(2, nEnd);
				pstmt.setInt(3, nStart);
				resultSet = pstmt.executeQuery();
			} else if (search.equals("2") && boardnamelist != null) {
				System.out.println("search : 2");
				query = "select * " + "  from ( " + "   select rownum num, A.*" + "     from ( " + "        select *"
						+ "          from mvc_board where boardname = '"+boardnamelist+"' and bName like ? "
						+ "         order by bgroup desc, bstep asc ) A " + "    where rownum <= ? ) B"
						+ " where B.num >= ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setInt(2, nEnd);
				pstmt.setInt(3, nStart);
				resultSet = pstmt.executeQuery();
			} else if (search.equals("3") && boardnamelist != null) {
				System.out.println("search : 3");
				query = "select * " + "  from ( " + "   select rownum num, A.*" + "     from ( " + "        select *"
						+ "          from mvc_board where boardname = '"+boardnamelist+"' and bTitle like ? or bContent like ? "
						+ "         order by bgroup desc, bstep asc ) A " + "    where rownum <= ? ) B"
						+ " where B.num >= ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setString(2, "%" + condition + "%");
				pstmt.setInt(3, nEnd);
				pstmt.setInt(4, nStart);
				resultSet = pstmt.executeQuery();
			} else if (search.equals("all") && boardnamelist != null) {
				System.out.println("search : all");
				query = "select * " + "  from ( " + "   select rownum num, A.*" + "     from ( " + "        select *"
						+ "          from mvc_board where boardname = '"+boardnamelist+"' and bName like ? or bTitle like ? or bContent like ? "
						+ "         order by bgroup desc, bstep asc ) A " + "    where rownum <= ? ) B"
						+ " where B.num >= ? ";

				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setString(2, "%" + condition + "%");
				pstmt.setString(3, "%" + condition + "%");
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
				String Memberid = resultSet.getString("Memberid");
				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent, Memberid);
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

	public BPageInfo articlePage(int curPage, String search, String condition, String boardnamelist) {

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

			//전체 게시물 페이징 
			if (search == null && boardnamelist == null) {
				query = "select count(*) as total from mvc_board ";
				pstmt = con.prepareStatement(query);
				resultSet = pstmt.executeQuery();
				
			//게시판별 게시물 페이징
			} else if (search == null && boardnamelist != null) {
				query = "select count(*) as total from mvc_board where boardname = '"+boardnamelist+"'";
				pstmt = con.prepareStatement(query);
				//pstmt.setString(1, boardnamelist);
				resultSet = pstmt.executeQuery();
			//전체 게시글 검색 페이징
			} else if (search.equals("0") && boardnamelist == null) {
				query = "select count(*) as total from mvc_board where bTitle like ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + condition + "%");
				resultSet = pstmt.executeQuery();
				System.out.println("제목 토탈글확인");
				System.out.println(condition + "검색내용");
				System.out.println(boardnamelist+"전체검색만되냐고");
			} else if (search.equals("1") && boardnamelist == null) {
				query = "select count(*) as total from mvc_board where bContent like ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + condition + "%");
				resultSet = pstmt.executeQuery();
				System.out.println("내용 토탈글확인");
			} else if (search.equals("2") && boardnamelist == null) {
				query = "select count(*) as total from mvc_board where bName like ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + condition + "%");
				resultSet = pstmt.executeQuery();
				System.out.println("네임 토탈글확인");
			} else if (search.equals("3") && boardnamelist == null) {
				query = "select count(*) as total from mvc_board where bTitle like ? or bContent like ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setString(2, "%" + condition + "%");
				System.out.println("제목+ 내용 글확인");
				resultSet = pstmt.executeQuery();
			} else if (search.equals("all") && boardnamelist == null) {
				System.out.println("all 글 확인");
				query = "select count(*) as total from mvc_board where bName like ? or bTitle like ? or bContent like ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setString(2, "%" + condition + "%");
				pstmt.setString(3, "%" + condition + "%");
				resultSet = pstmt.executeQuery();
				
				
			}	
				//게시판별 검색 페이징
				else if (search.equals("0") && boardnamelist != null) {
				query = "select count(*) as total from mvc_board where boardname = '"+boardnamelist+"' and bTitle like ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + condition + "%");
				resultSet = pstmt.executeQuery();
				System.out.println("제목 토탈글확인");
				System.out.println(boardnamelist+"널이아닌검색페이징");
				System.out.println(condition + "검색내용");

			} else if (search.equals("1") && boardnamelist != null) {
				query = "select count(*) as total from mvc_board '"+boardnamelist+"' and bContent like ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + condition + "%");
				resultSet = pstmt.executeQuery();
				System.out.println("내용 토탈글확인");
			} else if (search.equals("2") && boardnamelist != null) {
				query = "select count(*) as total from mvc_board '"+boardnamelist+"' and bName like ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + condition + "%");
				resultSet = pstmt.executeQuery();
				System.out.println("네임 토탈글확인");
			} else if (search.equals("3") && boardnamelist != null) {
				query = "select count(*) as total from mvc_board '"+boardnamelist+"' and bTitle like ? or bContent like ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setString(2, "%" + condition + "%");
				System.out.println("제목+ 내용 글확인");
				resultSet = pstmt.executeQuery();

			} else if (search.equals("all") && boardnamelist != null) {
				System.out.println("all 글 확인");
				query = "select count(*) as total from mvc_board '"+boardnamelist+"' and bName like ? or bTitle like ? or bContent like ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setString(2, "%" + condition + "%");
				pstmt.setString(3, "%" + condition + "%");
				resultSet = pstmt.executeQuery();
			}

			if (resultSet.next()) {
				totalCount = resultSet.getInt("total");
			}
			System.out.println("total : " + totalCount);

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
				String boardname = resultSet.getString("boardname");
				String Memberid = resultSet.getString("Memberid");

				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent,Memberid);

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

	public void modify(String bId, String bName, String bTitle, String bContent,String boardname) {

		Connection con = null;
		PreparedStatement pstmt = null;

		String query = "update mvc_board " + "set bName = ?, " + " 	  bTitle = ?, " + "	  bContent = ? " 
				+ " where bId = ?";

		try {
			System.out.println("BDao-modify:"+boardname);
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
				String Memberid = resultSet.getString("Memberid");
				

				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent,Memberid);

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
			String bIndent, String boardname) {

		replyShape(bGroup, bStep);

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			System.out.println("reply: "+boardname);
			con = dataSource.getConnection();

			String query = "insert into mvc_board " + "(bId, bName, bTitle, bContent, bGroup, bStep, bIndent,boardname) "
					+ " values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?,?)";
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bGroup));
			pstmt.setInt(5, Integer.parseInt(bStep) + 1);
			pstmt.setInt(6, Integer.parseInt(bIndent) + 1);
			pstmt.setString(7, boardname);

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
