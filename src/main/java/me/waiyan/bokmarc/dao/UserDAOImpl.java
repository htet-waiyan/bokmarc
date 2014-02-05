package me.waiyan.bokmarc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.waiyan.bokmarc.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		
		session.save(user);
	}

}
