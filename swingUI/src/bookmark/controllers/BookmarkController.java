package bookmark.controllers;

import java.util.List;

import bookmark.dao.FileDaoDelegate;
import bookmark.model.BookMarkForm;

public class BookmarkController {
	
	
	FileDaoDelegate delegate = new FileDaoDelegate();
	
	
	public void addBookMark(BookMarkForm bookmark){
		
		delegate.saveBookmarks(bookmark);
		
	}
	
	public void addBookMark(List<BookMarkForm> bookmarkList){
		
		delegate.saveBookmarks(bookmarkList);
		
	}

	

}
