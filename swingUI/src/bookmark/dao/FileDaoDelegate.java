package bookmark.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import bookmark.model.BookMarkBean;
import bookmark.model.BookMarkForm;

public class FileDaoDelegate implements BookMarkDao {

	public void saveBookmarks(BookMarkForm bookmark) {
		String name = bookmark.getBookmarkNameText().getText();
		String url = bookmark.getBookmarkUrlText().getText();
		BookMarkBean bookmarkBean = new BookMarkBean();
		bookmarkBean.setBookMark(name);
		bookmarkBean.setBookMarkUrl(url);

		saveToFile(bookmarkBean);

	}

	private void saveToFile(BookMarkBean bookmarkBean) {

		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream("config.properties");

			// set the properties value
			prop.setProperty(bookmarkBean.getBookMark(), bookmarkBean.getBookMarkUrl());
			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}
}
