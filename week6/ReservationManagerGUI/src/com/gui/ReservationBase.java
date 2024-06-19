package com.gui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


import javax.swing.*;

public class ReservationBase extends JPanel implements ActionListener {

    JLabel type;
    JLabel dd;
    JLabel mm;
    JLabel yyyy;
    JLabel numNights;
    JLabel numBeds;
    JLabel numRooms;
    JLabel numBaths;
    JLabel lodgingSize;

    JTextField ddTextField;
    JTextField mmTextField;
    JTextField yyyyTextField;
    JTextField numNightsTextField;
    JTextField numBedsTextField;
    JTextField numRoomsTextField;
    JTextField numBathsTextField;
    JTextField lodgingSizTextField;

    String hotelString;
    String houseString;
    String cabinString;
    JRadioButton hotelButton;
    JRadioButton houseButton;
    JRadioButton cabinButton;

    ButtonGroup typeButtonGroup;
    JPanel typePanel;
    GridLayout radioGrid;


    public ReservationBase(){
        super(new BorderLayout());
        this.hotelString = "Hotel";
        this.houseString = "House";
        this.cabinString = "Cabin";

        this.hotelButton = new JRadioButton(this.hotelString);
        this.hotelButton.setActionCommand(this.hotelString);

        this.houseButton = new JRadioButton(this.houseString);
        this.houseButton.setActionCommand(this.houseString);

        this.cabinButton = new JRadioButton(this.cabinString);
        this.cabinButton.setActionCommand(this.cabinString);

        this.typeButtonGroup = new ButtonGroup();
        this.typeButtonGroup.add(this.hotelButton);
        this.typeButtonGroup.add(this.hotelButton);
        this.typeButtonGroup.add(this.cabinButton);

        this.hotelButton.addActionListener(this);
        this.houseButton.addActionListener(this);
        this.cabinButton.addActionListener(this);

        this.typePanel = new JPanel();
        this.typePanel.add(this.hotelButton);
        this.typePanel.add(this.houseButton);
        this.typePanel.add(this.cabinButton);
    }

    public void actionPerformed(ActionEvent ae){

    }
}