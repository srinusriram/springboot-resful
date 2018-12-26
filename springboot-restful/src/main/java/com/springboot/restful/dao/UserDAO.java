package com.springboot.restful.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.restful.model.User;

@Component
public class UserDAO {

	private static List<User> users = new ArrayList<>();

	private static int usersCount = 3;

	static {
		users.add(new User(1, "Saibaba", new Date()));
		users.add(new User(2, "Srinivas", new Date()));
		users.add(new User(3, "Mantrala", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User findOne(int id)
	{
		for (User user : users) {
			if (user.getId() == id)
				return user;
		}
		return null;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}

	public User deleteUserById(int id) {
		Iterator<User> iterator = users.iterator();

		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
