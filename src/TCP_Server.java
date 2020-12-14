

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class TCP_Server extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JLabel lblContent;
	private JButton btnGui;
	private JLabel lblTcpServer;
	private static JLabel lbNoiDung;
	private JTextPane textPane;
	private static final String ADDRESS = "127.0.0.1";
	private static final int IP = 3000;
	private static JLabel lblInfo;
	
	private static  ServerSocket serverSocket;
	private static Socket socket;
	private static DataInputStream dataIn;
	private static DataOutputStream dataOut;
	/**
	 * Launch the application.
	 */
	public TCP_Server() {
		try {
			System.out.println("Cho ket noi");
			serverSocket = new ServerSocket(IP);
			socket = serverSocket.accept();
			System.out.println("Client ket noi");
			dataOut = new DataOutputStream (socket.getOutputStream());
			dataIn = new DataInputStream(socket.getInputStream());
		}catch(Exception e) {}
	}
	
	public static void main(String[] args) {
		try {
			TCP_Server frame = new TCP_Server();
			frame.initFrame();
			frame.setVisible(true);
			//lblInfo.setText(ADDRESS+":"+IP);
			
			
			while(true) {
				String str = dataIn.readUTF();
				if(str.equals("q")) {
					break;
				}
				lbNoiDung.setText(str);
			}
			dataOut.close();
			dataIn.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Create the frame.
	 */
	public void initFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblTcpServer = new JLabel("TCP SERVER ");
		GridBagConstraints gbc_lblTcpServer = new GridBagConstraints();
		gbc_lblTcpServer.insets = new Insets(0, 0, 5, 0);
		gbc_lblTcpServer.gridx = 1;
		gbc_lblTcpServer.gridy = 0;
		contentPane.add(lblTcpServer, gbc_lblTcpServer);
		
		textPane = new JTextPane();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridheight = 4;
		gbc_textPane.insets = new Insets(0, 0, 5, 0);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 1;
		gbc_textPane.gridy = 1;
		contentPane.add(textPane, gbc_textPane);
		
		lblContent = new JLabel("Ná»™i dung gá»­i");
		GridBagConstraints gbc_lblContent = new GridBagConstraints();
		gbc_lblContent.anchor = GridBagConstraints.EAST;
		gbc_lblContent.insets = new Insets(0, 0, 5, 5);
		gbc_lblContent.gridx = 0;
		gbc_lblContent.gridy = 2;
		contentPane.add(lblContent, gbc_lblContent);
		
		btnGui = new JButton("Gá»­i");
		btnGui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					dataOut.writeUTF(textPane.getText());
					dataOut.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnG = new GridBagConstraints();
		gbc_btnG.insets = new Insets(0, 0, 5, 0);
		gbc_btnG.gridx = 1;
		gbc_btnG.gridy = 6;
		contentPane.add(btnGui, gbc_btnG);
		
		lbNoiDung = new JLabel("Ná»™i dung");
		GridBagConstraints gbc_lblNiDung = new GridBagConstraints();
		gbc_lblNiDung.gridx = 1;
		gbc_lblNiDung.gridy = 7;
		contentPane.add(lbNoiDung, gbc_lblNiDung);
	}

}
