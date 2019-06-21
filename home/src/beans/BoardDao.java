package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDao {

	// DB연결
	// 과거 연결방식(직접 연결을 생성)
//	public Connection getConnection() throws Exception{
//		Class.forName("oracle.jdbc.OracleDriver");
//		return DriverManager.getConnection(
//				"jdbc:oracle:thin:@localhost:1521:xe","home","home");
//	}
	
	// 개선된 연결 방식(DBCP방식, 미리 만들어 두고 렌탈하는 방식)
	// -contexct.xml에 있는 Resource정보를 알아야만 렌탈이 가능
	// - static 키워드를 붙여서 모든 DAO인스턴스에 공용으로 적용
	//static DataSource src = contecx.xml에 있는 resource정보;
	// src를 초기화하려면 코드가 복잡하므로 전용 초기화 구문 사용
	// 1. 파일과 자원을 찾을 수 있는 탐사 객체 생성
	// 2. 탐사 객체를 이용하여 jdbc/oracle이름을 가진 자원정보를 src에 대입
	static DataSource src;
	static {
		
		try {
			Context ctx = new InitialContext(); // 탐사 객체 생성
			src = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle"); // name을 넣어줘야함
		} catch (Exception e) {
			System.err.println("DBCP에러");
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() throws Exception {
		return src.getConnection();
	}
	
	// 글 등록 
	public int write(BoardDto dto) throws Exception {
		
		// 1. 현재 들어갈 게시글의 번호를 먼저 구한다.
		Connection conn = getConnection();
		String sql = "select board_seq.nextval from dual";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();// 다음 데이터로 이동(무조건 1개)
		int no = rs.getInt("nextval");
		ps.close();
		
		// 2. 답글일 경우는 부모글의 team 번호를 미리 구한다.
		int team;
		if(dto.getParent() == 0) {
			team = no;
		} else {
			sql = "select team from board where no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getParent());
			rs = ps.executeQuery();
			rs.next();
			team = rs.getInt("team");
			ps.close();	
		}
		
		// 3. 1번에서 구한 번호를 이용하여 게시글을 추가한다.
		// nvl(항목,값) : 항목이 null 일때 값으로 치환
		// nvl(depth+1, 0) : depth+1이 null 이면 0으로 바꾸세요.
		sql ="insert into board values(?,?,?,?,?,sysdate,0,?,(select nvl(depth,0)+1 from board where no=?),?)";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, no);
		ps.setString(2, dto.getHead());
		ps.setString(3, dto.getTitle());
		ps.setString(4, dto.getWriter());
		ps.setString(5, dto.getContent());
		if(dto.getParent()==0) {
			ps.setNull(6, Types.INTEGER);;
		} else {
			ps.setInt(6, dto.getParent());
		}
		ps.setInt(7, dto.getParent());
		ps.setInt(8, team);
		ps.execute();
		
		conn.close();
		return no;
	}
	
	// 시퀀스 메소드
	public int getseq() throws Exception {
		Connection conn = getConnection();
		String sql = "select board_seq.nextval from dual";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs =  ps.executeQuery();
		int seq = 0;
		if(rs.next()) {
			seq = rs.getInt("nextval");
		} 
		return seq;
	}
	
	// 조회수
	public void read(int no) throws Exception {
		Connection conn = getConnection();
		String sql = "update board set read = read+1 where no=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();
		
		conn.close();
	}
	
	// 글 상세보기 
	public BoardDto content(int no)throws Exception{
		Connection conn = getConnection();
		String sql = "select * from board where no=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, no);
		ResultSet rs = ps.executeQuery();
		BoardDto dto = null;
		if(rs.next()) {
			dto = new BoardDto();
			dto.setData(rs);
		} else {
			dto = null;
		}
		conn.close();
		return dto;
	}
	
	// 글 목록
	public List<BoardDto> list(int start, int end) throws Exception {
		Connection conn = getConnection();
		String sql = "select * from (select rownum r, A.* from("
				+   "select * from board "
				+ "connect by prior no=parent "
				+ "start with parent is null "
				+ "order siblings by team desc, no asc" 
				+   ")A"
				+   " ) where r between ? and ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
		ResultSet rs = ps.executeQuery();
		
		List<BoardDto> list = new ArrayList<>();
		
		while(rs.next()) {
			BoardDto dto = new BoardDto();
			dto.setData(rs);
			list.add(dto);
		}
		conn.close();
		return list;
	}

	// 글 수정
	public void edit(BoardDto dto) throws Exception{
		Connection conn = getConnection();
		String sql = "update board set head=?, title=?, content=? where no=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, dto.getHead());
		ps.setString(2, dto.getTitle());
		ps.setString(3, dto.getContent());
		ps.setInt(4, dto.getNo());
		ps.execute();
		
		conn.close();
	}

	// 글 삭제
	public void delete(int no) throws Exception{
		Connection conn = getConnection();
		String sql = "delete board where no=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();
		
		conn.close();
	}
	
	// 글 검색
	public List<BoardDto> search(String type, String keyword, int start, int end) throws Exception {
		Connection conn = getConnection();
		String sql = "select * from (select rownum r, A.* from("
				+   "select * from board where "+type+" like '%'||?||'%'" 
				+   ")A"
				+   " ) where r between ? and ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, keyword);
		ps.setInt(2, start);
		ps.setInt(3, end);
		ResultSet rs = ps.executeQuery();
		
		List<BoardDto> search_list = new ArrayList<>();
		
		while(rs.next()) {
			BoardDto dto = new BoardDto();
			dto.setData(rs);
			search_list.add(dto);
		}
		conn.close();
		return search_list;
	}
	
	// 게시글 개수를 구하는 메소드(페이징용)
	public int getCount(String type, String keyword) throws Exception {
		Connection conn = getConnection();
		
		boolean search = type!=null && keyword!=null;
		if(search) type = type.replace("+", "||");
		
		String sql = "select count(*) from board";
		if(search) sql += " where " + type + " like '%'||?||'%'";
		PreparedStatement ps = conn.prepareStatement(sql);
		if(search) ps.setString(1, keyword);
		
		ResultSet rs = ps.executeQuery();
		rs.next(); // 무조건결과값 나온다.
		int count = rs.getInt(1);
		
		conn.close();
		return count;
	}
	
	
	
	
	
}
