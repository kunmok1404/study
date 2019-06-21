package home.util;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import beans.BoardDao;
import beans.BoardDto;

// ����¡ ó���� �����ϴ� Ŭ����
// ��û����(�˻��з�, �˻���, ��������ȣ, ������ũ��, ���ũ��)�� ���޹޾� ���� ������ ���
// 1. ����/���� ��Ϲ�ȣ
// 2. ����/���� �Խñ� ����
// 3. ������ �̵��� �ʿ��� �Ķ���� ���ڿ�
// 4. ���/�˻� �� �Խñ� ����
public class Paging {

	private String type;
	private String keyword;
	private String pstr;
	private int psize = 10; // ������ ǥ�ñ� ����
	private int bsize = 10; // ������ ǥ�ù�ȣ ����
	
	// ������
	public Paging(HttpServletRequest request) {
		this.type = request.getParameter("select");
		this.keyword = request.getParameter("keyword");
		this.pstr = request.getParameter("pno");
	}
	
	// getter�޼ҵ带 ���ϴ� ��ŭ ����
	public List<BoardDto> getList() {
		return list;
	}
	
	// ù������ Ȯ���� �� �ִ� getter
	public boolean isFirstBlock() {
		return this.startBlock == 1;
	}
	
	// ù���������� Ȯ���� �� �ִ� getter
	public boolean isFirstPage() {
		return this.pno == 1;
	}
		
	// ������ ������� Ȯ���� �� �ִ� getter
	public boolean isLastBlock() {
		return this.endBlock == this.pageCount;
	}
	
	// ���������������� Ȯ���� �� �ִ� getter
	public boolean isLastPage() {
		return this.pno == this.pageCount;
	}
	
	// ���� ������� �̵��ϱ� ���� �Ķ���� getter
	public String getNextBlock() {
		return "pno="+ (endBlock+1) + query; 
	}
	
	// ���� �������� �̵��ϱ� ���� �Ķ���� getter
	public String getNextPage() {
		return "pno=" + (pno + 1) + query;
	}
	
	// ���� �������� �̵��ϱ� ���� �Ķ���� getter
	public String getPrevPage() {
		return "pno=" + (pno - 1) + query;
	}
	
	// ���� ������� �̵��ϱ� ���� �Ķ���� getter
	public String getPrevBlock() {
		return "pno=" + (startBlock - 1) + query;
	}
	
	// ���� ������ ���θ� ��ȯ�ϴ� �޼ҵ�
	public boolean isCurrentPage(int i) {
		return pno == i;
	}
	
	// i�������� �̵��ϱ� ���� �Ķ���� getter
	public String getPage(int i) {
		return "pno="+i+query;
	}
	
	private boolean search;
	private int pno;
	private int start, end; //���۱�, �����
	private int count, pageCount; // ��ü�Խñ� ��, ��ü ������ ��
	private int startBlock, endBlock; // ���ۺ�Ϲ�ȣ, �����Ϲ�ȣ
	
	private List<BoardDto> list;  //�����Ͱ� ����� ����Ʈ
	private String query; // �˻� ���ڿ�
	// ��� �޼ҵ�
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
		
		// �ϴ� �׺���̼� �κ��� ���(�� �Խñ� ���� �̿��� ������ �� ���)
		// ���� : �������� = (��ü�Խñۼ�+ ��������ũ�� -1��) / ������ũ��
		BoardDao dao = new BoardDao();
		this.count = dao.getCount(type, keyword);
		this.pageCount = (count + psize - 1) / psize;
		
		this.startBlock = (pno-1)/bsize*bsize + 1;
		this.endBlock = startBlock + (bsize-1);
		// ��ȣ �Ѿ ����
		if(endBlock > pageCount){
			endBlock = pageCount;
		}

		if(type != null && type!=null) {
			list = dao.search(type,keyword,start,end);
		} else {
			list = dao.list(start,end);
		}
		
		// �˻��� ������ ���� �˻��� ���� �ƴ� ���� ÷�εǴ� �Ķ���� ó��
		// ��� : �˻��� ó�� x
		// �˻� : &type=???&keyword=??? ������ �Ķ���͸� ����
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
