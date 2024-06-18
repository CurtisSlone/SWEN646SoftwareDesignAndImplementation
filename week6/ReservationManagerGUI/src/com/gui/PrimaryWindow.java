package com.gui;

import com.manager.Manager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PrimaryWindow extends JFrame implements ComponentListener{
    Manager reservationManager;
    State currState;

    public PrimaryWindow(){
        super("Accomodation Reservation Manager");
        this.setSize(800,800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.reservationManager = new Manager();
        this.currState = new InitialPanel(this.reservationManager);
        this.currState.addComponentListener(this);
        this.getContentPane().add(this.currState, BorderLayout.CENTER);
    }

    public void componentHidden(ComponentEvent e) {
        this.getContentPane().remove(this.currState);
        this.currState = ((State)e.getComponent()).updateState();
        this.currState.addComponentListener(this);
        this.getContentPane().add(this.currState, BorderLayout.CENTER);
    }

    public void componentMoved(ComponentEvent e) {
       
    }

    public void componentResized(ComponentEvent e) {
                    
    }

    public void componentShown(ComponentEvent e) {
    }


}