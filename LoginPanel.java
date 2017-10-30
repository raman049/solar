package com.solar;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginPanel() {

		JLabel username_JL, password_JL;
		JButton newuser_JB, login_JB, forgetpass_JB;
		JTextField username_TF, password_TF;
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3, 2, 0, 5));
		username_JL = new JLabel("    User name: ");
		password_JL = new JLabel("    Password : ");
		username_TF = new JTextField(20);
		password_TF = new JTextField(20);
		newuser_JB = new JButton("Create new user ");
		login_JB = new JButton("Login ");

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1, 2, 0, 5));
		forgetpass_JB = new JButton("Forget Password");
		panel2.add(forgetpass_JB);

		panel1.add(username_JL);
		panel1.add(username_TF);
		panel1.add(password_JL);
		panel1.add(password_TF);
		panel1.add(newuser_JB);
		panel1.add(login_JB);
		// add(panel1);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(panel1);
		panel.add(panel2);
		add(panel);

		newuser_JB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("new user button");
			}
		});
		login_JB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("login button");
				String[] user = new String[2];
				String username = username_TF.getText();
				String password = password_TF.getText();
				if (username.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Check your username and password",
							"InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
				} else {
					Connect.connect();
					user = Connect.login(username, password);
					if (user == null) {
						JOptionPane.showMessageDialog(null, "Incorrect login", "InfoBox: " + "Error",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						panel.setVisible(false);
						if (user[1].equalsIgnoreCase("0")) {
							ManagerPanel managerPanel = new ManagerPanel(username);
							add(managerPanel);
						}
						if (user[1].equalsIgnoreCase("1") ||user[1].equalsIgnoreCase("2") ) {
							UserPanel userPanel = new UserPanel(username);
							add(userPanel);
						}
					}
				}

			}
		});
		forgetpass_JB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("forget password button");
			}
		});

	}

}
