package me.waiyan.bokmarc.dao;

import org.hibernate.exception.ConstraintViolationException;

import me.waiyan.bokmarc.model.User;

public interface UserDAO {
	//registring user : adding user particulars to db
	public void addUser(User user);
}
