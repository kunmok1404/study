package beans;

public class BoardDto {
	private int no;
	private String head;
	private String title;
	private String writer;
	private String content;
	private String when;
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
