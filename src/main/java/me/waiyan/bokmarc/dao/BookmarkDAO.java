package me.waiyan.bokmarc.dao;

import java.util.List;

import me.waiyan.bokmarc.model.Bookmark;
import me.waiyan.bokmarc.model.Category;
import me.waiyan.bokmarc.model.Tag;

public interface BookmarkDAO {
	public Bookmark saveBookmark(Bookmark bookmark,Long userID);
	public List<Bookmark> getAllBookmarks(Long userID);
	public List<Bookmark> getBookmarks(Long userID,String category);
	
	public void removeBookmark(Long bookmarkID);
	public Category getCategory(String dec);
	public Tag getTag(String tag);
}
