package me.waiyan.bokmarc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.waiyan.bokmarc.model.Bookmark;
import me.waiyan.bokmarc.model.User;

@Repository
public class BookmarkDAOImpl implements BookmarkDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Bookmark saveBookmark(Bookmark bookmark, Long userID) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		bookmark.setUser(getUserBy(userID));
		
		session.save(bookmark);
		System.out.println(bookmark.getBookmarkID());
		
		return bookmark;
	}
	
	public User getUserBy(Long id){
		Session session=sessionFactory.getCurrentSession();
		
		User user=(User) session.get(User.class, id);
		
		return user;
	}

}
