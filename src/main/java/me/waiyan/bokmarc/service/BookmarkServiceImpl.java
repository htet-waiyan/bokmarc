package me.waiyan.bokmarc.service;

import me.waiyan.bokmarc.dao.BookmarkDAO;
import me.waiyan.bokmarc.model.Bookmark;

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
	
}
