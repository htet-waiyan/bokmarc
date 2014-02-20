package me.waiyan.bokmarc.dao;

import java.util.List;

import me.waiyan.bokmarc.model.Bookmark;

public interface BookmarkDAO {
	public Bookmark saveBookmark(Bookmark bookmark,Long userID);
}
