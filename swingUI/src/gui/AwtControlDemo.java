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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import bookmark.controllers.BookmarkController;
import bookmark.model.BookMarkForm;

public class AwtControlDemo {

	private JFrame mainFrame;
	private JPanel controlPanel;
	private JPanel bookMarkPanel;
	BookMarkForm bookmarkForm;
	private Button addBookMarkBtn;
	private Button bookmarkSaveBtn;
	private List<BookMarkForm> bookmarkList; 

	public AwtControlDemo() {
		prepareGUI();
	}

	public static void main(String[] args) {
		AwtControlDemo awtControlDemo = new AwtControlDemo();
		awtControlDemo.showTextFieldDemo();
	}

	private void prepareGUI() {
		mainFrame = new JFrame("BookMark Application");
		mainFrame.setSize(400, 300);
		mainFrame.setLayout(new BorderLayout());
		//main window controller/Listener
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0); // do nothing just exit out at closing
			}
		});
		
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		

		
		mainFrame.add(controlPanel,BorderLayout.SOUTH);
		bookMarkPanel = new JPanel();
		bookMarkPanel.setLayout(new GridLayout(0,2));
		JScrollPane scrollBookmark = new JScrollPane(bookMarkPanel); //
		mainFrame.getContentPane().add(scrollBookmark,BorderLayout.NORTH);
		
		mainFrame.setVisible(true);
	}

	private void showTextFieldDemo() {
		
		addBookMarkBtn = new Button("Add New Bookmark");
		bookmarkSaveBtn = new Button("Save BookMark");
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
				//bookmarkList  = 
				if(bookmarkList == null)
				bookmarkList = new ArrayList<BookMarkForm>();
				return bookmarkList;
				
			}
		});
		
		//
		bookmarkSaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// call the controller to delegate work
				BookmarkController bookmarkCtrl = new BookmarkController();
				bookmarkCtrl.addBookMark(bookmarkList);
				mainFrame.setVisible(true); //refreshing/resetting the window
			}
		});

		controlPanel.add(bookmarkSaveBtn);
		controlPanel.add(addBookMarkBtn);
		mainFrame.setVisible(true);
	}
}
