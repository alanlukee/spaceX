package com.spaceX;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class TextPanel extends JPanel {
	
	private JTextArea textArea;
	
	public TextPanel() {
		textArea = new JTextArea();
		setLayout(new BorderLayout());
		
		add(textArea,BorderLayout.CENTER);
		Border innerBorder = BorderFactory.createTitledBorder("Star Base");
		Border outerBorder = BorderFactory.createLineBorder(Color.BLACK, 2, true);
		setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
		
	}
	public void appendText(String text) {
		textArea.append(text);
		
	}
	
	public void clearTextArea() {
		textArea.setText(" ");
	}
	
}
