package com.gui;
import java.awt.GridLayout;
import javax.swing.*;

public class ReservationBase extends JPanel {

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

    JRadioButton hotelButton;
    JRadioButton houseButton;
    JRadioButton cabinButton;

    ButtonGroup typeButtonGroup;
    JPanel typePanel;
    GridLayout radioGrid;


    public ReservationBase(){

    }

}