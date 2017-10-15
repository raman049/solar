package com.solar;

import java.awt.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ManagerPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel managerPanel;
	JLabel managerName, branchName;
	JButton inventory,addInventory,createOrder,editInventory,transfer,balance;
	public ManagerPanel(String user){
		
	    managerPanel = new JPanel();
		managerPanel.setLayout(new BoxLayout(managerPanel, BoxLayout.Y_AXIS));
		
		String[] userInfo = Connect.userinfo(user);
		JPanel topManagerPanel = new JPanel();
		topManagerPanel.setLayout(new GridLayout(1, 2, 250, 5));
		managerName = new JLabel(userInfo[0] + " "+ userInfo[1]);
		managerName.setForeground(Color.BLUE);
		branchName = new JLabel("Branch: "+userInfo[3]);
		branchName.setForeground(Color.BLUE);
		topManagerPanel.add(managerName);
		topManagerPanel.add(branchName);

		 inventory = new JButton("Inventory");
		 inventory.addActionListener(this);
		 addInventory = new JButton("Add Inventory");
		 addInventory.addActionListener(this);
		 createOrder = new JButton("Create Order");
		 createOrder.addActionListener(this);
		 editInventory = new JButton("Edit Inventory");
		 editInventory.addActionListener(this);
		 transfer = new JButton("Transfer");
		 transfer.addActionListener(this);
		 balance = new JButton("Check balance");
		 balance.addActionListener(this);
		
		JPanel middleManagerPanel = new JPanel();
		middleManagerPanel.setLayout(new GridLayout(2, 3,5, 5));
		middleManagerPanel.add(inventory);
		middleManagerPanel.add(addInventory);
		middleManagerPanel.add(createOrder);
		middleManagerPanel.add(editInventory);
		middleManagerPanel.add(transfer);
		middleManagerPanel.add(balance);

		managerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		managerPanel.add(topManagerPanel);
		managerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		managerPanel.add(middleManagerPanel);
		managerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		add(managerPanel);
		managerPanel.repaint();
	}
	
	JPanel paa = new JPanel();
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == inventory){
			//System.out.println("inventory button");	
			paa.removeAll();
			paa = ActionMethod.inventory();	
			
		}
		if(e.getSource() == addInventory){
			System.out.println("addInventory button");	
			paa.removeAll();
			paa = ActionMethod.addInventory();
			
		}
		if(e.getSource() == createOrder){
			System.out.println("createOrder button");	
		}
		if(e.getSource() == editInventory){
			System.out.println("editInventory button");	
		}
		if(e.getSource() == transfer){
			System.out.println("transfer button");	
		}
		if(e.getSource() == balance){
			System.out.println("balance button");	
		}
		
		managerPanel.add(paa);
		paa.setVisible(true);
		managerPanel.repaint();
		managerPanel.setVisible(true);
		
	}

}
