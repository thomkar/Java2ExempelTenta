import javax.swing.SwingUtilities;



public class Tentamen {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new BookReader().setVisible(true);
			}
		});		

	}

}
