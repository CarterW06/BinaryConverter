import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BinaryConverter implements ActionListener, KeyListener{
	private JTextField outputField = new JTextField(20);
	private JTextField inputField = new JTextField(20);
	private JFrame frame = new JFrame("Base 2 Converter");
	public void start() {
		new BinaryConverter().createGUI();
	}
	private void createGUI() {
		JPanel panel = new JPanel();
		frame.add(panel);
		JButton button = new JButton("Convert");
		panel.add(inputField);
		panel.add(button);
		panel.add(outputField);
		frame.setVisible(true);
		frame.pack();
		addListenerButton(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addListenerBox(inputField);
	}
	private void addListenerButton(JButton button) {
		button.addActionListener(this);
	}
	private String convert(String binary) {
		try{
			long asciiValue = Integer.parseInt(binary, 2);
			return "" + asciiValue;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(frame, "An exception occured in Java.  Details are below:\n" + e);
			return "";
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		outputField.setText(convert(inputField.getText()));
		//inputField.setText("");
	}

	private void addListenerBox(JTextField field) {
		field.addKeyListener(this);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == KeyEvent.VK_ENTER) {
			outputField.setText(convert(inputField.getText()));
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar() == KeyEvent.VK_ENTER) {
			outputField.setText(convert(inputField.getText()));
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == KeyEvent.VK_ENTER) {
			outputField.setText(convert(inputField.getText()));
		}
	}
}
