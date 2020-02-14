import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

public class ToDoList {

	public static void main(String[] args) {
		ToDoList frame = new ToDoList();
	}

	private JFrame frame;
	private JPanel panel;
	private JMenuBar menuBar;

	ArrayList<String> entries = new ArrayList<String>();

	public ToDoList() {

		frame = new JFrame("ToDo List");
		URL picture = ToDoList.class.getResource("/ToDoClipArt.png");
		ImageIcon img = new ImageIcon(picture);
		frame.setIconImage(img.getImage());

		menuBar = new JMenuBar();

		JButton addButton = new JButton("Add");
		JButton saveButton = new JButton("Save");

		menuBar.add(addButton);
		menuBar.add(saveButton);

		addButton.addActionListener(event -> addEntry());
		saveButton.addActionListener(event -> saveToDo());

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		frame.setJMenuBar(menuBar);
		frame.add(panel);
		frame.setSize(400, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void addEntry() {
		String entry = JOptionPane.showInputDialog("Enter todo...");

		if (entry == null || entry.isBlank()) {
			return;
		}

		JTextField text = new JTextField(entry);

		entries.add(entry);

		panel.add(text);
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}

	private void saveToDo(){
		String futureFile = "# ToDo \n";
		futureFile += "\n";

		for (String string : entries) {
			futureFile += "- ";
			futureFile += string;
			futureFile += "\n";
			futureFile += "\n";
		}
		
		JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = chooser.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = chooser.getSelectedFile();
			String filepathString = selectedFile.getAbsolutePath();
			
			File file = new File(filepathString);
			
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(futureFile);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}