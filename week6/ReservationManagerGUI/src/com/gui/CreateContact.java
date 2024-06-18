package com.gui;

import java.awt.GridLayout;
import javax.swing.*;

public class CreateContact extends JPanel {
    JLabel firstNameLabel;
    JLabel lastNameLabel;
    JLabel emailLabel;
    JLabel phoneNumberLabel;

    JTextField firstNamTextField;
    JTextField lastNamTextField;
    JTextField emailTextField;
    JTextField phonNumberTextField;

    GridLayout contactLayout;

    public CreateContact(){
        this.contactLayout = new GridLayout(4, 2);
        this.setLayout(this.contactLayout);
        this.firstNameLabel = new JLabel("First Name");
        this.lastNameLabel = new JLabel("Last Name");
        this.emailLabel = new JLabel("Email");
        this.phoneNumberLabel = new JLabel("Phone Number");

        this.firstNamTextField = new JTextField(10);
        this.lastNamTextField = new JTextField(10);
        this.emailTextField = new JTextField(10);
        this.phonNumberTextField = new JTextField(10);

        this.add(this.firstNameLabel);
        this.add(this.firstNamTextField);
        this.add(this.lastNameLabel);
        this.add(this.lastNamTextField);
        this.add(this.emailLabel);
        this.add(this.emailTextField);
        this.add(this.phoneNumberLabel);
        this.add(this.phonNumberTextField);
    }
    
}
