package spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import spring.entity.MemoDto;
import spring.repository.MemoDao;

public class WriteController implements Controller{
	private MemoDao memoDao;
	public void setMemoDao(MemoDao memoDao) {
		this.memoDao = memoDao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(req.getMethod().equals("GET")) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/WEB-INF/view/write.jsp");
			return mv;
		} else if(req.getMethod().equals("POST")) {
			String writer = req.getParameter("writer");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			ModelAndView mv = new ModelAndView();
			MemoDto mdto = new MemoDto();
			mdto.setWriter(writer);
			mdto.setTitle(title);
			mdto.setContent(content);
			memoDao.write(mdto);
			mv.setViewName("list");
			return mv;
		}
		return null;
	}

}
