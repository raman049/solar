package com.solar.validation;

import javax.swing.JOptionPane;

public class ValidationIntegerValue {

	public static boolean isInteger(Object ob) {
		// Object ob = productTable2.getValueAt(i, 2);
		if (ob != null) {
			try {
				String b = String.valueOf(ob);
				int bi = 0;
				if (b != "") {
					bi = Integer.valueOf(b);
					if (bi < 0) {
						throw new Exception();
					}
				}
				return true;
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Quantiy must be a positive number only", "InfoBox: " + "Error",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			}

		} else {
			return false;
		}
	}

}
