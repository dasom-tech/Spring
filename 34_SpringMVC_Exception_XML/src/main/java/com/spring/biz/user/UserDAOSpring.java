package com.spring.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String USER_GET
		= "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	
	public UserDAOSpring() {
		System.out.println(">> UserDAOSpring() 객체 생성");
	}
	
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Spring JDBC(JdbcTemplate)로 getUser() 실행");
		UserVO user = null;
		
		Object[] args = { vo.getId(), vo.getPassword() };
		return jdbcTemplate.queryForObject(USER_GET, 
				args, new UserRowMapper());
	}	

}
