package com.gui;
import java.awt.GridLayout;

import javax.swing.*;

public class CabinParameters extends JPanel{

    JLabel hasFullKitchenLabel;
    JLabel hasLoftLabel;

    String trueOpt;
    String falseOpt;

    JRadioButton trueButton;
    JRadioButton falseButton;

    JRadioButton trueButton2;
    JRadioButton falseButton2;

    ButtonGroup hasFullKitcheButtonGroup;
    ButtonGroup hasLoftButtonGroup;

    JPanel hasFullKitchenBGPanel;
    JPanel hasLoftBGPanel;

    
    public CabinParameters(){
        super(new GridLayout(2,2));

        this.hasFullKitchenLabel = new JLabel("Include Full Kitchen:");
        this.hasLoftLabel = new JLabel("Include Loft:");
        this.trueOpt = "true";
        this.falseOpt = "false";

        this.hasLoftBGPanel = new JPanel();
        this.hasFullKitchenBGPanel = new JPanel();

        this.trueButton = new JRadioButton(this.trueOpt);
        this.trueButton.setActionCommand(this.trueOpt);

        this.falseButton = new JRadioButton(this.falseOpt);
        this.falseButton.setActionCommand(this.falseOpt);

        this.trueButton2 = new JRadioButton(this.trueOpt);
        this.trueButton2.setActionCommand(this.trueOpt);

        this.falseButton2 = new JRadioButton(this.falseOpt);
        this.falseButton2.setActionCommand(this.falseOpt);

        this.hasFullKitcheButtonGroup = new ButtonGroup();
        this.hasLoftButtonGroup = new ButtonGroup();

        this.hasFullKitcheButtonGroup.add(this.trueButton);
        this.hasFullKitcheButtonGroup.add(this.falseButton);
        this.hasFullKitchenBGPanel.add(this.trueButton);
        this.hasFullKitchenBGPanel.add(this.falseButton);

        this.hasLoftButtonGroup.add(this.trueButton2);
        this.hasLoftButtonGroup.add(this.falseButton2);
        this.hasLoftBGPanel.add(this.trueButton2);
        this.hasLoftBGPanel.add(this.falseButton2);

        this.add(this.hasFullKitchenLabel);
        this.add(this.hasFullKitchenBGPanel);
        this.add(this.hasLoftLabel);
        this.add(this.hasLoftBGPanel);
        


    }
}
