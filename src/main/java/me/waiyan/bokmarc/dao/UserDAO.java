package me.waiyan.bokmarc.dao;

import me.waiyan.bokmarc.model.User;

public interface UserDAO {
	//registring user : adding user particulars to db
	public void addUser(User user);
}
