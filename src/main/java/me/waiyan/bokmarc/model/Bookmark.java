package me.waiyan.bokmarc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Bookmark")
public class Bookmark {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bookmarkID")
	private Long bookmarkID;
	
	@Column(name="caption")
	private String caption;
	
	@Column(name="url")
	private String link;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	private Date date;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="categoryID")
	private Category category;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="userID")
	private User user;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
			name="BookmarkTagDetail",
			joinColumns={@JoinColumn(name="bookmarkID")},
			inverseJoinColumns={@JoinColumn(name="tagID")}
	)
	private List<Tag> tagList=new ArrayList<>();
	
	public Bookmark(){}

	public Long getBookmarkID() {
		return bookmarkID;
	}

	public void setBookmarkID(Long bookmarkID) {
		this.bookmarkID = bookmarkID;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption=caption;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bookmarkID == null) ? 0 : bookmarkID.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((caption == null) ? 0 : caption.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bookmark other = (Bookmark) obj;
		if (bookmarkID == null) {
			if (other.bookmarkID != null)
				return false;
		} else if (!bookmarkID.equals(other.bookmarkID))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (caption == null) {
			if (other.caption != null)
				return false;
		} else if (!caption.equals(other.caption))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bookmark [bookmarkID=" + bookmarkID + ", desc=" + caption
				+ ", link=" + link + ", date=" + date + "]";
	}
}
