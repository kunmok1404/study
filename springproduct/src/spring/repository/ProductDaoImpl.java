package spring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.entity.ProductDto;

public class ProductDaoImpl implements ProductDao{

	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	RowMapper<ProductDto> mapper = new RowMapper<ProductDto>() {
		@Override
		public ProductDto mapRow(ResultSet rs, int index) throws SQLException {
			ProductDto pdto = ProductDto.builder()
																.no(rs.getInt("no"))
																.name(rs.getString("name"))
																.type(rs.getString("type"))
																.price(rs.getInt("price")).build();
			return pdto;
		}
	};
		
	// 상품 등록
	@Override
	public void regist(ProductDto pdto) {
		String sql = "insert into product values(product_seq.nextval,?,?,?)";
		Object[] param = {pdto.getName(),pdto.getType(),pdto.getPrice()};
		jdbcTemplate.update(sql,param);
	}

	@Override
	public List<ProductDto> list() {
		String sql = "select * from Product order by no desc";
		List<ProductDto> list = jdbcTemplate.query(sql, mapper);
		return list;
	}

	@Override
	public ProductDto detail(int no) {
		String sql = "select * from Product where no=?";
		Object[] param = {no};
		List<ProductDto> list = jdbcTemplate.query(sql, param, mapper);
		ProductDto pdto = list.get(0);
		return pdto;
	}

}
