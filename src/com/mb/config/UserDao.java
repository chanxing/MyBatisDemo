package com.mb.config;

import java.util.List;

public interface UserDao {
	public int insert(User user);

	public List<User> selectAll();
}
