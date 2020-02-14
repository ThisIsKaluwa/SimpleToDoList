import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame {
	
	private JFrame frame;
	private JPanel panel;
	
	public Frame() {
		frame = new JFrame("ToDo List");
		ImageIcon img = new ImageIcon("C:\\Users\\Lena\\Desktop\\eclipse-workspace\\SimpleToDo\\ToDoClipart.png");
		frame.setIconImage(img.getImage());
		
		panel = new JPanel();
		
		frame.add(panel);
		
		frame.setSize(400,500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
	}
    
}