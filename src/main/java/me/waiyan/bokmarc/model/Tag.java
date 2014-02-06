package me.waiyan.bokmarc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Tag")
public class Tag implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tagID")
	private Long tagID;
	
	@Column(name="description")
	private String description;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="tagList")
	private List<Bookmark> bookmarksList=new ArrayList<>();
	
	public Tag(){}

	public Long getTagID() {
		return tagID;
	}

	public void setTagID(Long tagID) {
		this.tagID = tagID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public List<Bookmark> getBookmarksList() {
		return bookmarksList;
	}

	public void setBookmarksList(List<Bookmark> bookmarksList) {
		this.bookmarksList = bookmarksList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((tagID == null) ? 0 : tagID.hashCode());
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
		Tag other = (Tag) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (tagID == null) {
			if (other.tagID != null)
				return false;
		} else if (!tagID.equals(other.tagID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tag [tagID=" + tagID + ", description=" + description + "]";
	}
	
	
}
