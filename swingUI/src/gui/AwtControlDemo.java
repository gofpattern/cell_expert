package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import bookmark.controllers.BookmarkController;
import bookmark.dao.FileDaoDelegate;
import bookmark.model.BookMarkForm;

public class AwtControlDemo {

	private JFrame mainFrame;
	private JPanel controlPanel;
	private JPanel bookMarkPanel;
	private JPanel editPanel;
	BookMarkForm bookmarkForm;
	private JButton addBookMarkBtn;
	private JButton bookmarkSaveBtn;
	private List<BookMarkForm> bookmarkList; 
	private BookmarkController bookmarkCtrl;

	public AwtControlDemo() {
		prepareGUI();
	}

	public static void main(String[] args) {
		AwtControlDemo awtControlDemo = new AwtControlDemo();
		awtControlDemo.showTextFieldDemo();
	}

	private void prepareGUI() {
		mainFrame = new JFrame("BookMark Application");
		mainFrame.setSize(1024, 768);
		mainFrame.setLayout(new BorderLayout());
		//main window controller/Listener
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				FileDaoDelegate.save();
				System.exit(0); // do nothing just exit out at closing
			}
		});
		
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		

		
		mainFrame.add(controlPanel,BorderLayout.SOUTH);
		bookMarkPanel = new JPanel();
		bookMarkPanel.setLayout(new GridLayout(0,3));
		//editPanel
		
		mainFrame.add(bookMarkPanel);
				
		JScrollPane scrollBookmark = new JScrollPane(bookMarkPanel); //
		mainFrame.getContentPane().add(scrollBookmark,BorderLayout.NORTH);
		
		
		mainFrame.setVisible(true);
	}

	private void showTextFieldDemo() {
		
		addBookMarkBtn = new JButton("Add New Bookmark");
		bookmarkSaveBtn = new JButton("Save BookMark");
		// attach listener to Bookmark button
		addBookMarkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
				// get bookmark form
				bookmarkForm = new BookMarkForm();
				bookmarkForm.setBookmarkForm();
				boolean ok = bookmarkForm.showForm();
				if (ok){
				bookmarkForm.addTo(bookMarkPanel);
				bookmarkList = getBookMarksList();
				bookmarkList.add(bookmarkForm);
				mainFrame.setVisible(true); //refreshing/resetting the window
				}
			}

			private List<BookMarkForm> getBookMarksList() {
				
				if(bookmarkList == null){
					bookmarkCtrl = new BookmarkController();
					bookmarkList  = bookmarkCtrl.loadBookMarks();
					if(bookmarkList==null)
					bookmarkList = new ArrayList<BookMarkForm>();
				}
				
				return bookmarkList;
				
			}
		});
		
		//
		bookmarkSaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// call the controller to delegate work
				bookmarkCtrl = new BookmarkController();
				bookmarkCtrl.addBookMark(bookmarkList);
				mainFrame.setVisible(true); //refreshing/resetting the window
			}
		});
		
		List<BookMarkForm> forms = getBookMarks();
		if(forms!=null)
		for(BookMarkForm form: forms)
		{
			form.addTo(bookMarkPanel);
		}

		controlPanel.add(bookmarkSaveBtn);
		controlPanel.add(addBookMarkBtn);
		mainFrame.setVisible(true);
	}

	private List<BookMarkForm> getBookMarks() {
		bookmarkCtrl = new BookmarkController();
		bookmarkList  = bookmarkCtrl.loadBookMarks();
		if(bookmarkList!=null && bookmarkList.size()>0){
			return bookmarkList;
		}
		
		return null;
	}
}
