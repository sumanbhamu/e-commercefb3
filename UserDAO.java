package com.suman.shopping.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.suman.shopping.model.User;

@Repository

public interface UserDAO {

	public boolean isValidate(String name, String pass);

	public boolean saveOrUpdate(User user);

	public boolean delete(User user);

	public User get(int id);

	public List<User> list();

}
