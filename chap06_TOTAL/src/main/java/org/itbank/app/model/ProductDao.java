package org.itbank.app.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {

	@Autowired
	SqlSessionTemplate sql;
	
	
	public int addNew(Map map) {
		int r = sql.insert("product.addNew", map);
		return r;
	}
	
	public List<Map> getAll() {
		return sql.selectList("product.getAll");
	}
	
	public List<Map> searchSome(Map p) {
		return sql.selectList("product.searchBySprice", p);
	}
	
	public HashMap getOne(String num) {
		HashMap r = sql.selectOne("product.getOne", num);
		return r;
	}
}



