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
	static ResultSet rs3;

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

	public static String[] login(String username, String password) {
		String[] output = new String[2];
		try {
			String query = "SELECT STAFFCODE, PASSWORD,STATUS FROM users WHERE STAFFCODE ='" + username + "' ";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				if (rs.getString("STAFFCODE").equals(username) && rs.getString("PASSWORD").equals(password)) {
					System.out.println("approved");
					output[0] = username;
					output[1] = rs.getString("STATUS");
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

	public static String[] userinfo(String user) {
		String[] userInfo = new String[4];
		try {
			String query = "SELECT * FROM staffmain WHERE STAFFCODE ='" + user + "' ";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				userInfo[0] = rs.getString("FIRSTNAME");
				userInfo[1] = rs.getString("LASTNAME");
				userInfo[2] = rs.getString("BRANCHID");
				userInfo[3] = rs.getString("BRANCHNAME");
			}
		} catch (Exception e) {
			System.out.println("userinfo query failed");
		}

		return userInfo;
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

	public static List<ProdutDetail> getCategoryItem(String category) {
		String catid = null;
		String[] pid = new String[10];
		int i = 0;
		List<ProdutDetail> catItem = new ArrayList<ProdutDetail>();
		try {
			// get category
			String query = "SELECT cat_id FROM category WHERE cat_name ='" + category + "' ";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				catid = rs.getString("cat_id");
			}
			// connect category with product id
			// for ALL
			String query2;
			if (catid.equals("2000")) {
				 query2 = "SELECT * FROM product_configure";
			}else{ 
				//for each category
				 query2 = "SELECT pid FROM product_configure WHERE cat_id ='" + catid + "' ";
			}
			ResultSet rs2 = st.executeQuery(query2);
			while (rs2.next()) {
				pid[i] = rs2.getString("pid");
				i++;
			}

			for (String j : pid) {
				String query3 = "SELECT * FROM product WHERE pid =' " + j + " ' ";
				rs3 = st.executeQuery(query3);
				while (rs3.next()) {
					ProdutDetail pd = new ProdutDetail(rs3.getString("pname"),
							Integer.parseInt(rs3.getString("pprice")), Integer.parseInt(rs3.getString("pqty")));
					catItem.add(pd);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return catItem;
	}

	public static void updateQuantity(String productName, int newQuantity){
		try{
			String query = "UPDATE product set pqty = '"+newQuantity+"' WHERE pname = '"+productName+"' ";
			st.executeUpdate(query);
			System.out.println("update quantity");
		}catch(Exception e){
			System.out.println("update query failed");
		}
	}
}

class ProdutDetail {
	int pid;
	String pname;
	String pcode;
	int pprice;
	int pqty;

	public ProdutDetail(String pname, int pprice, int pqty) {
		this.pprice = pprice;
		this.pname = pname;
		this.pqty = pqty;

	}

	public ProdutDetail(int pid, String pname, String pcode, int pprice, int pqty) {
		this.pprice = pprice;
		this.pname = pname;
		this.pqty = pqty;

	}

}
