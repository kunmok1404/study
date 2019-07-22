package spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import spring.entity.ProductDto;
import spring.repository.ProductDao;

public class DetailController implements Controller{

	private ProductDao productDao;
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		int no = Integer.parseInt(req.getParameter("no"));
		ModelAndView mv = new ModelAndView();
		mv.addObject("pdto",productDao.detail(no));
		mv.setViewName("/WEB-INF/view/detail.jsp");
		return mv;
	}

}
