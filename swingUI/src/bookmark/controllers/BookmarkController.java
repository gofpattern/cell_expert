package bookmark.controllers;

import bookmark.dao.FileDaoDelegate;
import bookmark.model.BookMarkForm;

public class BookmarkController {
	
	
	FileDaoDelegate delegate = new FileDaoDelegate();
	
	
	public void addBookMark(BookMarkForm bookmark){
		
		delegate.saveBookmarks(bookmark);
		
	}

	

}
