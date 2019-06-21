package jdbc.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class FilesDao {

	static DataSource src;
	static {
		
		try {
			Context ctx = new InitialContext();
			src = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle"); // name을 넣어줘야함
		} catch (Exception e) {
			System.err.println("DBCP에러");
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() throws Exception {
		return src.getConnection();
	}
	
	// 파일 업로드
	public void insert(FilesDto fdto) throws Exception {
		Connection conn = getConnection();
		String sql ="insert into files values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, fdto.getSaveName());
		ps.setString(2, fdto.getUploadName());
		ps.setLong(3, fdto.getLen());
		ps.setString(4, fdto.getType());
		ps.execute();
		conn.close();
	}
	
	// 전체 조회
	public List<FilesDto> list() throws Exception {
		Connection conn = getConnection();
		String sql = "select * from files order by savename";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<FilesDto> list = new ArrayList<>();
		while(rs.next()) {
			FilesDto dto = new FilesDto(rs);
			list.add(dto);
		}
		conn.close();
		return list;
	}
	
	// 한개 조회
	public FilesDto get(String savename) throws Exception {
		Connection conn = getConnection();
		String sql = "select * from files where savename=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, savename);
		ResultSet rs = ps.executeQuery();
		
		FilesDto fdto;
		if(rs.next())	fdto = new FilesDto(rs);
		else fdto = null;
		conn.close();
		return fdto;
	}
	
	// 삭제
	public void delete(String savename) throws Exception {
		Connection conn = getConnection();
		String sql = "delete files where savename=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, savename);
		ps.execute();
		conn.close();
	}
}
