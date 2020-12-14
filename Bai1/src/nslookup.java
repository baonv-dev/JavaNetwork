import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class nslookup extends JFrame {

	private JPanel contentPane;
	private JTextField txtIp;
	private JLabel lblHostname;
	private JTextField txtHost;
	private JButton btnFindIp;
	private JButton btnFindHost;
	private JButton btnClear;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nslookup frame = new nslookup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public nslookup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblIpAddress = new JLabel("IP ADDRESS");
		GridBagConstraints gbc_lblIpAddress = new GridBagConstraints();
		gbc_lblIpAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblIpAddress.anchor = GridBagConstraints.EAST;
		gbc_lblIpAddress.gridx = 0;
		gbc_lblIpAddress.gridy = 0;
		contentPane.add(lblIpAddress, gbc_lblIpAddress);
		
		txtIp = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPane.add(txtIp, gbc_textField);
		txtIp.setColumns(10);
		
		lblHostname = new JLabel("Hostname");
		GridBagConstraints gbc_lblHostname = new GridBagConstraints();
		gbc_lblHostname.anchor = GridBagConstraints.EAST;
		gbc_lblHostname.insets = new Insets(0, 0, 5, 5);
		gbc_lblHostname.gridx = 0;
		gbc_lblHostname.gridy = 1;
		contentPane.add(lblHostname, gbc_lblHostname);
		
		txtHost = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		contentPane.add(txtHost, gbc_textField_1);
		txtHost.setColumns(10);
		
		btnFindIp = new JButton("Find IP");
		btnFindIp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					InetAddress host = InetAddress.getByName(txtHost.getText());
	                String hostname = host.getHostAddress();
	                txtIp.setText(hostname);
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnFindIp = new GridBagConstraints();
		gbc_btnFindIp.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFindIp.insets = new Insets(0, 0, 5, 0);
		gbc_btnFindIp.gridx = 1;
		gbc_btnFindIp.gridy = 2;
		contentPane.add(btnFindIp, gbc_btnFindIp);
		
		btnFindHost = new JButton("Find Host");
		btnFindHost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					InetAddress host = InetAddress.getByName(txtIp.getText());
	                String hostname = host.getHostName();
	                txtHost.setText(hostname);
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                //System.out.println(“Ten may chu : ” + hostname);
			}
		});
		GridBagConstraints gbc_btnFindHost = new GridBagConstraints();
		gbc_btnFindHost.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFindHost.insets = new Insets(0, 0, 5, 0);
		gbc_btnFindHost.gridx = 1;
		gbc_btnFindHost.gridy = 3;
		contentPane.add(btnFindHost, gbc_btnFindHost);
		
		btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtIp.setText("");
				txtHost.setText("");
			}
		});
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnClear.insets = new Insets(0, 0, 5, 0);
		gbc_btnClear.gridx = 1;
		gbc_btnClear.gridy = 4;
		contentPane.add(btnClear, gbc_btnClear);
		
		btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExit.gridx = 1;
		gbc_btnExit.gridy = 5;
		contentPane.add(btnExit, gbc_btnExit);
	}

}
