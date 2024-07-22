package com.gui;

import com.manager.Manager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoadedObject extends State {

    JButton selectAccount;
    JButton selectReservation;
    JButton updateAccount;
    JButton updateReservation;
    JButton createReservation;
    JLabel reservationsLabel;
    JLabel reservationsIDLabel;
    JLabel accountIDLabel;
    JPanel buttonPanel;
    JPanel informationPanel;
    JList<String> reservations;
    JScrollPane reservationScroller;

    public LoadedObject(Manager parentManager){
        super(parentManager);
        this.buttonPanel = new JPanel(new GridLayout(2,2));
        this.informationPanel = new JPanel(new GridLayout(2,2));
        this.reservations = new JList();
        this.reservations.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.reservations.setLayoutOrientation(JList.VERTICAL);
        this.reservationScroller = new JScrollPane(this.reservations);

        this.reservationsLabel = new JLabel("Reservations");
        this.accountIDLabel = new JLabel("A123456");
        this.reservationsIDLabel = new JLabel("HOU12343");

        this.selectAccount = new JButton("Select Account By ID");
        this.selectReservation = new JButton("Select Reservation");
        this.updateAccount = new JButton("Update Account");
        this.updateReservation = new JButton("Update Reservation");
        this.createReservation = new JButton("Create Reservation");

        this.selectAccount.addActionListener(this);
        this.selectReservation.addActionListener(this);
        this.updateAccount.addActionListener(this);
        this.updateReservation.addActionListener(this);
        
        
        this.informationPanel.add(this.reservationsIDLabel);
        this.informationPanel.add(this.accountIDLabel);
        this.informationPanel.add(this.reservationsLabel);
        this.informationPanel.add(this.reservationScroller);
        
        this.add(this.informationPanel, BorderLayout.NORTH);

        this.buttonPanel.add(this.selectAccount);
        this.buttonPanel.add(this.selectReservation);
        this.buttonPanel.add(this.updateAccount);
        this.buttonPanel.add(this.updateReservation);
        this.buttonPanel.add(this.createReservation);
        this.add(this.buttonPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent ae){
        System.out.println(ae.getActionCommand());
        switch(ae.getActionCommand()){
            case "Select Account By ID":
                this.setVisible(false);
                this.nextState = new InitialPanel(this.parent);
                break;
            case "Update Account":
                this.setVisible(false);
                this.nextState = new CreateObject(this.parent,"ACCOUNT");
                break;
            case "Update Reservation":
                this.setVisible(false);
                this.nextState = new CreateObject(this.parent,"RESERVATION");
                break;
            case "Select Reservation":
                break;
            case "Create Reservation":
                this.setVisible(false);
                this.nextState = new CreateObject(this.parent,"RESERVATION");
                break;
        }
    };
    
}
