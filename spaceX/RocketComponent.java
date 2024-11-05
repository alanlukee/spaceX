package com.spaceX;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class RocketComponent extends JPanel {
    private int rocketYPosition = 500; // Starting Y position of the rocket
    private boolean isLaunching = false; // Flag to indicate if the rocket is launching

    public RocketComponent() {
        // Set preferred size
        setPreferredSize(new Dimension(300, 400)); // Increase height for more space
        
        // Set background color to black
        setBackground(Color.BLACK);

        // Create and set a border
        Border innerBorder = BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.WHITE), // Base border color
            "StarShip",                                  // Title text
            TitledBorder.LEFT,                           // Title position
            TitledBorder.TOP,                            // Title placement
            new Font("SansSerif", Font.PLAIN, 12),        // Font for the title
            Color.WHITE                                   // Title color
        );
        Border outerBorder = BorderFactory.createLineBorder(Color.RED, 2, true);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

      
        int baseX = 100; 
        int baseY = rocketYPosition; 

        // Draw rocket body
        g2d.setColor(Color.WHITE);
        g2d.fillRect(baseX, baseY - 200, 100, 200); 

        // Draw rocket nose
        g2d.setColor(Color.RED);
        Polygon nose = new Polygon();
        nose.addPoint(baseX, baseY - 200); 
        nose.addPoint(baseX + 50, baseY - 300); 
        nose.addPoint(baseX + 100, baseY - 200);
        g2d.fillPolygon(nose);

        // Draw fins
        Polygon leftFin = new Polygon();
        leftFin.addPoint(baseX, baseY); 
        leftFin.addPoint(baseX - 50, baseY + 50);
        leftFin.addPoint(baseX, baseY + 50); 
        g2d.fillPolygon(leftFin);

        Polygon rightFin = new Polygon();
        rightFin.addPoint(baseX + 100, baseY); 
        rightFin.addPoint(baseX + 100 + 50, baseY + 50); 
        rightFin.addPoint(baseX + 100, baseY + 50);
        g2d.fillPolygon(rightFin);
    }

    public void launchRocket() {
        isLaunching = true;
    }

    public void update() {
        if (isLaunching) {
            rocketYPosition -= 2; 
            if (rocketYPosition < -200) { 
                isLaunching = false;
                rocketYPosition = 500; 
            }
            repaint(); 
        }
    }
    public void returnToStarbase() {
        isLaunching = false; // Stop the launching process if it's active
        rocketYPosition = 500; // Reset to the starting position
        repaint(); // Refresh the component to show the rocket in the new position
    }
}
