package bookmark.model;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

	public void addTo(JPanel controlPanel) {
		 //nookmark name on the window
		 controlPanel.add(new Button(this.getBookmarkNameText().getText()),BorderLayout.EAST);
		 //Bookmark location field on window
         controlPanel.add(new JTextField(this.getBookmarkUrlText().getText()),BorderLayout.EAST);

	}

	public boolean showForm() {

		int result = JOptionPane.showConfirmDialog(null, this, "Please Enter bookmark and its URL", JOptionPane.OK_CANCEL_OPTION);
		return result == JOptionPane.OK_OPTION;

	}

}
