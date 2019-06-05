package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
	
//	���Ḹ ó���ؼ� ��ȯ�ϴ� �޼ҵ�
	public Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "hard");
		return con;
	}
	
//	��� �޼ҵ�
	public List<PersonDto> list() throws Exception{
		Connection con = this.getConnection();
		
		String sql = "select * from person order by no";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
//		���� ���� ���� List�� rs�� �����͸� �ű���
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
	
//	�˻� �޼ҵ�
	public List<PersonDto> search(String id) throws Exception{
		Connection con = this.getConnection();
		
		String sql = "select * from person "
				+ "where id like '%'||?||'%' order by no";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
//		���� ���� ���� List�� rs�� �����͸� �ű���
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

//	�α��� �޼ҵ�
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

//	��� �޼ҵ�
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
	
//	���� �޼ҵ�(edit)
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
	
//	ȸ������ �˻� �޼ҵ�
	public PersonDto find(int no) throws Exception{
		Connection con = getConnection();

		String sql = "select * from person where no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ResultSet rs = ps.executeQuery();
		
//		PersonDto pdto = null or ��ü;
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





















