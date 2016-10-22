package com.mb.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mb.config.User;
import com.mb.config.UserDao;

public class MybatisMain {

	public static final void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sqlSessionFactory.openSession();
		UserDao userDao = session.getMapper(UserDao.class);
		MybatisMain.insert(userDao);
		MybatisMain.selectAll(userDao);
		session.commit();
		session.close();
	}
	
	public static void insert(UserDao userDao){
		User user = new User();
//		user.setUserName("first");
		user.setUserName("第一个");
		userDao.insert(user);
		User user2 = new User();
		user2.setUserName("second");
		userDao.insert(user2);
		List<User> list = userDao.selectAll();
		System.out.println("list: " + list);
	}
	
	public static void selectAll(UserDao userDao){
		List<User> list = userDao.selectAll();
		System.out.println("list: " + list);
	}
}
