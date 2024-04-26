package com.dit.chatapp.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserView extends JFrame {
	int counter;
	public UserView() {
		counter=0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500); //size of window
		setResizable(false); //window will be of fix size i.e. maximise and minimise option will be removed
		setTitle("Login");
		setLocationRelativeTo(null); //window will appear always at the centre of the screen
		//setLocation(500,150); //sets the coordinates(x and y) according to the screen
		JLabel welcome = new JLabel("Login");
		welcome.setFont(new Font("Arial",Font.BOLD,40)); //Label font
		Container container = this.getContentPane();
		container.setLayout(null);
		welcome.setBounds(100, 70, 200, 60);
		container.add(welcome);
		JButton button = new JButton("Count"); //Source
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				counter++;
				welcome.setText("Count "+counter);
			}
		});
		button.setBounds(100, 300, 200, 50);
		container.add(button);
		setVisible(true);
	}
	public static void main(String[] args) {
		UserView userView = new UserView();
	}
}
