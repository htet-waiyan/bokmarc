package me.waiyan.bokmarc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.waiyan.bokmarc.model.Bookmark;
import me.waiyan.bokmarc.model.Category;
import me.waiyan.bokmarc.model.Tag;
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
		
		session.saveOrUpdate(bookmark);
		System.out.println(bookmark.getBookmarkID());
		
		return bookmark;
	}
	
	public User getUserBy(Long id){
		Session session=sessionFactory.getCurrentSession();
		
		User user=(User) session.get(User.class, id);
		
		return user;
	}
	
	@Override
	public Category getCategory(String caption){
		Session session=sessionFactory.getCurrentSession();
		
		List<Category> catList=session.createCriteria(Category.class).add(Restrictions.eq("description", caption)).list();
		
		if(catList.size()>0)
			return catList.get(0);
		
		return null;
	}
	
	@Override
	public Tag getTag(String desc){
		Session session=sessionFactory.getCurrentSession();
		List<Tag> tagList=session.createCriteria(Tag.class).
				add(Restrictions.eq("description", desc)).list();
		
		if(tagList.size()>0)
			return tagList.get(0);
		
		return null;
	}

	@Override
	public List<Bookmark> getAllBookmarks(Long userID) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		List<Bookmark> bookmarkList=session.createCriteria(Bookmark.class)
				.createCriteria("user").
				add(Restrictions.eq("userID", userID)).list();
		
		return bookmarkList;
	}

	@Override
	public List<Bookmark> getBookmarks(Long userID, String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBookmark(Long bookmarkID) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		
		if(session.get(Bookmark.class, bookmarkID)!=null)
			session.delete(session.get(Bookmark.class, bookmarkID));
	}

}
