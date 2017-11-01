package com.solar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UserPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	JPanel managerPanel;
	JPanel bottomManagerPanelInventory, bottomManagerPanelAddInventory, bottomManagerPanelCreateOrder;
	JLabel managerName, branchName;
	JButton inventory, addInventory, createOrder, editInventory, transfer, balance;

	public UserPanel(String user) {

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
		editInventory = new JButton("Edit Inventory");
		editInventory.addActionListener(this);
		transfer = new JButton("Transfer");
		transfer.addActionListener(this);
		balance = new JButton("Check balance");
		balance.addActionListener(this);

		JPanel middleManagerPanel = new JPanel();
		middleManagerPanel.setLayout(new GridLayout(2, 3, 5, 5));
		middleManagerPanel.add(inventory);
		middleManagerPanel.add(addInventory);
		middleManagerPanel.add(createOrder);
		//middleManagerPanel.add(editInventory);
		//middleManagerPanel.add(transfer);
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

		managerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		managerPanel.add(topManagerPanel);
		managerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		managerPanel.add(middleManagerPanel);
		managerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		managerPanel.add(bottomManagerPanelInventory);
		managerPanel.add(bottomManagerPanelAddInventory);
		managerPanel.add(bottomManagerPanelCreateOrder);
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
			bottomManagerPanelInventory.setVisible(true);

		}
		if (e.getSource() == addInventory) {
			System.out.println("addInventory button");
			bottomManagerPanelInventory.setVisible(false);
			bottomManagerPanelCreateOrder.setVisible(false);
			bottomManagerPanelAddInventory.setVisible(true);
		}
		if (e.getSource() == createOrder) {
			System.out.println("createOrder button");
			bottomManagerPanelInventory.setVisible(false);
			bottomManagerPanelAddInventory.setVisible(false);
			bottomManagerPanelCreateOrder.setVisible(true);
		}
		if (e.getSource() == editInventory) {
			System.out.println("editInventory button");
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
// private static final long serialVersionUID = 1L;
// JLabel customerName, branchName;
// String aa;
// String[][] bb = new String[10][10];
// static String[][] bc;// = new String[0][0];
//
// public UserPanel(String user) {
//
// JPanel customerPanel = new JPanel();
// customerPanel.setLayout(new BoxLayout(customerPanel, BoxLayout.Y_AXIS));
//
// String[] userInfo = Connect.userinfo(user);
// JPanel topCustomerPanel = new JPanel();
// topCustomerPanel.setLayout(new GridLayout(1, 2, 300, 5));
// customerName = new JLabel(userInfo[0] + " "+ userInfo[1]);
// customerName.setForeground(Color.BLUE);
// branchName = new JLabel("Branch: "+userInfo[3]);
// branchName.setForeground(Color.BLUE);
// topCustomerPanel.add(customerName);
// topCustomerPanel.add(branchName);
//
// JPanel branchPanel = new JPanel();
// branchPanel.setLayout(new GridLayout(1, 2, 10, 5));
// JButton SanFrancisco, Dallas, New_York;
// JLabel branch = new JLabel(" Branch:");
// SanFrancisco = new JButton("San Francisco");
// Dallas = new JButton("Dallas");
// New_York = new JButton("New York");
// branchPanel.setLayout(new GridLayout(1, 1, 10, 5));
// branchPanel.add(branch);
// branchPanel.add(SanFrancisco);
// branchPanel.add(Dallas);
// branchPanel.add(New_York);
//
// JPanel itemPanel = new JPanel();
// itemPanel.setLayout(new GridLayout(1, 2, 10, 5));
// JButton search = new JButton("Search");
// Connect.connect();
// String[] item = Connect.getCategory();
// // String [] item = {"a","b","c"};
// JComboBox<String> itemComboBox = new JComboBox<String>(item);
// itemPanel.add(itemComboBox);
// itemPanel.add(search);
// customerPanel.add(topCustomerPanel);
// customerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
// customerPanel.add(branchPanel);
// customerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
// customerPanel.add(itemPanel);
// customerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
// add(customerPanel);
//
// String[][] myArray = new String[10][5];
// search.addActionListener(new ActionListener() {
//
// @Override
// public void actionPerformed(ActionEvent e) {
// // TODO Auto-generated method stub
// Object a = itemComboBox.getSelectedItem();
// // System.out.println(a);
// aa = (String) a;
// //bb = Connect.getCategoryItem(aa);
// // String[][] cc = Connect.getCategoryItem(aa);
// //System.out.println(bb[0][1]);
// for (int i = 0; i <myArray.length; i++) {
// for (int j = 0; j < 3; j++) {
// // myArray[i][j] = cc[i][j];
// //bc[i][]
// }
// }
// customerPanel.repaint();
// }
// });
// JPanel productPanela = new JPanel();
// productPanela.setLayout(new FlowLayout(FlowLayout.TRAILING));
// JPanel productPanel = new JPanel();
// productPanel.setLayout(new GridLayout(2, 5, 2, 0));
// String[] columTitle = { "Product", "Price", "Available", "Add to Cart" };
//
// Object[][] productList = myArray;
//
// JTable productTable = new JTable(productList, columTitle);
//
// productTable.getColumn("Add to Cart").setCellRenderer(new ButtonRenderer());
// productTable.getColumn("Add to Cart").setCellEditor(
// new ButtonEditor(new JCheckBox()));
//
// productPanel.add(new JScrollPane(productTable));
// JPanel buttonPanel = new JPanel();
// buttonPanel.setLayout(new GridLayout(6, 1, 2, 0));
//// JLabel quantityLabel = new JLabel("Add Quantity");
//// buttonPanel.add(quantityLabel);
//// for (int i = 0; i < myArray.length; i++) {
//// JButton button1 = new JButton("add1");
//// buttonPanel.add(button1);
//// }
// productPanela.add(productPanel);
//// productPanela.add(buttonPanel);
//
// customerPanel.add(productPanela);
//
// }
//
//
//
// }
// class ButtonRenderer extends JButton implements TableCellRenderer {
//
// /**
// *
// */
// private static final long serialVersionUID = 1L;
//
// public ButtonRenderer() {
// setOpaque(true);
// }
//
// public Component getTableCellRendererComponent(JTable table, Object value,
// boolean isSelected, boolean hasFocus, int row, int column) {
// if (isSelected) {
// setForeground(table.getSelectionForeground());
// setBackground(table.getSelectionBackground());
// } else {
// setForeground(table.getForeground());
// setBackground(UIManager.getColor("Button.background"));
// }
// setText((value == null) ? "Add to cart" : value.toString());
// return this;
// }
// }
//
// /**
// * @version 1.0 11/09/98
// */
//
// class ButtonEditor extends DefaultCellEditor {
// /**
// *
// */
// private static final long serialVersionUID = 1L;
//
// protected JButton button;
//
// private String label;
//
// private boolean isPushed;
//
// public ButtonEditor(JCheckBox checkBox) {
// super(checkBox);
// button = new JButton();
// button.setOpaque(true);
// button.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent e) {
// fireEditingStopped();
// }
// });
// }
//
// public Component getTableCellEditorComponent(JTable table, Object value,
// boolean isSelected, int row, int column) {
// if (isSelected) {
// button.setForeground(table.getSelectionForeground());
// button.setBackground(table.getSelectionBackground());
// } else {
// button.setForeground(table.getForeground());
// button.setBackground(table.getBackground());
// }
// label = (value == null) ? "Add to cart" : value.toString();
// button.setText(label);
// isPushed = true;
// return button;
// }
//
// public Object getCellEditorValue() {
// if (isPushed) {
// //
// //
// JOptionPane.showMessageDialog(button, label + ": Ouch!");
// // System.out.println( label + ": Ouch!");
// }
// isPushed = false;
// return new String(label);
// }
//
// public boolean stopCellEditing() {
// isPushed = false;
// return super.stopCellEditing();
// }
//
// protected void fireEditingStopped() {
// super.fireEditingStopped();
// }
// }