package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CommentDao {
	
	// DB¡¢º”
	static DataSource src;
	static {
		
		try {
			Context ctx = new InitialContext(); // ≈ΩªÁ ∞¥√º ª˝º∫
			src = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle"); // name¿ª ≥÷æÓ¡‡æﬂ«‘
		} catch (Exception e) {
			System.err.println("DBCPø°∑Ø");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws Exception {
		return src.getConnection();
	}
	
	// ¥Ò±€ µÓ∑œ ∏ﬁº“µÂ
	public void comm_regist(CommentDto dto) throws Exception {
		Connection conn = getConnection();
		String sql = "insert into comments values(comment_seq.nextval, ?,?,sysdate,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, dto.getWriter());
		ps.setString(2, dto.getContent());
		ps.setInt(3, dto.getOrigin());
		
		ps.execute();
		conn.close();
	}
	
	// ¥Ò±€ ∏Ò∑œ
	public List<CommentDto> get(int origin) throws Exception {
		Connection conn = getConnection();
		String sql = "select * from comments where origin = ? order by when asc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, origin);
		ResultSet rs = ps.executeQuery();
		
		List<CommentDto> list = new ArrayList<>();
		while(rs.next()) {
			CommentDto dto = new CommentDto(rs);
			list.add(dto);
		}
		
		conn.close();
		return list;
	}

	// ¥Ò±€ ªË¡¶
	public void delete(int cno) throws Exception{
		Connection conn = getConnection();
		String sql = "delete comments where no = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, cno);
		ps.execute();
		
		conn.close();
	}
	
	public int deletes(int no) throws Exception {
		Connection conn = getConnection();
		String sql = "select origin from comments where no = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, no);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int origin = rs.getInt("origin");
		ps.close();
		
		sql="delete comments where no=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();
		
		conn.close();
		return origin;
	}
}
