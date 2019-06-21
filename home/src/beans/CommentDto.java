package beans;

import java.sql.ResultSet;
import java.util.List;

public class CommentDto {
	private int no;
	private String writer;
	private String content;
	private String when;
	private int origin;
	
	public CommentDto () {
		
	}
	
	public CommentDto(ResultSet rs) throws Exception{
			setNo(rs.getInt("no"));
			setWriter(rs.getString("writer"));
			setContent(rs.getString("content"));
			setWhen(rs.getString("when"));
			setOrigin(rs.getInt("origin"));
	}
	
	public CommentDto(int no, String writer, String content, String when, int origin) {
		super();
		this.no = no;
		this.writer = writer;
		this.content = content;
		this.when = when;
		this.origin = origin;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public int getOrigin() {
		return origin;
	}
	public void setOrigin(int origin) {
		this.origin = origin;
	}

	@Override
	public String toString() {
		return "CommentDto [no=" + no + ", writer=" + writer + ", content=" + content + ", when=" + when + ", origin="
				+ origin + "]";
	}
	
	
}
