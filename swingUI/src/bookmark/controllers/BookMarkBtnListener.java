package bookmark.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import bookmark.button.opener.URLopener;
import bookmark.dao.FileDaoDelegate;

public class BookMarkBtnListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		String key = e.getActionCommand();
		
		System.out.println(e.getActionCommand());
		System.out.println(e.getID());
		String url = FileDaoDelegate.getUrl(key);
		System.out.println(url);
		
		try {
			URLopener.folderOpener(url);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
	}

}
