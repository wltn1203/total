package org.itbank.app.model;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	@Autowired
	SqlSessionTemplate sql;

	// 데이터베이스 등록
	public boolean addOne(Map map) {
		sql.insert("member.addBasic", map);
		sql.insert("member.addDetail", map);
		return true;
	}

	// id나 email이 머고, pass가 머인 데이터가 있는지 확인할때
	public int existOne(Map map) {
		return sql.selectOne("member.checkByIdmailAndPass", map);
	}

	// id나 email이 머고,
	public HashMap readOneByIdOrEmail(String idmail) {
		return sql.selectOne("member.readOneByIdOrEmail", idmail);
	}

	// id나 email이 머고, pass가 머인 데이터가 있는지 확인할때
	public HashMap readOneById(String id) {
		return sql.selectOne("member.readOneById", id);
	}
	
	
	public int addProfile(Map map) {
		return sql.insert("member.addProfile", map);
	}
	
	public Map readLatestProfileById(String id) {
		return sql.selectOne("member.readLatestProfileById", id);
	}
	
	public List<Map> readAllProfileById(String id) {
		return sql.selectList("member.readAllProfileById", id);
	}
	
	// 전체회원
	public List<Map> readAll() {
		return sql.selectList("member.readAll");
	}
	public List<Map> readSome(Map map) {
		return sql.selectList("member.readSome", map);
	}
	public Integer countAll() {
		return sql.selectOne("member.countAll");
	}
}












