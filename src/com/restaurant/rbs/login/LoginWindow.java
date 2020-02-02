package com.restaurant.rbs.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.MatteBorder;

import com.restaurant.rbs.basic.MainFrame;
import com.restaurant.rbs.dao.UserDao;
import com.restaurant.rbs.dao.UserDaoImplement;
import com.restaurant.rbs.model.User;


import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;

public class LoginWindow extends JFrame {

	private static final long serialVersionUID = -2105648140141259074L;
	private JPanel contentPane;
	private JPasswordField txtPassword;
	private JPasswordField txtPassword_R;
	private JPasswordField txtMasterKey;
	public JLabel idLbl;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel heading = new JPanel();
		heading.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		heading.setBounds(0, 0, 400, 80);
		heading.setBackground(Color.WHITE);
		contentPane.add(heading);
		heading.setLayout(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setIcon(null);
		lblLogin.setBackground(Color.GRAY);
		lblLogin.setBounds(166, 24, 68, 33);
		heading.add(lblLogin);
		lblLogin.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));

		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(new LoginWindow(), "Confirm if you want to Close", "Login Systems",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnX.setBackground(Color.WHITE);
		btnX.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnX.setBounds(355, -1, 45, 20);
		heading.add(btnX);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 80, 400, 320);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Login", null, panel, null);
		panel.setLayout(null);

		JFormattedTextField txtUsername = new JFormattedTextField();
		txtUsername.setForeground(Color.GRAY);
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().equals("Username...")) {
					txtUsername.setText("");
				}
				txtUsername.setForeground(Color.black);
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().equals("")) {
					txtUsername.setText("Username...");
					txtUsername.setForeground(Color.GRAY);
				}
			}
		});
		txtUsername.setText("Username...");
		txtUsername.setToolTipText("Enter your username!");
		txtUsername.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		txtUsername.setBounds(82, 45, 254, 37);
		panel.add(txtUsername);

		txtPassword = new JPasswordField();
		txtPassword.setForeground(Color.GRAY);
		txtPassword.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		char passwordChar = txtPassword.getEchoChar();
		txtPassword.setEchoChar((char) 0);
		txtPassword.setText("Password...");
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtPassword.getText().equals("")) {
					txtPassword.setEchoChar((char) 0);
					txtPassword.setText("Password...");
					txtPassword.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (txtPassword.getText().equals("Password...")) {
					txtPassword.setText("");
					txtPassword.setEchoChar(passwordChar);
					txtPassword.setForeground(Color.BLACK);
				}
			}

		});
		txtPassword.setBounds(82, 104, 254, 37);
		panel.add(txtPassword);

		JLabel userIcon = new JLabel("");
		userIcon.setIcon(new ImageIcon(LoginWindow.class.getResource("/username.PNG")));
		userIcon.setBounds(45, 45, 37, 37);
		panel.add(userIcon);

		JLabel passIcon = new JLabel("");
		passIcon.setIcon(new ImageIcon(LoginWindow.class.getResource("/password.PNG")));
		passIcon.setBounds(45, 104, 37, 37);
		panel.add(passIcon);

		JCheckBox chckbxRememberMe = new JCheckBox("Remember Me");
		chckbxRememberMe.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		chckbxRememberMe.setBackground(Color.WHITE);
		chckbxRememberMe.setBounds(45, 155, 131, 23);
		panel.add(chckbxRememberMe);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 209, 375, 2);
		panel.add(separator);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDao userDao = new UserDaoImplement();
				User user = new User();
				user.setUsername(txtUsername.getText());
				user.setPassword(new String(txtPassword.getPassword()));
			}
		});
		btnNewButton.setBounds(0, 226, 395, 66);
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
		
		btnNewButton.setForeground(Color.WHITE);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Register", null, panel_1, null);
		panel_1.setLayout(null);

		JFormattedTextField txtUsername_R = new JFormattedTextField();
		txtUsername_R.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername_R.getText().equals("Username...")) {
					txtUsername_R.setText("");
				}
				txtUsername_R.setForeground(Color.black);
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername_R.getText().equals("")) {
					txtUsername_R.setText("Username...");
					txtUsername_R.setForeground(Color.GRAY);
				}
			}
		});
		txtUsername_R.setToolTipText("Enter your username!");
		txtUsername_R.setText("Username...");
		txtUsername_R.setForeground(Color.GRAY);
		txtUsername_R.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		txtUsername_R.setBounds(82, 45, 254, 37);
		panel_1.add(txtUsername_R);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginWindow.class.getResource("/username.png")));
		label.setBounds(45, 45, 37, 37);
		panel_1.add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(LoginWindow.class.getResource("/password.png")));
		label_1.setBounds(45, 93, 37, 37);
		panel_1.add(label_1);

		txtPassword_R = new JPasswordField();
		char passwordChar1 = txtPassword_R.getEchoChar();
		txtPassword_R.setEchoChar((char) 0);
		txtPassword_R.setForeground(Color.GRAY);
		txtPassword_R.setText("Password...");
		txtPassword_R.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		txtPassword_R.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtPassword_R.getText().equals("")) {
					txtPassword_R.setEchoChar((char) 0);
					txtPassword_R.setText("Password...");
					txtPassword_R.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (txtPassword_R.getText().equals("Password...")) {
					txtPassword_R.setText("");
					txtPassword_R.setEchoChar(passwordChar1);
					txtPassword_R.setForeground(Color.BLACK);
				}
			}

		});
		txtPassword_R.setBounds(82, 93, 254, 37);
		panel_1.add(txtPassword_R);

		idLbl = new JLabel("");
		idLbl.setBounds(10, 11, 46, 14);
		contentPane.add(idLbl);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDao userDao = new UserDaoImplement();
				User user = new User();
				user.setUsername(txtUsername_R.getText());
				user.setPassword(new String(txtPassword_R.getPassword()));
				String masterkey = new String(txtMasterKey.getPassword());

				String userId = idLbl.getText();
				
				if (txtUsername_R.getText().equals("Username...")||txtPassword_R.getText().equals("")||txtMasterKey.getText().equals("")) {
					JOptionPane.showMessageDialog(new LoginWindow(), "Oops!!! You missed something!!!", "Error",
							JOptionPane.ERROR_MESSAGE);
//					txtPassword_R.setText("");
//					txtMasterKey.setText("");
				}
				else {
					
				
				if (masterkey.equals("5378")) {
					if (userId == null || userId.isEmpty()) {

						int saved = userDao.createUser(user);
						if (saved >= 1) {
							JOptionPane.showMessageDialog(new LoginWindow(), "User is created successfully!!!", "Created",
									JOptionPane.PLAIN_MESSAGE);
							LoginWindow loginWin = new LoginWindow();
							loginWin.setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(new LoginWindow(), "Oops!!! Error occurred in db!!!", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						user.setId(Integer.parseInt(userId));
						int updated = userDao.updateUser(user);
						if (updated >= 1) {
							JOptionPane.showMessageDialog(new LoginWindow(), "User info is updated successfully!!!",
									"Updated", JOptionPane.PLAIN_MESSAGE);
							MainFrame loginWin = new MainFrame();
							loginWin.setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(new LoginWindow(), "Oops!!! Error occurred in db!!!", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(new LoginWindow(), "Oops!!! The master key is incorrect. Please contact your system administrator!!!", "Error",
							JOptionPane.ERROR_MESSAGE);
					txtPassword_R.setText("");
					txtMasterKey.setText("");
				}

				}
			}
		});
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
		btnRegister.setBackground(new Color(30, 144, 255));
		btnRegister.setBounds(0, 226, 395, 66);
		panel_1.add(btnRegister);

		txtMasterKey = new JPasswordField();
		char masterKey = txtMasterKey.getEchoChar();
		txtMasterKey.setEchoChar((char) 0);
		txtMasterKey.setForeground(Color.GRAY);
		txtMasterKey.setText("Master Key...");
		txtMasterKey.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		txtMasterKey.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtMasterKey.getText().equals("")) {
					txtMasterKey.setEchoChar((char) 0);
					txtMasterKey.setText("Master Key...");
					txtMasterKey.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (txtMasterKey.getText().equals("Master Key...")) {
					txtMasterKey.setText("");
					txtMasterKey.setEchoChar(masterKey);
					txtMasterKey.setForeground(Color.BLACK);
				}
			}

		});
		txtMasterKey.setBounds(82, 141, 254, 37);
		panel_1.add(txtMasterKey);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(LoginWindow.class.getResource("/password.png")));
		label_2.setBounds(45, 141, 37, 37);
		panel_1.add(label_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 209, 375, 2);
		panel_1.add(separator_1);

	}
}
