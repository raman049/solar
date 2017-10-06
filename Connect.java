package com.solar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Connect {
	static Connection con;
	static Statement st;

	public static void connect() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/solar", "root", "");
			st = con.createStatement();
			System.out.println("connection estab");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String login(String username, String password) {
		String output = null;
		try {
			String query = "SELECT STAFFCODE, PASSWORD FROM users WHERE STAFFCODE ='" + username + "' ";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				if (rs.getString("STAFFCODE").equals(username) && rs.getString("PASSWORD").equals(password)) {
					System.out.println("approved");
					output = username;
				} else {
					System.out.println("disapproved");
					JOptionPane.showMessageDialog(null, "Please Check your username and password",
							"InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
					output = null;
				}
			}
		} catch (Exception e) {
			System.out.println("login query failed");
		}
		return output;
	}

	public static String[] getCategory() {
		// String [] item = {};
		String[] item = new String[10];
		int i = 0;
		try {
			String query = "SELECT cat_id, cat_name FROM category ";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				item[i] = rs.getString("cat_name");
				i++;
			}
		} catch (Exception e) {
			System.out.println("getCategory query failed");
		}
		return item;
	}

	public static String[][] getCategoryItem(String category) {
		String catid = null;
		String[] pid = new String[10];
		String[] pdetail = new String[3];
		String[][] output = new String[10][3];
		int i = 0;
		int k = 0;

		try {
			// get category
			String query = "SELECT cat_id FROM category WHERE cat_name ='" + category + "' ";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				catid = rs.getString("cat_id");
			//	System.out.println(catid);
			}
			// connect category with product id
			String query2 = "SELECT pid FROM product_configure WHERE cat_id ='" + catid + "' ";
			ResultSet rs2 = st.executeQuery(query2);
			while (rs2.next()) {
				pid[i] = rs2.getString("pid");
				//System.out.println("pid" + pid[i]);
				i++;
			}
			// get product detail for category
			for (String j : pid) {
				String query3 = "SELECT * FROM product WHERE pid =' " + j + " ' ";
				ResultSet rs3 = st.executeQuery(query3);
				while (rs3.next()) {
					pdetail[0] = rs3.getString("pname");
					pdetail[1] = rs3.getString("pprice");
					pdetail[2] = rs3.getString("pqty");
					output[k][0] = pdetail[0];
					output[k][1] = pdetail[1];
					output[k][2] = pdetail[2];
					k++;
				}
			}
		} catch (Exception e) {
			System.out.println(e);// "getCategoryItem query failed");
		}
		return output;
	}

}
