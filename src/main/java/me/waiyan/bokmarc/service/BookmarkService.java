package me.waiyan.bokmarc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import me.waiyan.bokmarc.dao.BookmarkDAO;
import me.waiyan.bokmarc.dao.BookmarkDAOImpl;
import me.waiyan.bokmarc.model.Bookmark;
import me.waiyan.bokmarc.model.Category;
import me.waiyan.bokmarc.model.Tag;

public interface BookmarkService {
	public Bookmark saveBookmark(Bookmark bookmark,Long userID);
	public List<Bookmark> retrieveAllBookmarks(Long userID);
	public void removeBookmark(Long bookmarkID);
	
	public Category getCategory(String desc);
	public Tag getTag(String tags);
}
