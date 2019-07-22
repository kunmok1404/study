package spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import spring.repository.ProductDao;

public class ListController implements Controller{

	ProductDao productDao;
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", productDao.list());
		mv.setViewName("/WEB-INF/view/list.jsp");
		return mv;
	}

}
