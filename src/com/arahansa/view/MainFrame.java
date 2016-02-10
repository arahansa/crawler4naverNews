package com.arahansa.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.arahansa.view.panel.MainUpperPanel;

public class MainFrame extends JFrame {

	MainUpperPanel mainUpper = new MainUpperPanel();
	
	public MainFrame() {
		add(mainUpper, BorderLayout.NORTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(200, 200, 800, 600);
		setTitle("MainFrame");
	}
	
	public static void main(String[] args){
		new MainFrame();
	}
}
