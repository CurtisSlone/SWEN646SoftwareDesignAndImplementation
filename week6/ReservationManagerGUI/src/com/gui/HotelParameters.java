package com.gui;

import java.awt.GridLayout;
import javax.swing.*;

public class HotelParameters extends JPanel {
    JLabel hasKitchenetteLabel;

    String trueOpt;
    String falseOpt;

    JRadioButton trueButton;
    JRadioButton falseButton;

    ButtonGroup hasKitchenetteButtonGroup;
    JPanel hasKitchenetteBGPanel;

    public HotelParameters(){
        super(new GridLayout(1,2));

        this.trueOpt = "true";
        this.falseOpt = "false";

        this.hasKitchenetteBGPanel = new JPanel();

        this.hasKitchenetteLabel = new JLabel("Include Kitchenette");
        this.hasKitchenetteButtonGroup = new ButtonGroup();
        this.trueButton = new JRadioButton(this.trueOpt);
        this.trueButton.setActionCommand(this.trueOpt);

        this.falseButton = new JRadioButton(this.falseOpt);
        this.falseButton.setActionCommand(this.falseOpt);

        this.hasKitchenetteButtonGroup.add(this.trueButton);
        this.hasKitchenetteButtonGroup.add(this.falseButton);

        this.hasKitchenetteBGPanel.add(this.trueButton);
        this.hasKitchenetteBGPanel.add(this.falseButton);

        this.add(this.hasKitchenetteLabel);
        this.add(this.hasKitchenetteBGPanel);
    }
}
