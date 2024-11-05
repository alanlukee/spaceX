package com.spaceX;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class FormPanel extends JPanel {
    
    private JLabel rocketNameLabel;
    private JTextField rocketNameText;
    
    private JLabel raptorEngine;
    private JTextField raptorEngineText;
    
    private JLabel heatShield;
    private JTextField heatShieldText;
    
    private JList<String> testList;

    private JRadioButton block_1_version;
    private JRadioButton block_2_version;
    private JRadioButton block_3_version;

    private ButtonGroup version;
    private JButton submitButton;
    
    

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public FormPanel() {
        
        // Set background color of the panel to black
        setBackground(Color.BLACK);

        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        // Initialize labels and set their font color to white
        rocketNameLabel = new JLabel("Rocket Name");
        rocketNameLabel.setForeground(Color.WHITE);
        
        raptorEngine = new JLabel("Raptor Engine");
        raptorEngine.setForeground(Color.WHITE);
        
        heatShield = new JLabel("Heat Shield");
        heatShield.setForeground(Color.WHITE);
        
        // Initialize text fields
        rocketNameText = new JTextField(10);
        raptorEngineText = new JTextField(10);
        heatShieldText = new JTextField(10);
        
        // Initialize radio buttons
        block_1_version = new JRadioButton("Block-1");
        block_1_version.setForeground(Color.WHITE);
        block_2_version = new JRadioButton("Block-2");
        block_2_version.setForeground(Color.WHITE);
        block_3_version = new JRadioButton("Block-3");
        block_3_version.setForeground(Color.WHITE);
        
        block_1_version.setActionCommand("block1");
        block_2_version.setActionCommand("block2");
        block_3_version.setActionCommand("block3");

        // Group radio buttons
        version = new ButtonGroup();
        version.add(block_1_version);
        version.add(block_2_version);
        version.add(block_3_version);

        // Initialize list and set model
        testList = new JList<>();
        DefaultListModel<String> flightList = new DefaultListModel<>();
        flightList.addElement("test flight-1");
        flightList.addElement("test flight-2");
        flightList.addElement("test flight-3");
        flightList.addElement("test flight-4");
        flightList.addElement("test flight-5");
        testList.setModel(flightList);
        testList.setPreferredSize(new Dimension(120, 100));
        testList.setBorder(BorderFactory.createEtchedBorder());

        // Initialize submit button
        submitButton = new JButton("Process");
        


        // Set up borders
        Border innerBorder = BorderFactory.createTitledBorder(
        	    BorderFactory.createLineBorder(Color.WHITE), // Base border color
        	    "StarShip Components",                       // Title text
        	    TitledBorder.LEFT,                           // Title position
        	    TitledBorder.TOP,                            // Title placement
        	    new Font("SansSerif", Font.PLAIN, 12),       // Font for the title
        	    Color.WHITE                                  // Title color
        	);
        Border outerBorder = BorderFactory.createLineBorder(Color.RED, 2, true);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        // Layout components
        layoutComponents();
    }

    public void layoutComponents() {
        
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        // Row 1
        gc.weighty = 1;
        gc.gridy = 0;
        gc.gridx = 0;
        add(rocketNameLabel, gc);

        gc.gridx = 1;
        add(rocketNameText, gc);

        // Row 2
        gc.gridy = 1;
        gc.gridx = 0;
        add(raptorEngine, gc);

        gc.gridx = 1;
        add(raptorEngineText, gc);

        // Row 3
        gc.gridy = 2;
        gc.gridx = 0;
        add(heatShield, gc);

        gc.gridx = 1;
        add(heatShieldText, gc);

        // Row 4 - Version radio buttons
        gc.gridy = 3;
        gc.gridx = 0;
        add(new JLabel("Version: "), gc);

        gc.gridx = 1;
        add(block_1_version, gc);

        gc.gridy = 4;
        add(block_2_version, gc);

        gc.gridy = 5;
        add(block_3_version, gc);

        // Row 5 - List
        gc.gridy = 7;
        add(testList, gc);

        // Row 6 - Submit button
        gc.weighty = 1;
        gc.weightx = 0.1;
        gc.gridy = 8;
        add(submitButton, gc);
    }
}
