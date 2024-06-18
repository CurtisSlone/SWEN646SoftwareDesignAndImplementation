package com.gui;

import com.manager.Manager;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class CreateObject extends State {
    Vector<JPanel> panelQueue;
    JPanel currentJPanel;
    JPanel buttonPanel;
    JButton last;
    JButton next;
    JButton submitFields;
    int panelQueueIdx;

    public CreateObject(Manager parentManager, String objectType){
        super(parentManager);
        this.parent.createNewAccount();
        this.panelQueueIdx = 0;
        this.panelQueue = new Vector<JPanel>();
        if(objectType == "Account"){
            this.panelQueue.add(new CreateContact());
            this.panelQueue.add(new CreateAddress());
            this.panelQueue.add(new CreateAddress());
        }

        this.last = new JButton("Last");
        this.next = new JButton("Next");
        this.submitFields = new JButton("Submit");
        this.buttonPanel = new JPanel();
        this.last.addActionListener(this);
        this.next.addActionListener(this);
        this.submitFields.addActionListener(this);
        this.buttonPanel.add(this.last);
        this.buttonPanel.add(this.next);
        this.buttonPanel.add(this.submitFields);

        this.currentJPanel = (JPanel)this.panelQueue.elementAt(this.panelQueueIdx);
        this.add(this.currentJPanel, BorderLayout.NORTH);
        this.add(this.buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        
        switch(ae.getActionCommand()){
            case "Last":
                if(!(panelQueueIdx == 0))
                    this.panelQueueIdx -= 1;
                this.currentJPanel.setVisible(false);
                this.remove(this.currentJPanel);
                this.currentJPanel = (JPanel)this.panelQueue.elementAt(this.panelQueueIdx);
                this.add(this.currentJPanel, BorderLayout.NORTH);
                this.currentJPanel.setVisible(true);
                break;
            case "Next":
                if(!(panelQueueIdx == 2))
                    this.panelQueueIdx += 1;
                this.currentJPanel.setVisible(false);
                this.remove(this.currentJPanel);
                this.currentJPanel = (JPanel)this.panelQueue.elementAt(this.panelQueueIdx);
                this.add(this.currentJPanel, BorderLayout.NORTH);
                this.currentJPanel.setVisible(true);
                break;
            case "Submit":
                this.nextState = new InitialPanel(this.parent);
                this.setVisible(false);
                break;
        }
       
    }
}

