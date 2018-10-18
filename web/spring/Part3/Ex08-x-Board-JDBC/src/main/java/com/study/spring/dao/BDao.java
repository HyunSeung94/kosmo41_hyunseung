package com.study.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.study.spring.dto.BDto;
import com.study.spring.util.Constant;

//커넥션풀 적용! 

public class BDao {

	DataSource dataSource;

	JdbcTemplate template = null;

	public BDao() {
		template = Constant.template;
	}

	public void Write(final String bName, final String bTitle, final String bContent) {

		// PreparedStatementCreator 와 PreparedStatementSetter 방법만다른것
		template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				String query = "insert into mvc_board1 " + "(bId,bName,bTitle,bContent, bGroup, bStep, bIndent)"
						+ " values " + " ( mvc_board_seq.nextval, ?, ?, ?, mvc_board_seq.currval,0,0)";

				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);

				return pstmt;
			}
		});

	}

	public ArrayList<BDto> list() {
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent "
				+ "  from mvc_board1 " + " order by bGroup desc, bStep asc";
		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}

	public BDto contentView(String strID) {

		upHit(strID);
		String query = "select * from mvc_board1 where bId = " + strID;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}

	public void modify(final String bId, final String bName, final String bTitle, final String bContent) {

		String query = "update mvc_board1 " + "set bName = ?, " + " 	  bTitle = ?, " + "	  bContent = ? "
				+ " where bId = ?";
		// PreparedStatementCreator 와 PreparedStatementSetter 방법만다른것
		template.update(query, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {

				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				pstmt.setInt(4, Integer.parseInt(bId)); // 스트링을 인티저로 바꿔줌
			}
		});
	}

	public void upHit(final String bId) {

		String query = "update mvc_board1 set bHit = bHit + 1 where bId = ?";
		// PreparedStatementCreator 와 PreparedStatementSetter 방법만다른것
		template.update(query, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, Integer.parseInt(bId)); // 스트링을 인티저로 바꿔줌

			}

		});

	}

	public void delete(final String bId) {

		String query = "delete from mvc_board1 where bId = ?";
		// PreparedStatementCreator 와 PreparedStatementSetter 방법만다른것
		template.update(query, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, Integer.parseInt(bId)); // 스트링을 인티저로 바꿔줌
			}

		});
	}

	public BDto reply_view(String str) {
		int str2 = (Integer.parseInt(str));
		String query = "select * from mvc_board1 where bId =  " + str2;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));

	}

	public void reply(final String bId, final String bName, final String bTitle, final String bContent,
			final String bGroup, final String bStep, final String bIndent) {

		replyShape(bGroup, bStep);

		String query = "insert into mvc_board1 " + "(bId, bName, bTitle, bContent, bGroup, bStep, bIndent) "
				+ " values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";

		template.update(query, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {

				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				pstmt.setInt(4, Integer.parseInt(bGroup));
				pstmt.setInt(5, Integer.parseInt(bStep) + 1);
				pstmt.setInt(6, Integer.parseInt(bIndent) + 1);
			}
		});

	}

	private void replyShape(final String strGroup, final String strStep) {

		String query = "update mvc_board1 " + " set bStep = bSTep + 1 " + " where bGroup = ? and bStep > ?";

		template.update(query, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, Integer.parseInt(strGroup));
				pstmt.setInt(2, Integer.parseInt(strStep));

			}
		});

	}

}
