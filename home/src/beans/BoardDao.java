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

	// DB����
	// ���� ������(���� ������ ����)
//	public Connection getConnection() throws Exception{
//		Class.forName("oracle.jdbc.OracleDriver");
//		return DriverManager.getConnection(
//				"jdbc:oracle:thin:@localhost:1521:xe","home","home");
//	}
	
	// ������ ���� ���(DBCP���, �̸� ����� �ΰ� ��Ż�ϴ� ���)
	// -contexct.xml�� �ִ� Resource������ �˾ƾ߸� ��Ż�� ����
	// - static Ű���带 �ٿ��� ��� DAO�ν��Ͻ��� �������� ����
	//static DataSource src = contecx.xml�� �ִ� resource����;
	// src�� �ʱ�ȭ�Ϸ��� �ڵ尡 �����ϹǷ� ���� �ʱ�ȭ ���� ���
	// 1. ���ϰ� �ڿ��� ã�� �� �ִ� Ž�� ��ü ����
	// 2. Ž�� ��ü�� �̿��Ͽ� jdbc/oracle�̸��� ���� �ڿ������� src�� ����
	static DataSource src;
	static {
		
		try {
			Context ctx = new InitialContext(); // Ž�� ��ü ����
			src = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle"); // name�� �־������
		} catch (Exception e) {
			System.err.println("DBCP����");
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() throws Exception {
		return src.getConnection();
	}
	
	// �� ��� 
	public int write(BoardDto dto) throws Exception {
		
		// 1. ���� �� �Խñ��� ��ȣ�� ���� ���Ѵ�.
		Connection conn = getConnection();
		String sql = "select board_seq.nextval from dual";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();// ���� �����ͷ� �̵�(������ 1��)
		int no = rs.getInt("nextval");
		ps.close();
		
		// 2. ����� ���� �θ���� team ��ȣ�� �̸� ���Ѵ�.
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
		
		// 3. 1������ ���� ��ȣ�� �̿��Ͽ� �Խñ��� �߰��Ѵ�.
		// nvl(�׸�,��) : �׸��� null �϶� ������ ġȯ
		// nvl(depth+1, 0) : depth+1�� null �̸� 0���� �ٲټ���.
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
	
	// ������ �޼ҵ�
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
	
	// ��ȸ��
	public void read(int no) throws Exception {
		Connection conn = getConnection();
		String sql = "update board set read = read+1 where no=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();
		
		conn.close();
	}
	
	// �� �󼼺��� 
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
	
	// �� ���
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

	// �� ����
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

	// �� ����
	public void delete(int no) throws Exception{
		Connection conn = getConnection();
		String sql = "delete board where no=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();
		
		conn.close();
	}
	
	// �� �˻�
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
	
	// �Խñ� ������ ���ϴ� �޼ҵ�(����¡��)
	public int getCount(String type, String keyword) throws Exception {
		Connection conn = getConnection();
		
		boolean search = type!=null && keyword!=null;
		if(search) type = type.replace("+", "||");
		
		String sql = "select count(*) from board";
		if(search) sql += " where " + type + " like '%'||?||'%'";
		PreparedStatement ps = conn.prepareStatement(sql);
		if(search) ps.setString(1, keyword);
		
		ResultSet rs = ps.executeQuery();
		rs.next(); // �����ǰ���� ���´�.
		int count = rs.getInt(1);
		
		conn.close();
		return count;
	}
	
	
	
	
	
}
