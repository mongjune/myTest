package org.hanja.controller;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)//스프링의 모든 Bean이 로딩
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ConTest {

	@Inject
	ApplicationContext ctx;
	
	@Inject
	DataSource ds;

	@Test
	public void test() {
		
		System.out.println(ctx);
		
	}
	
	@Test
	public void connection() throws Exception {
		
		Connection con = ds.getConnection();
		
		System.out.println(con);
		
	}

}
