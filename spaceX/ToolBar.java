package com.spaceX;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel {
    
    private JButton launchButton;
    private JButton returnButton;
    private JButton removeButton;
    
    private RocketListener rocketListener;
    
    public ToolBar() {
       
        setBackground(Color.BLACK);

        launchButton = new JButton("Launch Rocket");
        returnButton = new JButton("Return to Starbase");
        removeButton = new JButton("Remove Rocket");

    
        launchButton.setForeground(Color.WHITE);
        returnButton.setForeground(Color.WHITE);
        removeButton.setForeground(Color.WHITE);


     
        launchButton.setBorderPainted(false);
        returnButton.setBorderPainted(false);
        removeButton.setBorderPainted(false);

        setBorder(BorderFactory.createEtchedBorder());
        setLayout(new FlowLayout(FlowLayout.LEFT));

        launchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rocketListener != null) {
                    rocketListener.rocketEmitted();
                }
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rocketListener != null) {
                    rocketListener.rocketReturn();
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rocketListener != null) {
                    rocketListener.rocketCleared();
                }
            }
        });

        add(launchButton);
        add(returnButton);
        //add(removeButton);
    }

    public void setRocketListener(RocketListener rocketListener) {
        this.rocketListener = rocketListener;
    }
}
