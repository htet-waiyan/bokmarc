package me.waiyan.bokmarc.service;

import me.waiyan.bokmarc.model.User;
import me.waiyan.bokmarc.util.user.EmailAlreadyRegisterException;

public interface UserService {
	public void addUser(User user)throws EmailAlreadyRegisterException;
}
