package home.util;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import beans.BoardDao;
import beans.BoardDto;

// 페이징 처리를 수행하는 클래스
// 요청정보(검색분류, 검색어, 페이지번호, 페이지크기, 블록크기)을 전달받아 다음 정보를 계산
// 1. 시작/종료 블록번호
// 2. 시작/종료 게시글 순서
// 3. 페이지 이동시 필요한 파라미터 문자열
// 4. 목록/검색 별 게시글 개수
public class Paging {

	private String type;
	private String keyword;
	private String pstr;
	private int psize = 10; // 페이지 표시글 개수
	private int bsize = 10; // 페이지 표시번호 개수
	
	// 생성자
	public Paging(HttpServletRequest request) {
		this.type = request.getParameter("select");
		this.keyword = request.getParameter("keyword");
		this.pstr = request.getParameter("pno");
	}
	
	// getter메소드를 원하는 만큼 구현
	public List<BoardDto> getList() {
		return list;
	}
	
	// 첫블럭인지 확인할 수 있는 getter
	public boolean isFirstBlock() {
		return this.startBlock == 1;
	}
	
	// 첫페이지인지 확인할 수 있는 getter
	public boolean isFirstPage() {
		return this.pno == 1;
	}
		
	// 마지막 블록인지 확인할 수 있는 getter
	public boolean isLastBlock() {
		return this.endBlock == this.pageCount;
	}
	
	// 마지막페이지인지 확인할 수 있는 getter
	public boolean isLastPage() {
		return this.pno == this.pageCount;
	}
	
	// 다음 블록으로 이동하기 위한 파라미터 getter
	public String getNextBlock() {
		return "pno="+ (endBlock+1) + query; 
	}
	
	// 다음 페이지로 이동하기 위한 파라미터 getter
	public String getNextPage() {
		return "pno=" + (pno + 1) + query;
	}
	
	// 이전 페이지로 이동하기 위한 파라미터 getter
	public String getPrevPage() {
		return "pno=" + (pno - 1) + query;
	}
	
	// 이전 블록으로 이동하기 위한 파라미터 getter
	public String getPrevBlock() {
		return "pno=" + (startBlock - 1) + query;
	}
	
	// 현재 페이지 여부를 반환하는 메소드
	public boolean isCurrentPage(int i) {
		return pno == i;
	}
	
	// i페이지로 이동하기 위한 파라미터 getter
	public String getPage(int i) {
		return "pno="+i+query;
	}
	
	private boolean search;
	private int pno;
	private int start, end; //시작글, 종료글
	private int count, pageCount; // 전체게시글 수, 전체 페이지 수
	private int startBlock, endBlock; // 시작블록번호, 종료블록번호
	
	private List<BoardDto> list;  //데이터가 저장된 리스트
	private String query; // 검색 문자열
	// 계산 메소드
	public void calculate() throws Exception{

		this.search = type!=null && keyword!=null;
		
		try{
			pno = Integer.parseInt(pstr);
			if(pno<=0) throw new Exception();
		} catch(Exception e){
			pno = 1;
		}
		
		this.end = pno * psize;
		this.start = end-(psize-1);
		
		// 하단 네비게이션 부분을 계산(총 게시글 수를 이용한 페이지 수 계산)
		// 공식 : 페이지수 = (전체게시글수+ （페이지크기 -1）) / 페이지크기
		BoardDao dao = new BoardDao();
		this.count = dao.getCount(type, keyword);
		this.pageCount = (count + psize - 1) / psize;
		
		this.startBlock = (pno-1)/bsize*bsize + 1;
		this.endBlock = startBlock + (bsize-1);
		// 번호 넘어감 방지
		if(endBlock > pageCount){
			endBlock = pageCount;
		}

		if(type != null && type!=null) {
			list = dao.search(type,keyword,start,end);
		} else {
			list = dao.list(start,end);
		}
		
		// 검색어 유지를 위해 검색일 때와 아닐 때의 첨부되는 파라미터 처리
		// 목록 : 검색어 처리 x
		// 검색 : &type=???&keyword=??? 형태의 파라미터를 생성
		if(search) {
			String tmp = URLEncoder.encode(type, "UTF-8");
			this.query = "&type=" + tmp + "&keyword=" + keyword;
		} else {
			this.query ="";
		}
	}

	public String getType() {
		return type;
	}

	public String getKeyword() {
		return keyword;
	}

	public String getPstr() {
		return pstr;
	}

	public int getPsize() {
		return psize;
	}

	public int getBsize() {
		return bsize;
	}

	public boolean isSearch() {
		return search;
	}

	public int getPno() {
		return pno;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int getCount() {
		return count;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getStartBlock() {
		return startBlock;
	}

	public int getEndBlock() {
		return endBlock;
	}

	public String getQuery() {
		return query;
	}

	@Override
	public String toString() {
		return "Paging [type=" + type + ", keyword=" + keyword + ", pstr=" + pstr + ", psize=" + psize + ", bsize="
				+ bsize + ", search=" + search + ", pno=" + pno + ", start=" + start + ", end=" + end + ", count="
				+ count + ", pageCount=" + pageCount + ", startBlock=" + startBlock + ", endBlock=" + endBlock + "]";
	}
	
	
}
