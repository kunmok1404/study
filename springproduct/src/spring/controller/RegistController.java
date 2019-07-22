package spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import spring.entity.ProductDto;
import spring.repository.ProductDao;

public class RegistController implements Controller{

	private ProductDao productDao;
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		if(req.getMethod().equals("GET")) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/WEB-INF/view/regist.jsp");
			return mv;
		} else if(req.getMethod().equals("POST")) {
			String name = req.getParameter("name");
			String type = req.getParameter("type");
			int price = Integer.parseInt(req.getParameter("price"));
			ModelAndView mv = new ModelAndView();
			ProductDto pdto = ProductDto.builder()
																.name(name)
																.type(type)
																.price(price).build();
			productDao.regist(pdto);
			mv.setViewName("redirect:/list");
			return mv;
		}
		return null;
	}

}
