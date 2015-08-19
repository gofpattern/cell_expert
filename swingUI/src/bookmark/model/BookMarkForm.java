package bookmark.model;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bookmark.controllers.BookMarkBtnListener;
import bookmark.controllers.BookMarkDeleteBtnListener;


/**
 * This class serve as form to collect the data from the user. For now its tightly coupled but as I go along the way, I will keep making it loosely coupled and configureable
 * 
 * @author ahafeez
 * 
 */
public class BookMarkForm extends Panel implements BookMark {

	private JTextField bookmarkNameText;
	private JTextField bookmarkUrlText;
	private JLabel bookmarkNameLabel;
	private JLabel bookmarkUrlLabel;

	public BookMarkForm() {
		super();

		this.bookmarkNameText = new JTextField(5);
		this.bookmarkUrlText = new JTextField(5);
		this.bookmarkNameLabel = new JLabel("Book Mark Name");
		this.bookmarkUrlLabel = new JLabel("Bookmark Url");
	}

	public void setBookmarkForm() {

		this.add(bookmarkNameLabel);
		this.add(bookmarkNameText);
		this.add(bookmarkUrlLabel);
		this.add(bookmarkUrlText);
		

	}
	
	//setters
	//not a bean setter.'todo
	public void setBookmarkNameText(String bookmarkNameStr) {
		this.bookmarkNameText.setText(bookmarkNameStr); 
	}

	public void setBookmarkUrlText(String bookmarkUrlStr ) {
		this.bookmarkUrlText.setText(bookmarkUrlStr);
	}


	// Getters

	public JTextField getBookmarkNameText() {
		return bookmarkNameText;
	}

	public JTextField getBookmarkUrlText() {
		return bookmarkUrlText;
	}

	public JLabel getBookmarkNameLabel() {
		return bookmarkNameLabel;
	}

	public JLabel getBookmarkUrlLabel() {
		return bookmarkUrlLabel;
	}

	public void addTo(JPanel bookMarkPanel) {
		 //bookmark name on the window
		 JButton bookmarkNameBtn = new JButton(this.getBookmarkNameText().getText());
		 //delete button for book mark deletion	 
		 JButton delete = new JButton("Delete"); 
		 delete.setPreferredSize(new Dimension(100,25));
		 delete.setActionCommand(this.getBookmarkNameText().getText());
		 delete.addActionListener(new BookMarkDeleteBtnListener());
		 bookMarkPanel.add(delete);
		 bookmarkNameBtn.addActionListener(new BookMarkBtnListener());
		 bookMarkPanel.add(bookmarkNameBtn);
		 //Bookmark location field on window
		 bookMarkPanel.add(new JTextField(this.getBookmarkUrlText().getText()));

	}

	public boolean showForm() {

		int result = JOptionPane.showConfirmDialog(null, this, "Please Enter bookmark and its URL", JOptionPane.OK_CANCEL_OPTION);
		return result == JOptionPane.OK_OPTION;

	}

}
