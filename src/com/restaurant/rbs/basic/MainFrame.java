package com.restaurant.rbs.basic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainFrame extends JFrame {

	
	private static final long serialVersionUID = 2617712607372698084L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		setTitle("Michealal Bajeko Sekuwa Corner & Restaurant and Chiya ghar hai guyzzz!!!!");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Maikalal Bajeko Sekuwa Corner & Restaurant and Chiya Ghar hai gaichhh!!");
		lblTitle.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 23));
		lblTitle.setBounds(561, 11, 782, 64);
		contentPane.add(lblTitle);
		
		JLabel lblSubTitle = new JLabel("\"Yeh hajur kata? Maikalal Bajeko Sekuwa Corner & Restaurant and Chiya Ghar Yeta!!!!!\"");
		lblSubTitle.setBounds(737, 62, 429, 36);
		contentPane.add(lblSubTitle);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(360, 203, 12, 787);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 288, 340, 12);
		contentPane.add(separator_1);
		
		JLabel lblTables = new JLabel("Tables");
		lblTables.setBounds(134, 203, 46, 14);
		contentPane.add(lblTables);
		
		JButton btnAll = new JButton("All");
		btnAll.setBackground(new Color(0, 128, 0));
		btnAll.setForeground(Color.WHITE);
		btnAll.setBounds(20, 241, 72, 36);
		contentPane.add(btnAll);
		
		JButton btnDining = new JButton("Dining");
		btnDining.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDining.setBounds(100, 241, 72, 36);
		contentPane.add(btnDining);
		
		JButton btnPacking = new JButton("Packing");
		btnPacking.setBounds(182, 241, 72, 36);
		contentPane.add(btnPacking);
		
		JButton btnOccupied = new JButton("Occupied");
		btnOccupied.setBounds(264, 241, 72, 36);
		contentPane.add(btnOccupied);
	}
}
