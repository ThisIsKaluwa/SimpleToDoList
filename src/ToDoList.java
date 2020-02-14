import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ToDoList implements ActionListener{
	
	public static void main(String[] args) {
		ToDoList frame = new ToDoList();
	}

	private JFrame frame;
	private JPanel panel;
	
	ArrayList<String> entries = new ArrayList<String>();

	public ToDoList() {
		
		frame = new JFrame("ToDo List");
		URL picture = ToDoList.class.getResource("/ToDoClipArt.png");
		ImageIcon img = new ImageIcon(picture);
		frame.setIconImage(img.getImage());
		
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		frame.add(panel);
		
		addButton(panel, "Add");
		addButton(panel, "Save");
		
		frame.setSize(400,500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void addButton(Container panel, String buttonText) {
		JButton button = new JButton(buttonText);
        button.addActionListener(this);
        panel.add(button);
	}
	
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if (command.equals("Add")) {
			addEntry();
		}
		if (command.equals("Save")) {
			
		}
		
	}
	
	private void addEntry() {
		String entry = JOptionPane.showInputDialog("Enter todo...");
		JTextField text = new JTextField(entry);
		
		entries.add(entry);
		
		panel.add(text);
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}
	
	private void saveToDo() {
		
	}
    
}