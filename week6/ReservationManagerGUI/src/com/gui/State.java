package com.gui;

import com.manager.Manager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class State extends JPanel implements ActionListener{

    public Manager parent;
    public State nextState;
    public State(Manager parentManager){
        super(new BorderLayout());
        this.parent = parentManager;
     }

    public abstract  void actionPerformed(ActionEvent ae);

    public State updateState(){
        return this.nextState;
    }

}
