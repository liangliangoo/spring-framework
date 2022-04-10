package com.xiaoxiong.entitires;

/**
 * @author xiongliang
 * @version 1.0
 * @description
 * @since 2022/4/10  12:07
 */
public class User {

	public User(Integer id, String userName, Integer age) {
		this.id = id;
		this.userName = userName;
		this.age = age;
	}

	private Integer id;
	private String userName;
	private Integer age;

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", age=" + age +
				'}';
	}
}
