import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JButton button;
	
	String [] todoes = new String [100];
	int position = 0;

	public ToDoList() {
		
		frame = new JFrame("ToDo List");
		ImageIcon img = new ImageIcon("C:\\Users\\Lena\\Desktop\\eclipse-workspace\\SimpleToDo\\ToDoClipart.png");
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
	}
	
	private void addEntry() {
		String entry = JOptionPane.showInputDialog("please enter value");
		JTextField text = new JTextField(entry);
		
		todoes[position] = entry;
		
		panel.add(text);
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}
	
	private void saveToDo() {
		
	}
    
}