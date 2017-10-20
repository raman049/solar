package com.solar;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.*;

public class ActionMethod extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static ResultSet bb;
	static JPanel MpanelInventory, MpanelAddInvetory;
	static JLabel itemLabel;
	static JLabel priceLabel;
	static JLabel quantityLabel;
	static JTable productTable2;

	public static JPanel inventory() {
		MpanelInventory = new JPanel();
		MpanelInventory.setLayout(new BoxLayout(MpanelInventory, BoxLayout.Y_AXIS));
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new GridLayout(1, 2, 10, 5));
		JButton search = new JButton("Search");
		String[] item = Connect.getCategory();
		JComboBox<String> itemComboBox = new JComboBox<String>(item);
		searchPanel.add(itemComboBox);
		searchPanel.add(search);
		MpanelInventory.add(searchPanel);
		JPanel productPanel = new JPanel();
		productPanel.setLayout(new GridLayout(5, 3));
		productPanel.setVisible(false);
		MpanelInventory.add(productPanel);
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object category = itemComboBox.getSelectedItem();
				List<ProdutDetail> cc = Connect.getCategoryItem(String.valueOf(category));
				String[] columTitle = { "Product", "Price", "Available" };
				Object[][] productList = new Object[cc.size()][3];
				productPanel.removeAll();
				int j = 0;
				for (ProdutDetail i : cc) {
					itemLabel = new JLabel(i.pname);
					priceLabel = new JLabel(String.valueOf(i.pprice));
					quantityLabel = new JLabel(String.valueOf(i.pqty));
					productList[j][0] = i.pname;
					productList[j][1] = i.pprice;
					productList[j][2] = i.pqty;
					j++;
				}
				JTable productTable = new JTable(productList, columTitle);
				productTable.setEnabled(false);
				JScrollPane jScrollPane = new JScrollPane(productTable);
				jScrollPane.setPreferredSize(new Dimension(100, 150));
				productPanel.add(jScrollPane);
				productPanel.validate();
				productPanel.repaint();
				productPanel.setVisible(true);
			}
		});
		MpanelInventory.repaint();
		return MpanelInventory;
	}

	public static JPanel addInventory() {
		System.out.println("addINvent panel");
		MpanelAddInvetory = new JPanel();
		MpanelAddInvetory.setLayout(new BoxLayout(MpanelAddInvetory, BoxLayout.Y_AXIS));
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new GridLayout(1, 3, 10, 5));
		JButton search = new JButton("Search");
		JButton update = new JButton("Update");
		String[] item = Connect.getCategory();
		JComboBox<String> itemComboBox = new JComboBox<String>(item);
		searchPanel.add(itemComboBox);
		searchPanel.add(search);

		MpanelAddInvetory.add(searchPanel);
		JPanel productPanel = new JPanel();
		productPanel.setLayout(new GridLayout(5, 3));
		productPanel.setVisible(false);
		MpanelAddInvetory.add(productPanel);
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object category = itemComboBox.getSelectedItem();
				List<ProdutDetail> cc = Connect.getCategoryItem(String.valueOf(category));
				String[] columTitle = { "Product", "Price", "Available", "Add Quantity" };
				Object[][] productList = new Object[cc.size()][4];
				productPanel.removeAll();
				int j = 0;
				for (ProdutDetail i : cc) {
					itemLabel = new JLabel(i.pname);
					priceLabel = new JLabel(String.valueOf(i.pprice));
					quantityLabel = new JLabel(String.valueOf(i.pqty));
					productList[j][0] = i.pname;
					productList[j][1] = i.pprice;
					productList[j][2] = i.pqty;
					j++;
				}
				productTable2 = new JTable(productList, columTitle) {
					
					private static final long serialVersionUID = 1L;

					public boolean isCellEditable(int row, int column) {
						if (column == productTable2.getColumnCount() - 1)
							return true;
						return false;
					}
				};

				//productTable2.setEnabled(false);

				JScrollPane jScrollPane = new JScrollPane(productTable2);
				jScrollPane.setPreferredSize(new Dimension(100, 150));
				productPanel.add(jScrollPane);
				productPanel.validate();
				productPanel.repaint();
				searchPanel.add(update);
				productPanel.setVisible(true);

			}

		});

		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("updated item");
				// System.out.println(productTable2.getRowCount());
				for (int i = 0; i < productTable2.getRowCount(); i++) {
					Object oa = productTable2.getValueAt(i, 2);
					Object ob = productTable2.getValueAt(i, 3);
					String productName = (String) productTable2.getValueAt(i, 0);
					if (oa != null && ob != null) {
						String a = String.valueOf(oa);
						try {
							String b = String.valueOf(ob);
							int ai = Integer.valueOf(a);
							int bi = 0;
							if (b != "") {
								bi = Integer.valueOf(b);
								if (bi < 0) {
									throw new Exception();
								}
							}
							int newQuantity = ai + bi;
							Connect.updateQuantity(productName, newQuantity);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Quantiy must be a positive number only",
									"InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				JOptionPane.showMessageDialog(null, "update successful", "InfoBox: " + "Error",
						JOptionPane.INFORMATION_MESSAGE);
				MpanelAddInvetory.setVisible(false);
			}
		});
		MpanelAddInvetory.repaint();
		return MpanelAddInvetory;

	}

}
