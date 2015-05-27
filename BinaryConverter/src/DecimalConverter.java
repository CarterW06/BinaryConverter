import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DecimalConverter implements ActionListener, KeyListener {
	private JButton button = new JButton("Convert");
	private JTextField inputField = new JTextField(20);
	private JTextField outputField = new JTextField(20);
	private JFrame frame = new JFrame("Base 10 Converter");

	public void start() {
		new DecimalConverter().createGUI();
	}

	private void createGUI() {
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.add(inputField);
		panel.add(button);
		panel.add(outputField);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setListenerButton(button);
		setListenerBox(inputField);
	}

	private void setListenerButton(JButton button2) {
		button2.addActionListener(this);
	}

	private void setListenerBox(JTextField field) {
		field.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(button)) {
			outputField.setText(convert(inputField.getText()));
		}
	}

	private String convert(String decimal) {
		try{
			Integer decimal2 = (Integer) Integer.parseInt(decimal);
			return Integer.toBinaryString(decimal2);
		}
		catch(NumberFormatException a) {
			JOptionPane.showMessageDialog(frame, "A NumberFormatException occured because of user input that cannot be converted.  Details are below:\n" + a);
			return "";
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(frame, "An exception occured in Java.  Details are below:\n" + e);
			return "";
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
			outputField.setText(convert(inputField.getText()));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
			outputField.setText(convert(inputField.getText()));
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
			outputField.setText(convert(inputField.getText()));
		}
	}
}
