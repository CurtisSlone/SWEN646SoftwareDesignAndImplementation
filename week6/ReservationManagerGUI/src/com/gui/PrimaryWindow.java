package com.gui;

import com.manager.Manager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PrimaryWindow extends JFrame {
    Manager reservationManager;
    State currState;
    State prevState;

    public PrimaryWindow(){
        super("Accomodation Reservation Manager");
        this.setSize(800,800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.reservationManager = new Manager();
        this.currState = new InitialPanel(this.reservationManager);
        this.getContentPane().add(this.currState, BorderLayout.CENTER);

    }

    public static void changeState(){
        System.out.println("Event");
        // this.prevState = this.currState;
        // this.getContentPane().remove(this.currState);
        // this.currState = new UpdateObjectPanel(this.reservationManager);
        // this.getContentPane().add(this.currState, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e){
        System.out.println(e.getActionCommand());
        
    }
}