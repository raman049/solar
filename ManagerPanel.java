package com.solar;

import java.awt.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ManagerPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel managerPanel;
	JPanel bottomManagerPanelInventory, bottomManagerPanelAddInventory, bottomManagerPanelCreateOrder,
	bottomManagerPanelAddCustomer;
	JLabel managerName, branchName;
	JButton inventory, addInventory, createOrder, addCustomer, transfer, balance;

	public ManagerPanel(String user) {

		managerPanel = new JPanel();
		managerPanel.setLayout(new BoxLayout(managerPanel, BoxLayout.Y_AXIS));

		String[] userInfo = Connect.userinfo(user);
		JPanel topManagerPanel = new JPanel();
		topManagerPanel.setLayout(new GridLayout(1, 2, 250, 5));
		managerName = new JLabel(userInfo[0] + " " + userInfo[1]);
		managerName.setForeground(Color.BLUE);
		branchName = new JLabel("Branch: " + userInfo[3]);
		branchName.setForeground(Color.BLUE);
		topManagerPanel.add(managerName);
		topManagerPanel.add(branchName);

		inventory = new JButton("Inventory");
		inventory.addActionListener(this);
		addInventory = new JButton("Add Inventory");
		addInventory.addActionListener(this);
		createOrder = new JButton("Create Order");
		createOrder.addActionListener(this);
		addCustomer = new JButton("Add Customer");
		addCustomer.addActionListener(this);
		transfer = new JButton("Transfer");
		transfer.addActionListener(this);
		balance = new JButton("Check balance");
		balance.addActionListener(this);

		JPanel middleManagerPanel = new JPanel();
		middleManagerPanel.setLayout(new GridLayout(2, 3, 5, 5));
		middleManagerPanel.add(inventory);
		middleManagerPanel.add(addInventory);
		middleManagerPanel.add(createOrder);
		middleManagerPanel.add(addCustomer);
		middleManagerPanel.add(transfer);
		middleManagerPanel.add(balance);
		// inventory
		bottomManagerPanelInventory = new JPanel();
		bottomManagerPanelInventory.setLayout(new GridLayout(2, 3, 5, 5));
		bottomManagerPanelInventory = ActionMethod.inventory();
		bottomManagerPanelInventory.setVisible(false);
		// add inventory
		bottomManagerPanelAddInventory = new JPanel();
		bottomManagerPanelAddInventory.setLayout(new GridLayout(2, 3, 5, 5));
		bottomManagerPanelAddInventory = ActionMethod.addInventory();
		bottomManagerPanelAddInventory.setVisible(false);
		// add create order
		bottomManagerPanelCreateOrder = new JPanel();
		bottomManagerPanelCreateOrder.setLayout(new GridLayout(2, 3, 5, 5));
		bottomManagerPanelCreateOrder = ActionMethod.createOrder();
		bottomManagerPanelCreateOrder.setVisible(false);
		//add add customer
		bottomManagerPanelAddCustomer = new JPanel();
		bottomManagerPanelAddCustomer.setLayout(new GridLayout(2, 3, 5, 5));
		bottomManagerPanelAddCustomer = ActionMethod.addCustomer();
		bottomManagerPanelAddCustomer.setVisible(false);
	
		managerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		managerPanel.add(topManagerPanel);
		managerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		managerPanel.add(middleManagerPanel);
		managerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		managerPanel.add(bottomManagerPanelInventory);
		managerPanel.add(bottomManagerPanelAddInventory);
		managerPanel.add(bottomManagerPanelCreateOrder);
		managerPanel.add(bottomManagerPanelAddCustomer);
		add(managerPanel);
		managerPanel.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == inventory) {
			System.out.println("inventory button");
			bottomManagerPanelAddInventory.setVisible(false);
			bottomManagerPanelCreateOrder.setVisible(false);
			bottomManagerPanelAddCustomer.setVisible(false);
			bottomManagerPanelInventory.setVisible(true);

		}
		if (e.getSource() == addInventory) {
			System.out.println("addInventory button");
			bottomManagerPanelInventory.setVisible(false);
			bottomManagerPanelCreateOrder.setVisible(false);
			bottomManagerPanelAddCustomer.setVisible(false);
			bottomManagerPanelAddInventory.setVisible(true);
		}
		if (e.getSource() == createOrder) {
			System.out.println("createOrder button");
			bottomManagerPanelInventory.setVisible(false);
			bottomManagerPanelAddInventory.setVisible(false);
			bottomManagerPanelAddCustomer.setVisible(false);
			bottomManagerPanelCreateOrder.setVisible(true);
		}
		if (e.getSource() == addCustomer) {
			System.out.println("addCustomer button");
			bottomManagerPanelInventory.setVisible(false);
			bottomManagerPanelCreateOrder.setVisible(false);
			bottomManagerPanelAddInventory.setVisible(false);
			bottomManagerPanelAddCustomer.setVisible(true);
		}
		if (e.getSource() == transfer) {
			System.out.println("transfer button");
		}
		if (e.getSource() == balance) {
			System.out.println("balance button");
		}

		managerPanel.repaint();

	}

}
