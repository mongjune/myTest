package org.hanja.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.hanja.domain.HanjaVO;
import org.springframework.stereotype.Repository;

@Repository
public class WriteDAO {
	
	@Inject
	DataSource ds;

	@Inject
	SqlSession session;

	private final String path = "org.hanja.persistence.writeMapper";
	
	public String getTime() {
		return session.selectOne(path + ".getNow");
	}
	
	public List<HanjaVO> getLetter(int wNum) {
		return session.selectList(path + ".getHanja", wNum);
	}

}
