package com.gui;

import java.awt.GridLayout;
import javax.swing.*;

public class HouseParameters extends JPanel {

    JLabel numFloorsLabel;
    JTextField numFloorsTextField;

    public HouseParameters(){
        super(new GridLayout(1,2));

        this.numFloorsLabel = new JLabel("Number of Floors:");
        this.numFloorsTextField = new JTextField();

        this.add(numFloorsLabel);
        this.add(numFloorsTextField);
    }
}
