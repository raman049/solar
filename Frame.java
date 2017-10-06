package com.solar;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;



public class Frame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Frame(){
		setTitle("SOLAR PROJECT");
		getContentPane().setBackground(Color.gray);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/4, Toolkit.getDefaultToolkit().getScreenSize().height/4,Toolkit.getDefaultToolkit().getScreenSize().width/2, Toolkit.getDefaultToolkit().getScreenSize().height/2);
		setResizable(true);
		isVisible();
		LoginPanel loginPanel = new LoginPanel();
		add(loginPanel);
			
	}

}
