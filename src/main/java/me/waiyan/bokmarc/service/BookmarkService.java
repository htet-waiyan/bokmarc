package me.waiyan.bokmarc.service;

import org.springframework.beans.factory.annotation.Autowired;

import me.waiyan.bokmarc.dao.BookmarkDAO;
import me.waiyan.bokmarc.dao.BookmarkDAOImpl;
import me.waiyan.bokmarc.model.Bookmark;

public interface BookmarkService {
	public Bookmark saveBookmark(Bookmark bookmark,Long userID);
}
