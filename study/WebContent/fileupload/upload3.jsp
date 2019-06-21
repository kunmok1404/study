<%@page import="jdbc.beans.FilesDao"%>
<%@page import="jdbc.beans.FilesDto"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%
 	//multipart/form-data방식으로 전송되는 데이터 수신
 	//cos.jar에서 multipartrequest, DefaultFileRenamePolicy사용
 	//MultipartRequest는 기존 request를 대체하여 사용
 	//DefaultFileRenamePolicy는 중복 파일에 대한 처리를 수행
 	
 	// [1] 파일을 어디에 저장할 것인지 정해야 함
 	// - 프로젝트 내부에 저장
 	// - 프로젝트 외부에 저장 // D:/upload
 	String path = "D:\\upload";
 	
 	// [2] 업로드 용량 제한 설정(byte)
 	int max = 10 * 1024 * 1024; // 10메가
 	
 	// [3] 업로드하는 데이터의 인코딩을 지정
 	String enc ="UTF-8";
 	
 	// [4] 파일명 중복시 처리를 담당할 객체를 생성
 	DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
 	
 	
 	// [5] 위의 정보들을 종합하여 MultipartRequest 객체를 생성
 	MultipartRequest mRequest = 
 				new MultipartRequest(request, path, max, enc,policy);
 	
 	// [6] 업로드 후 업로드된 정보들을 확인(mRequest)
 	// 기본 파라미터 : mRequest.getParameter("이름");
 	// 파일 : mRequest.getFile("이름");
 	File file = mRequest.getFile("f"); // 업로드 안했으면 file == null
 			
 	if(file != null) {
 		
 	// DB에도 파일의 정보를 저장(FilesDto 에 정보 설정 후 FilesDao 호출)
 	FilesDto fdto = new FilesDto();
 	fdto.setSaveName(mRequest.getFilesystemName("f"));
 	fdto.setUploadName(mRequest.getOriginalFileName("f"));
 	fdto.setLen(file.length());
 	fdto.setType(mRequest.getContentType("f"));
 	
 	FilesDao fdao = new FilesDao();
 	fdao.insert(fdto);
 	
 	}
 %>
 
 	<h1>업로드 완료</h1>
 	
 	<% if(file != null) { %>
 		<h1>파일 정보</h1>
 		<h2>이름 : <%= file.getName() %></h2>
 		<h2>경로 : <%= file.getAbsolutePath() %></h2>
 		<h2>크기 : <%= file.length() %> byte</h2>
 		<h2>사용자 올린 이름 : <%=mRequest.getOriginalFileName("f") %></h2>
 		<h2>파일 유형(MIME-TYPE) : <%=mRequest.getContentType("f") %></h2>
 	<% } %>