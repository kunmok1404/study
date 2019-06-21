package beans;

import java.sql.ResultSet;

public class BoardDto {
	private int no;
	private String head;
	private String title;
	private String writer;
	private String content;
	private String when;
	
	private int parent;
	private int depth;
	private int team;
	
	public int getTeam() {
		return team;
	}

	public void setTeam(int team) {
		this.team = team;
	}

	public int getParent() {
		return parent;
	}

	public void setData(ResultSet rs)throws Exception {
		this.setNo(rs.getInt("no"));
		this.setHead(rs.getString("head"));
		this.setTitle(rs.getString("title"));
		this.setWriter(rs.getString("writer"));
		this.setContent(rs.getString("content"));
		this.setWhen(rs.getString("when"));
		this.setRead(rs.getInt("read"));
		// 변경된 항목 추가
		this.setParent(rs.getInt("parent"));
		this.setDepth(rs.getInt("depth"));
		this.setTeam(rs.getInt("team"));
	}
	
	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	private int read;
	
	public BoardDto() {
		
	}
	
	public BoardDto(int no, String head, String title, String writer, String content, String when, int read) {
		this.no = no;
		this.head = head;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.when = when;
		this.read = read;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWhen() {
		return when;
	}
	public void setWhen(String when) {
		this.when = when;
	}
	public int getRead() {
		return read;
	}
	public void setRead(int read) {
		this.read = read;
	}
	
	
}
