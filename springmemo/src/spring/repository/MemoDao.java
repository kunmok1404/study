package spring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.entity.MemoDto;

public class MemoDao {
	
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	RowMapper<MemoDto> mapper = new RowMapper<MemoDto>() {
		@Override
		public MemoDto mapRow(ResultSet rs, int index) throws SQLException {
			MemoDto mdto = new MemoDto();
			mdto.setId(rs.getInt("id"));
			mdto.setWriter(rs.getString("writer"));
			mdto.setTitle(rs.getString("title"));
			mdto.setContent(rs.getString("content"));
			mdto.setRegist_date(rs.getString("regist_date"));
			return mdto;
		}
	};

	// 메모 등록
	public void write(MemoDto mdto) {
		String sql = "insert into memo values(memo_seq.nextval,?,?,?,sysdate)";
		Object[] param = {mdto.getWriter(),mdto.getTitle(),mdto.getContent()};
		jdbcTemplate.update(sql,param);
	}

	// 메모 목록
	public List<MemoDto> list() {
		String sql = "select * from memo";
		List<MemoDto> list = jdbcTemplate.query(sql, mapper);
		return list;
	}

	
}
