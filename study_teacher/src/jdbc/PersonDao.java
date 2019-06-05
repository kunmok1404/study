package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
	
//	연결만 처리해서 반환하는 메소드
	public Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "hard");
		return con;
	}
	
//	목록 메소드
	public List<PersonDto> list() throws Exception{
		Connection con = this.getConnection();
		
		String sql = "select * from person order by no";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
//		연결 종료 전에 List에 rs의 데이터를 옮기자
		List<PersonDto> list = new ArrayList<>();
		
		while(rs.next()) {
//			rs ---> PersonDto ---> list
			PersonDto pdto = new PersonDto();
			pdto.setNo(rs.getInt("no"));
			pdto.setId(rs.getString("id"));
			pdto.setPw(rs.getString("pw"));
			pdto.setName(rs.getString("name"));
			pdto.setPoint(rs.getInt("point"));
			pdto.setWhen(rs.getString("when"));
			
			list.add(pdto);
		}
		
		con.close();
		return list;
	}
	
//	검색 메소드
	public List<PersonDto> search(String id) throws Exception{
		Connection con = this.getConnection();
		
		String sql = "select * from person "
				+ "where id like '%'||?||'%' order by no";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
//		연결 종료 전에 List에 rs의 데이터를 옮기자
		List<PersonDto> list = new ArrayList<>();
		
		while(rs.next()) {
//			rs ---> PersonDto ---> list
			PersonDto pdto = new PersonDto();
			pdto.setNo(rs.getInt("no"));
			pdto.setId(rs.getString("id"));
			pdto.setPw(rs.getString("pw"));
			pdto.setName(rs.getString("name"));
			pdto.setPoint(rs.getInt("point"));
			pdto.setWhen(rs.getString("when"));
			
			list.add(pdto);
		}
		
		con.close();
		return list;
	}

//	로그인 메소드
	public boolean login(String id, String pw) throws Exception{
		Connection con = this.getConnection();
		
		String sql = "select * from person where id=? and pw=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		ResultSet rs = ps.executeQuery();
		boolean result = rs.next();
		con.close();
		
//		if(result) 
//			return true;
//		else 
//			return false;
		return result;
	}

//	등록 메소드
	public void regist(PersonDto pdto) throws Exception{
		Connection con = getConnection();
		
		String sql = "insert into person values("
						+ "person_seq.nextval, ?, ?, ?, 0, sysdate)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, pdto.getId());
		ps.setString(2, pdto.getPw());
		ps.setString(3, pdto.getName());
		ps.execute();
		
		con.close();
	}
	
//	수정 메소드(edit)
	public void edit(String id, String npw) throws Exception{
		Connection con = this.getConnection();
		
		String sql = "update person set pw=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, npw);
		ps.setString(2, id);
		ps.execute();
		
		con.close();
	}
	
	public void edit(PersonDto pdto) throws Exception{
		Connection con = this.getConnection();
		
		String sql = "update person set pw=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, pdto.getPw());
		ps.setString(2, pdto.getId());
		ps.execute();
		
		con.close();
	}

	public void exit(PersonDto pdto) throws Exception{
		Connection con = getConnection();
		
		String sql = "delete person where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, pdto.getId());
		ps.execute();
		
		con.close();
	}
	
//	회원정보 검색 메소드
	public PersonDto find(int no) throws Exception{
		Connection con = getConnection();

		String sql = "select * from person where no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ResultSet rs = ps.executeQuery();
		
//		PersonDto pdto = null or 객체;
		PersonDto pdto;
		if(rs.next()) {
			pdto = new PersonDto();
			pdto.setNo(rs.getInt("no"));
			pdto.setId(rs.getString("id"));
			pdto.setPw(rs.getString("pw"));
			pdto.setName(rs.getString("name"));
			pdto.setPoint(rs.getInt("point"));
			pdto.setWhen(rs.getString("when"));
		}
		else {
			pdto = null;
		}
		
		con.close();
		return pdto;
	}
}





















