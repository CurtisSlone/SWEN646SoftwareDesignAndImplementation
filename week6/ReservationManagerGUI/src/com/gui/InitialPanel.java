package com.gui;

import com.manager.Manager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InitialPanel extends State {

    
    JList<String> accounts;
    JPanel buttonPanel;
    JButton confirmSelection;
    JButton createAccount;
    JScrollPane accountScroller;
    String selectedAccount;
    

    public InitialPanel(Manager parentManager){
        super(parentManager);
        this.accounts = new JList(this.parent.listAllAccounts().toArray());
        this.accounts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.accounts.setLayoutOrientation(JList.VERTICAL);
        this.accountScroller = new JScrollPane(this.accounts);

        this.buttonPanel = new JPanel();
        this.confirmSelection = new JButton("Select");
        this.createAccount = new JButton("Create Account");
        this.confirmSelection.addActionListener(this);
        this.createAccount.addActionListener(this);
        this.buttonPanel.add(this.confirmSelection);
        this.buttonPanel.add(this.createAccount);

        this.add(this.accountScroller, BorderLayout.CENTER);
        this.add(this.buttonPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent ae){
        switch(ae.getActionCommand()){
            case "Create Account":
                this.nextState = new CreateObject(this.parent,"ACCOUNT");
                break;
            case "Select":
            this.nextState = new LoadedObject(this.parent);
                break;
        }
        this.setVisible(false);
    }
}
