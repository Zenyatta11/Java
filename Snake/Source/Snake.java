import java.awt.EventQueue;
import javax.swing.JFrame;

public class Snake extends JFrame {
	public Snake() {
		initUI();
	}
	
	private void initUI() {
		log(0,"Starting UI");
		add(new Room());
		
		setResizable(false);
		pack();
		log(0,"Packing UI");
		
		setTitle("Snake");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		log(0,"Starting Game");
		EventQueue.invokeLater(() -> {
			JFrame ex = new Snake();
			ex.setVisible(true);
		});
	}
	
	public static void log(int type, String msg) {
		String typeStr;
		
		switch(type) {
			case 0: typeStr = "INFO"; break;
			case 1: typeStr = "WARN"; break;
			case 2: typeStr = "ERROR"; break;
		}
		
		System.out.println(typeStr + ": " + msg);
	}
}