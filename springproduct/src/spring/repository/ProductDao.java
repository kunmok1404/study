package spring.repository;

import java.util.List;

import spring.entity.ProductDto;

public interface ProductDao {
	void regist(ProductDto pdto);
	List<ProductDto> list();
	ProductDto detail(int no);
}
