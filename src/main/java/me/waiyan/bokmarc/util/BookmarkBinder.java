package me.waiyan.bokmarc.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.stereotype.Component;

import me.waiyan.bokmarc.model.Bookmark;
import me.waiyan.bokmarc.model.Category;
import me.waiyan.bokmarc.model.Tag;

@Component
public class BookmarkBinder {

	public Bookmark getNewBookmark(String caption, String link, Date date,
			String category, String tag) {
		Bookmark bookmark = new Bookmark();

		bookmark.setCaption(caption);
		bookmark.setCategory(getNewCategory(category));
		bookmark.setDate(date);
		bookmark.setLink(link);
		bookmark.setTagList(getNewTagList(tag));

		return bookmark;
	}

	private Category getNewCategory(String category) {
		if(category!=null){
			Category cat = new Category();
			cat.setDescription(category);

			return cat;
		}
		else
			return null;
	}

	private List<Tag> getNewTagList(String tagStr) {
		List<Tag> tagList = new ArrayList<>();
		Tag tag = null;

		if (tagStr != null) {
			StringTokenizer tokenizer = new StringTokenizer(tagStr, ", ");
			while (tokenizer.hasMoreTokens()) {
				tag = new Tag();
				tag.setDescription(tokenizer.nextToken());

				tagList.add(tag);
			}

			return tagList;
		}
		else
			return null;
	}
}
