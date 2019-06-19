package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	
	// DB연결 메소드
	public Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","home","home");
		return conn;
	}

	// 회원가입 메소드
	public void regist(MemberDto dto) throws Exception {
		Connection conn = getConnection();
		String sql = "insert into member values(member_seq.nextval,?,?,?,?,?,?,?,sysdate,'일반',null)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, dto.getEmail());
		ps.setString(2, dto.getPw());
		ps.setString(3, dto.getName());
		ps.setString(4, dto.getBirth());
		ps.setString(5, dto.getPhone());
		ps.setString(6, dto.getQuestion());
		ps.setString(7, dto.getAnswer());
		ps.execute();
		conn.close();
	}
	
	// 로그인 메소드
	public boolean login(MemberDto dto) throws Exception {
		Connection conn = getConnection();
		String sql = "select * from member where email=? and pw=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, dto.getEmail());
		ps.setString(2, dto.getPw());
		ResultSet rs = ps.executeQuery();
		boolean result = rs.next();
		conn.close();
		return result;
	}

	// 아이디 찾기
	public String findId(MemberDto dto) throws Exception {
		Connection conn = getConnection();
		String sql = "select email from member where name=? and birth=? and phone=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, dto.getName());
		ps.setString(2, dto.getBirth());
		ps.setString(3, dto.getPhone());
		ResultSet rs = ps.executeQuery();
		
		String email;
		if(rs.next()) {
			email = rs.getString("email");
		} else {
			email = null;
		}
		return email;
	}

	// 비밀번호 찾기 메소드
	public boolean findPw(MemberDto dto) throws Exception{
		Connection conn = getConnection();
		String sql = "select * from member where email=? and question=? and answer=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, dto.getEmail());
		ps.setString(2, dto.getQuestion());
		ps.setString(3, dto.getAnswer());
		ResultSet rs = ps.executeQuery();
		boolean exist = rs.next();
	
		conn.close();
		return exist;
	}

	// 비밀번호 변경 메소드
	public void newPw(MemberDto dto) throws Exception{
		Connection conn = getConnection();
		String sql = "update member set pw=? where email=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, dto.getPw());
		ps.setString(2, dto.getEmail());
		ps.execute();
		conn.close();
	}
	
	// 나의 정보 메소드
	public MemberDto get(String email)throws Exception {
		Connection conn = getConnection();
		String sql = "select * from member where email=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		MemberDto info;
		if(rs.next()) {
			info = new MemberDto();
			info.setNo(rs.getInt("no"));
			info.setName(rs.getString("name"));
			info.setPw(rs.getString("pw"));
			info.setEmail(rs.getString("email"));
			info.setPhone(rs.getString("phone"));
			info.setQuestion(rs.getString("question"));
			info.setAnswer(rs.getString("answer"));
			info.setBirth(rs.getString("birth"));
			info.setRecent(rs.getString("recent"));
			info.setRegist(rs.getString("regist"));
			info.setAuth(rs.getString("auth"));
		} else {
			info = null;
		}
		conn.close();
		return info;
	}

	// 회원탈퇴 메소드
	public void delete(String email) throws Exception {
	Connection conn = getConnection();
	String sql = "delete member where email=?";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1, email);
	ps.execute();
	conn.close();
	}
	
	// 회원정보 수정 메소드

	public void updateInfo(MemberDto dto) throws Exception {
		Connection conn = getConnection();
		String sql = "update member set phone=?,question=?,answer=? where email=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, dto.getPhone());
		ps.setString(2, dto.getQuestion());
		ps.setString(3, dto.getAnswer());
		ps.setString(4, dto.getEmail());
		ps.execute();
		conn.close();
	}

	// 최종시간 업데이트
	public void recent(String email) throws Exception {
		Connection conn = getConnection();
		String sql = "update member set recent=sysdate where email=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		ps.execute();
		conn.close();
		
	}
	
	// 관리자 조회 메소드
	public List<MemberDto> search(String type, String keyword) throws Exception {
		Connection conn = getConnection();
		String sql = "select * from member where "+type+" like '%'||?||'%' order by " + type;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();
		List<MemberDto> list = new ArrayList<>();
		MemberDto dto = new MemberDto();
		while(rs.next()) {
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setEmail(rs.getString("email"));
			dto.setPw(rs.getString("pw"));
			dto.setBirth(rs.getString("birth"));
			dto.setQuestion(rs.getString("question"));
			dto.setAnswer(rs.getString("answer"));
			dto.setAuth(rs.getString("auth"));
			dto.setRegist(rs.getString("regist"));
			dto.setRecent(rs.getString("recent"));
			list.add(dto);
		}
		conn.close();
		return list;
	}
	
	// 회원정보 수정 메소드(관리자용)
	public void updateUser(MemberDto dto) throws Exception {
		Connection conn = getConnection();
		String sql = "update member set name=?, birth=?, phone=?, answer=?, auth=? where email=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, dto.getName());
		ps.setString(2, dto.getBirth());
		ps.setString(3, dto.getPhone());
		ps.setString(4, dto.getAnswer());
		ps.setString(5, dto.getAuth());
		ps.setString(6, dto.getEmail());
		ps.execute();
		
		conn.close();
	}

	// 비밀번호 변경 메소드(관리자)
	public void changePw(MemberDto dto) throws Exception{
		Connection conn = getConnection();
		String sql = "update member set pw = ? where email=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, dto.getPw());
		ps.setString(2, dto.getEmail());
		ps.execute();
		conn.close();
	}
}
