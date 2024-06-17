package com.gui;

import com.manager.Manager;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public abstract class State extends JPanel {

    Manager parent;
    public State(Manager parentManager){
        super(new BorderLayout());
        this.parent = parentManager;
     }
}
