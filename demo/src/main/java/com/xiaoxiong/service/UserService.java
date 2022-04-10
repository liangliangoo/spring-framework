package com.xiaoxiong.service;

import com.xiaoxiong.entitires.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiongliang
 * @version 1.0
 * @description 模拟service
 * @since 2022/4/10  12:06
 */
@Service
public class UserService {

	private static final Map<Integer, User> userDao;

	static {
		userDao = new HashMap<>();
		userDao.put(1, new User(1, "xiaoxiong", 19));
		userDao.put(2, new User(2, "xiaojiang", 19));
	}

	public User findUserById(Integer id) {
		return userDao.getOrDefault(id, null);
	}

	public List<User> findAll() {
		return new ArrayList<>(userDao.values());
	}


}
