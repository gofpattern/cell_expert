package bookmark.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import bookmark.model.BookMarkBean;
import bookmark.model.BookMarkForm;

public class FileDaoDelegate implements BookMarkDao {

	public void saveBookmarks(BookMarkForm bookmark) {
		BookMarkBean bookmarkBean = getBookMarkBean(bookmark);
		List<BookMarkBean> beanList = new ArrayList<BookMarkBean>();
		beanList.add(bookmarkBean);
		saveToFile(beanList);

	}

	private BookMarkBean getBookMarkBean(BookMarkForm bookmark) {
		String name = bookmark.getBookmarkNameText().getText();
		String url = bookmark.getBookmarkUrlText().getText();
		BookMarkBean bookmarkBean = new BookMarkBean();
		bookmarkBean.setBookMark(name);
		bookmarkBean.setBookMarkUrl(url);
		return bookmarkBean;
	}

	private void saveToFile(List<BookMarkBean> bookmarkList) {

		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream("config.properties");

			for (BookMarkBean bookmarkBean : bookmarkList) {

				// set the properties value
				prop.setProperty(bookmarkBean.getBookMark(), bookmarkBean.getBookMarkUrl());
			}
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

	public void saveBookmarks(List<BookMarkForm> bookmarkFormList) {

		List<BookMarkBean> bookmarkList = new ArrayList<BookMarkBean>();
		for (BookMarkForm form : bookmarkFormList) {
			bookmarkList.add(getBookMarkBean(form));
		}
		saveToFile(bookmarkList);

	}
	
	public List<BookMarkForm> loadBookmarks(){
		
		Properties prop = new Properties();
		List<BookMarkForm> listForms = new ArrayList<BookMarkForm>();
		InputStream input = null;

		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);
			
			Enumeration<?> e = prop.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String value = prop.getProperty(key);
				System.out.println("Key : " + key + ", Value : " + value);
				BookMarkForm form = new BookMarkForm();
				form.setBookmarkNameText(key);
				form.setBookmarkUrlText(value);
				listForms.add(form);
			}
			
			

			

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return listForms;
		
	}
}
