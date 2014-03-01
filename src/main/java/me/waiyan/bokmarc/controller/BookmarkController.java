package me.waiyan.bokmarc.controller;

import java.awt.print.Book;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import me.waiyan.bokmarc.model.Bookmark;
import me.waiyan.bokmarc.model.Message;
import me.waiyan.bokmarc.service.BookmarkService;
import me.waiyan.bokmarc.util.BookmarkBinder;
import me.waiyan.bokmarc.util.DateGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value="/bookmarks")
public class BookmarkController {
	
	String link[]={"google.com","facebook.com","twitter.com","yahoo.com"};
	
	@Autowired
	private BookmarkBinder binder;
	@Autowired
	private BookmarkService bookmakService;
	
	private Long getUserIDFromSession(){
		return 7L;
	}
	
	/*accessing bookmarks json*/
	@RequestMapping(value="/api/{listby}", method=RequestMethod.GET)
	@ResponseBody
	public List<Bookmark> retrieve(@PathVariable(value="listby") String listby){
		System.out.println("accessing bookmarks...."+listby);
		
		if(listby.trim().equals("all"))
			return bookmakService.retrieveAllBookmarks(getUserIDFromSession());
		else
			return null;
	}
	
	/*redirecting to bookmark template page*/
	@RequestMapping(method=RequestMethod.GET)
	public String redirect(){
		System.out.println("redirecting... to bookmark");
		return "forward:/resources/bookmark.html";
	}
	
	/*accessing link page that has bookmarks*/
	@RequestMapping(value="/page/{listby}", method=RequestMethod.GET)
	public String list(@PathVariable(value="listby") String listby){
		System.out.println("pgae : "+listby);
		return "forward:/resources/templates/links.html";
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST,
			consumes={"application/x-www-form-urlencoded","application/json", "text/plain", "*/*"},
			produces={"application/json"})
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Bookmark saveBookmarks(@RequestParam(value="caption", required=false) String caption,@RequestParam("bookmarkUrl") String bookmarkUrl,
			@RequestParam(value="tags",required=false) String tags,@RequestParam(value="category", required=false) String category){
		System.out.println(caption+"-"+tags+"-"+category);
		
		//calling service and persisting the object
		Bookmark bookmark=null;
		
		try{
		bookmark= bookmakService.saveBookmark(
				binder.getNewBookmark(caption,bookmarkUrl, DateGenerator.getFormalDate(), category, tags)
				,getUserIDFromSession());
		
		System.out.println(bookmark);
		//bookmark.setUser(null);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return bookmark;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	@ResponseBody
	public void removeBookmark(@RequestParam("bookmarkID") Long bookmarkID){
		System.out.println(bookmarkID);
		
		bookmakService.removeBookmark(bookmarkID);
	}
}
