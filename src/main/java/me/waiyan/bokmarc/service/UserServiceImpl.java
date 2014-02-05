package me.waiyan.bokmarc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import me.waiyan.bokmarc.dao.UserDAO;
import me.waiyan.bokmarc.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDAO.addUser(user);
	}

}
