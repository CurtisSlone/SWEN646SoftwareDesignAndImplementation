package com.gui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


import javax.swing.*;

public class ReservationBase extends JPanel implements ActionListener {

    JLabel typeLabel;
    JLabel dateLabel;
    JLabel numNightsLabel;
    JLabel numBedsLabel;
    JLabel numRoomsLabel;
    JLabel numBathsLabel;
    JLabel lodgingSizeLabel;

    JTextField dateTextField;
    JTextField numNightsTextField;
    JTextField numBedsTextField;
    JTextField numRoomsTextField;
    JTextField numBathsTextField;
    JTextField lodgingSizTextField;

    JPanel typePanel;
    JPanel reservationPanel;
    JPanel childPanel;

    String hotelString;
    String houseString;
    String cabinString;
    JRadioButton hotelButton;
    JRadioButton houseButton;
    JRadioButton cabinButton;
    ButtonGroup typeButtonGroup;
    


    public ReservationBase(){
        super(new BorderLayout());

        this.typeLabel = new JLabel("Reservation Type: ");
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
        this.typeButtonGroup.add(this.houseButton);
        this.typeButtonGroup.add(this.cabinButton);
        this.hotelButton.addActionListener(this);
        this.houseButton.addActionListener(this);
        this.cabinButton.addActionListener(this);

        this.typePanel = new JPanel();
        this.typePanel.add(this.typeLabel);
        this.typePanel.add(this.hotelButton);
        this.typePanel.add(this.houseButton);
        this.typePanel.add(this.cabinButton);

        this.add(this.typePanel, BorderLayout.NORTH);

        this.dateLabel = new JLabel("Date as DD-MM-YYYY: ");
        this.dateTextField = new JTextField();
        this.numNightsLabel = new JLabel("Nunber of Nights:");
        this.numNightsTextField = new JTextField();
        this.numBedsLabel = new JLabel("Number of Beds:");
        this.numBedsTextField = new JTextField();
        this.numRoomsLabel = new JLabel("Number of Rooms:");
        this.numRoomsTextField = new JTextField();
        this.numBathsLabel = new JLabel("Number Of Baths:");
        this.numBathsTextField = new JTextField();
        this.lodgingSizeLabel = new JLabel("Lodging Size:");
        this.lodgingSizTextField = new JTextField();
    

        this.reservationPanel = new JPanel(new GridLayout(6,2));
        this.reservationPanel.add(this.dateLabel);
        this.reservationPanel.add(this.dateTextField);
        this.reservationPanel.add(this.numNightsLabel);
        this.reservationPanel.add(this.numNightsTextField);
        this.reservationPanel.add(this.numBedsLabel);
        this.reservationPanel.add(this.numBedsTextField);
        this.reservationPanel.add(this.numBathsLabel);
        this.reservationPanel.add(this.numBathsTextField);
        this.reservationPanel.add(this.lodgingSizeLabel);
        this.reservationPanel.add(this.lodgingSizTextField);
    
        this.add(this.reservationPanel,BorderLayout.CENTER);
        this.childPanel = new JPanel();
    }

    public void actionPerformed(ActionEvent ae){
        
        switch(ae.getActionCommand()){
            case "Hotel":
                this.childPanel.setVisible(false);
                this.remove(this.childPanel);
                this.childPanel = new HotelParameters();
                this.add(this.childPanel,BorderLayout.SOUTH);
                break;
            case "House":
                this.childPanel.setVisible(false);
                this.remove(this.childPanel);
                this.childPanel = new HouseParameters();
                this.add(this.childPanel,BorderLayout.SOUTH);
                break;
            case "Cabin":
                this.childPanel.setVisible(false);
                this.remove(this.childPanel);    
                this.childPanel = new CabinParameters();
                this.add(this.childPanel,BorderLayout.SOUTH);
                break;
        }
    }
}