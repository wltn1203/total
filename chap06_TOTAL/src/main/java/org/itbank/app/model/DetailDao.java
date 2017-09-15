package org.itbank.app.model;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DetailDao {
	
	@Autowired
	SqlSessionTemplate sql;
	
	// Info 가져오기
	public Map Getinfo(String id) {
		return sql.selectOne("detail.getInfo", id);
	}
	// 개인정보 등록
	public int Upinfo(Map map) {
		return  sql.update("detail.updateOneDetail", map);
		
	}
}
