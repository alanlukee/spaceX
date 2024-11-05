package com.spaceX;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    
    private ToolBar toolbar;
    private FormPanel formPanel;
    private TextPanel textPanel;
    private RocketComponent custComponent;
    private Timer animationTimer;

    public MainFrame() {
        super("SpaceX");
        
        setLayout(new BorderLayout());
        toolbar = new ToolBar();
        formPanel = new FormPanel();
        textPanel = new TextPanel();
        custComponent = new RocketComponent();
        
        add(toolbar, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(textPanel, BorderLayout.SOUTH);
        add(custComponent, BorderLayout.EAST);
        
        toolbar.setRocketListener(new RocketListener() {
            @Override
            public void rocketReturn() {
                
                custComponent.returnToStarbase();
                textPanel.clearTextArea();
                textPanel.appendText("Starship returned to starbase");

            }
            
            @Override
            public void rocketEmitted() {
            	textPanel.clearTextArea();
                textPanel.appendText("Starship launched");
                custComponent.launchRocket(); 
            }
            
            @Override
            public void rocketCleared() {
                textPanel.clearTextArea();
                System.out.println("StarBase cleared");
            }
        });
        
        setSize(800, 700);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        setJMenuBar(createMenuBar());
        
        
        animationTimer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                custComponent.update(); // Update rocket position
            }
        });
        animationTimer.start(); 
    }
    
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("spaceX");

        // Load the icon from a file path
        ImageIcon icon = new ImageIcon("/Users/alanluke/eclipse-workspace/spaceX/spacexIcon.png");

        // Resize the icon to a smaller size (e.g., 24x24 pixels)
        ImageIcon resizedIcon = resizeIcon(icon, 24, 24); // Adjust the size as needed

        // Set the resized icon to the menu
        fileMenu.setIcon(resizedIcon);

        JMenuItem exportDataItem = new JMenuItem("Features");
        JMenuItem importDataItem = new JMenuItem("Engine");
        JMenuItem exitItem = new JMenuItem("Power Off");

        fileMenu.add(exportDataItem);
        fileMenu.add(importDataItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        return menuBar;
    }

    // Method to resize the icon
    private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage(); // Get the original image
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Resize the image
        return new ImageIcon(resizedImage); // Return a new ImageIcon with the resized image
    }
}
