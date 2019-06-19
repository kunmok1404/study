package jdbc.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
	
		// DB���� �޼ҵ�
		public Connection getConnection() throws Exception{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","study","hard");		
			return conn;
		}
		
		// ��� �޼ҵ�
		public List<PersonDto> list() throws Exception{
			
			Connection conn = this.getConnection();
			String sql = "select * from person order by no";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<PersonDto> list = new ArrayList<>();
			
			while(rs.next()) {
				PersonDto pdto = new PersonDto();
				pdto.setNo(rs.getInt("no"));
				pdto.setName(rs.getString("name"));
				pdto.setId(rs.getString("id"));
				pdto.setPw(rs.getString("pw"));
				pdto.setPoint(rs.getInt("point"));
				pdto.setWhen(rs.getString("when"));
				list.add(pdto);
			}
			conn.close();
			return list;
		}	
		
		// �α��� �޼ҵ�
		public boolean login(String id, String pw) throws Exception{
			Connection conn = this.getConnection();
			String sql = "select * from person where id = ? and pw = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			ResultSet rs = ps.executeQuery();
			boolean result = rs.next();
			conn.close();
			
			return result;	
		}
		
		// ��� �޼ҵ�
		public void regist(PersonDto dto) throws Exception{
			Connection conn = this.getConnection();
			String sql = "insert into person values(person_seq.nextval,?,?,?,0,sysdate)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPw());
			ps.execute();
			
			conn.close();
		}

		// ���� �޼ҵ�
		public void edit(PersonDto pdto) throws Exception {
			Connection conn = getConnection();
			String sql = "update person set pw = ? where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pdto.getPw());
			ps.setString(2, pdto.getId());
			ps.execute();
			
			conn.close();
		}
		
		// Ż�� �޼ҵ�
		public void exit(String id) throws Exception {
			Connection conn = getConnection();
			String sql = "delete person where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
			
			conn.close();
		}	
		
		// �˻� �޼ҵ�
		public List<PersonDto> search(String key) throws Exception {
			Connection conn = getConnection();
			String sql = "select * from person where id like '%'||?||'%'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, key);
			ResultSet rs = ps.executeQuery();
			
			List<PersonDto> list = new ArrayList<>();
			
			while(rs.next()) {
				PersonDto dto = new PersonDto();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setNo(rs.getInt("no"));
				dto.setPoint(rs.getInt("point"));
				dto.setPw(rs.getString("pw"));
				dto.setWhen(rs.getString("when"));
				list.add(dto);
			}
			conn.close();
			return list;
		}
		
		// find �޼ҵ�
		public PersonDto find(int no) throws Exception {
			
			Connection conn = getConnection();
			String sql = "select * from person where no = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs = ps.executeQuery();
	
			PersonDto dto;
			if(rs.next()) {
				dto = new PersonDto();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setNo(rs.getInt("no"));
				dto.setPoint(rs.getInt("point"));
				dto.setPw(rs.getString("pw"));
				dto.setWhen(rs.getString("when"));
			} else {
				dto = null;
			}		
			conn.close();
			return dto;
		}
	}
