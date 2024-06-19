package com.gui;

import java.awt.GridLayout;
import javax.swing.*;

public class CreateAddress extends JPanel {
    JLabel street1JLabel;
    JLabel street2Label;
    JLabel cityLabel;
    JLabel stateLabel;
    JLabel zipLabel;

    JTextField street1TextField;
    JTextField street2TextField;
    JTextField cityTextField;
    JTextField stateTextField;
    JTextField zipTextField;

    public CreateAddress(){
        super(new GridLayout(5,2));
        this.street1JLabel = new JLabel("Street Address");
        this.street2Label = new JLabel("Street Address (Cont.)");
        this.cityLabel = new JLabel("City");
        this.stateLabel = new JLabel("State");
        this.zipLabel = new JLabel("Zip Code");

        this.street1TextField = new JTextField();
        this.street2TextField = new JTextField();
        this.cityTextField = new JTextField();
        this.stateTextField = new JTextField();
        this.zipTextField = new JTextField();

        this.add(this.street1JLabel);
        this.add(this.street1TextField);
        this.add(this.street2Label);
        this.add(this.street2TextField);
        this.add(this.cityLabel);
        this.add(this.cityTextField);
        this.add(this.stateLabel);
        this.add(this.stateTextField);
        this.add(this.zipLabel);
        this.add(this.zipTextField);
        
    }
}