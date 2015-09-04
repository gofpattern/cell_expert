package bookmark.controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bookmark.dao.FileDaoDelegate;

/**
 * custom Action listener for all delete operation
 * 
 * @author ahafeez
 * 
 */
public class BookMarkDeleteBtnListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {

		String key = e.getActionCommand();
		System.out.println(key);
		System.out.println(e.getID());
		String url = FileDaoDelegate.getUrl(key);
		System.out.println("Deleting the key:"+key+ " : " +url);

		FileDaoDelegate.deleteUrl(key);

	}

}
