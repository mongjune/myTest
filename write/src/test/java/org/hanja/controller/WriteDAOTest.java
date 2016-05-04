package org.hanja.controller;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.hanja.domain.HanjaVO;
import org.hanja.persistence.WriteDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//스프링의 모든 Bean이 로딩
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class WriteDAOTest {
	
	@Inject
	WriteDAO dao;

	@Test
	public void test() {
		
		System.out.println(dao.getTime());
		
	}
	
	@Test
	public void getHanja() {
		
		List<HanjaVO> list = dao.getLetter(5);
		
		for (HanjaVO vo : list) {
			System.out.println(vo);
		}
		
	}

}
