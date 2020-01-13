import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class BookReader extends JFrame {
	
	Book book = Book.createTestBook();
	JTextArea textArea = new JTextArea();

	
	
	private static final String TITLE = "Book Reader";

	BookReader() {
		setLayout( new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(TITLE);
		setSize(400,250);
		setLocationRelativeTo(null);
		setIconImage( new ImageIcon("images/paint.png").getImage());
		getRootPane().setBorder(new  EtchedBorder());
		
		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		//add(mb, BorderLayout.NORTH);
		JMenu menu = new JMenu("Sort");
		mb.add(menu);
		JMenuItem s1 = new JMenuItem("By chapter number");
		menu.add(s1);
		JMenuItem s2 = new JMenuItem("By text lengt");
		menu.add(s2);
		JMenuItem s3 = new JMenuItem("By chapter heading");
		menu.add(s3);

		JPanel bookTitlePanel = new JPanel( new GridLayout(2,1));
		bookTitlePanel.add(new JTextField("Title:" + "\n" + book.getTitle()));
		bookTitlePanel.add(new JTextField("Author:\n" + book.getAuthor()));

		add(bookTitlePanel, BorderLayout.PAGE_START);
		
		textArea.setEditable(false);
		add(textArea, BorderLayout.CENTER);
		
		printBook();
		
		s1.addActionListener(e -> {book.sortByChapterNumber(); printBook();});
		s2.addActionListener(e -> {book.sortByTextLength(); printBook();});
		s3.addActionListener(e -> {book.sortByChapterHeading(); printBook();});

	}
	
	private void printBook() {
		textArea.setText("Chapters" + "\n");
		for (Chapter c : book.getAllChapters())
			textArea.append(c.getChapterNumber() + "\t" + c.getChapterHeading() + "\n");

	}

}
