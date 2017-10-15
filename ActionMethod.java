package com.solar;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ActionMethod extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String aa;
	static String[][] bb;
	static JPanel MpanelInventory, MpanelAddInvetory;

	public static JPanel inventory() {
		System.out.println("inventory button = action method inventory");
		MpanelInventory = new JPanel();
		MpanelInventory.setLayout(new BoxLayout(MpanelInventory, BoxLayout.Y_AXIS));
		JPanel serachPanel = new JPanel();
		serachPanel.setLayout(new GridLayout(1, 2, 10, 5));
		JButton search = new JButton("Search");
		String[] item = Connect.getCategory();
		JComboBox<String> itemComboBox = new JComboBox<String>(item);
		serachPanel.add(itemComboBox);
		serachPanel.add(search);
		String[][] myArray = new String[10][5];
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object a = itemComboBox.getSelectedItem();
				aa = (String) a;
				bb = Connect.getCategoryItem(aa);
				String[][] cc = Connect.getCategoryItem(aa);
				for (int i = 0; i < myArray.length; i++) {
					for (int j = 0; j < 3; j++) {
						myArray[i][j] = cc[i][j];
					}
				}
				MpanelInventory.repaint();
			}
		});
		JPanel productPanel = new JPanel();
		productPanel.setLayout(new GridLayout(2, 5, 2, 0));
		String[] columTitle = { "Product", "Price", "Available" };
		Object[][] productList = myArray;
		JTable productTable = new JTable(productList, columTitle);
		productPanel.add(new JScrollPane(productTable));
		MpanelInventory.add(serachPanel);
		MpanelInventory.add(productPanel);
		
		return MpanelInventory;

	}

	public static JPanel addInventory() {

		String[][] myArrayAddInv = new String[5][4];
		MpanelAddInvetory = new JPanel();
		MpanelAddInvetory.setLayout(new BoxLayout(MpanelAddInvetory, BoxLayout.Y_AXIS));

		System.out.println("addInventory button = action method addInventory");
		JPanel addInvePanel = new JPanel();
		addInvePanel.setLayout(new BoxLayout(addInvePanel, BoxLayout.Y_AXIS));

		JPanel serachPanel = new JPanel();
		serachPanel.setLayout(new GridLayout(1, 2, 1, 1));
		JButton search = new JButton("Search");
		String[] item2 = Connect.getCategory();
		JComboBox<String> itemComboBox2 = new JComboBox<String>(item2);
		serachPanel.add(itemComboBox2);
		serachPanel.add(search);
		
		JPanel productPanel2 = new JPanel();
		productPanel2.setLayout(new GridLayout(2, 5, 0, 0));
		String[] columTitle2 = { "Product", "Price", "Available","Add Item" };
		Object[][] productList = myArrayAddInv;
		JTable productTable2 = new JTable(productList, columTitle2);
		productPanel2.add(new JScrollPane(productTable2));
		MpanelAddInvetory.add(serachPanel);
		MpanelAddInvetory.add(productPanel2);
		
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object a = itemComboBox2.getSelectedItem();
				aa = (String) a;
				bb = Connect.getCategoryItem(aa);
				String[][] cc = Connect.getCategoryItem(aa);
				for (int i = 0; i < myArrayAddInv.length; i++) {
					for (int j = 0; j < 3; j++) {
						myArrayAddInv[i][j] = cc[i][j];
					}
				}
				MpanelAddInvetory.repaint();
			}
		});
		return MpanelAddInvetory;

	}

}
