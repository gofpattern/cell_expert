package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import bookmark.model.BookMarkForm;

public class AwtControlDemo {

	private JFrame mainFrame;
	private JPanel controlPanel;
	private JPanel bookMarkPanel;

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
		controlPanel.setLayout(new BorderLayout());
		

		
		mainFrame.add(controlPanel,BorderLayout.SOUTH);
		bookMarkPanel = new JPanel();
		bookMarkPanel.setLayout(new GridLayout(0,2));
		JScrollPane scrollBookmark = new JScrollPane(bookMarkPanel); //
		mainFrame.add(scrollBookmark,BorderLayout.NORTH);
		
		mainFrame.setVisible(true);
	}

	private void showTextFieldDemo() {
		
		Button addBookMarkBtn = new Button("Add New Bookmark");
		addBookMarkBtn.setSize(5, 2);

		// attach listener to Bookmark button
		addBookMarkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
				// get bookmark form
				BookMarkForm bookmarkForm = new BookMarkForm();
				bookmarkForm.setBookmarkForm();
				boolean ok = bookmarkForm.showForm();
				if (ok){
				bookmarkForm.addTo(bookMarkPanel);
				mainFrame.setVisible(true); //refreshing/resetting the window
				}
			}
		});

		controlPanel.add(addBookMarkBtn);
		mainFrame.setVisible(true);
	}
}
