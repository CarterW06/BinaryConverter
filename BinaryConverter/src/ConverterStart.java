import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class ConverterStart implements ActionListener {

	public static void main(String[] args) {
		new ConverterStart().createGUI();
	}

	JButton binary = new JButton("Base 2");
	JButton base10 = new JButton("Base 10");

	JFrame frame = new JFrame();

	private void createGUI() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Please select a base to convert from:");
		panel.add(label);
		panel.add(binary);
		panel.add(base10);
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(235, 100);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setListener(binary);
		setListener(base10);
	}
	
	private void setListener(JButton button) {
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if (e.getSource().equals(base10)) {
			new DecimalConverter().start();
		} else if (e.getSource().equals(binary)) {
			new BinaryConverter().start();
		}
	}
}