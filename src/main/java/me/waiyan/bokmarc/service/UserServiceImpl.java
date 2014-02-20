package me.waiyan.bokmarc.service;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import me.waiyan.bokmarc.dao.UserDAO;
import me.waiyan.bokmarc.model.User;
import me.waiyan.bokmarc.util.user.EmailAlreadyRegisterException;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addUser(User user)throws EmailAlreadyRegisterException {
		// TODO Auto-generated method stub
		try{
			userDAO.addUser(user);
		}
		catch(ConstraintViolationException ce){
			throw new EmailAlreadyRegisterException("This email is already registered");
		}
	}

}
