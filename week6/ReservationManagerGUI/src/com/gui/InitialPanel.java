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

        JPanel buttonPanel = new JPanel();
        this.confirmSelection = new JButton("Select");
        this.createAccount = new JButton("Create Account");
        this.createAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                PrimaryWindow.changeState();
            }
        });
        buttonPanel.add(this.confirmSelection);
        buttonPanel.add(this.createAccount);

        this.add(this.accountScroller, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    
}
