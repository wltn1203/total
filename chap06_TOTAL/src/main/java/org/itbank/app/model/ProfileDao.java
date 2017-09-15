package org.itbank.app.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileDao {

	@Autowired
	SqlSessionTemplate sql;
	
	// DB 등록
	public boolean addOne(Map map) {
		sql.insert("profile.addBasic", map);
		return true;
	}
	
	// 히스토리 목록
	public List<Map> readAll(String id){
		return sql.selectList("profile.readAll", id);
	}
	
	// 대표이미지 설정
	public HashMap readOne(String url) {
		HashMap hm = sql.selectOne("profile.readOne", url);
		return hm;
	}
	
	
	
}
