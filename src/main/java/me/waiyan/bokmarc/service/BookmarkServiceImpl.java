package me.waiyan.bokmarc.service;

import java.util.List;

import me.waiyan.bokmarc.dao.BookmarkDAO;
import me.waiyan.bokmarc.model.Bookmark;
import me.waiyan.bokmarc.model.Category;
import me.waiyan.bokmarc.model.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookmarkServiceImpl implements BookmarkService{
	@Autowired
	private BookmarkDAO bookmarkDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Bookmark saveBookmark(Bookmark bookmark, Long userID) {
		// TODO Auto-generated method stub
		return bookmarkDAO.saveBookmark(bookmark, userID);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Bookmark> retrieveAllBookmarks(Long userID) {
		// TODO Auto-generated method stub
		return bookmarkDAO.getAllBookmarks(userID);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void removeBookmark(Long bookmarkID) {
		// TODO Auto-generated method stub
		bookmarkDAO.removeBookmark(bookmarkID);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Category getCategory(String desc) {
		// TODO Auto-generated method stub
		if(bookmarkDAO.getCategory(desc)!=null)
			return bookmarkDAO.getCategory(desc);
		
		else{
			Category cat=new Category();
			cat.setDescription(desc);
			
			return cat;
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Tag getTag(String desc) {
		// TODO Auto-generated method stub
		if(bookmarkDAO.getTag(desc)!=null)
			return bookmarkDAO.getTag(desc);
		
		else{
			Tag tag=new Tag();
			tag.setDescription(desc);
			
			return tag;
		}
	}
	
}
