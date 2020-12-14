/*
 * 1. Sá»­ dá»¥ng ká»¹ thuáº­t láº­p trÃ¬nh TCP Socket viáº¿t chÆ°Æ¡ng trÃ¬nh trao Ä‘á»•i dá»¯ liá»‡u giá»¯a 2 mÃ¡y Server vÃ  Client 
 * thá»±c hiá»‡n cÃ´ng viá»‡c sau: 
 * - Thiáº¿t láº­p káº¿t ná»‘i giá»¯a 2 mÃ¡y tÃ­nh trÃªn Ä‘á»‹a chá»‰ 192.168.0.1 sá»­ dá»¥ng cá»•ng 2015. 
 * - Khi Client káº¿t ná»‘i vá»›i Server mÃ n hÃ¬nh Server hiá»‡n thÃ´ng bÃ¡o â€œCLIENT CONNECTEDâ€�, 
 * mÃ n hÃ¬nh Client hiá»‡n thÃ´ng bÃ¡o â€œCONNECTED TO SERVERâ€� - Thá»±c hiá»‡n trao Ä‘á»•i dá»¯ liá»‡u giá»¯a Client vÃ  Server nhÆ° sau: Client gá»­i thÃ´ng Ä‘iá»‡p báº¥t ká»³, mÃ n hÃ¬nh Server hiá»ƒn thá»‹ â€œCLIENT: â€�, Server gá»­i láº¡i thÃ´ng Ä‘iá»‡p Ä‘Ã£ nháº­n Ä‘Æ°á»£c cho Client dÆ°á»›i dáº¡ng kÃ½ tá»± hoa, nÃ m hÃ¬nh Client hiá»ƒn thá»‹ â€œSEREVER: â€� 
 * - Khi Client gá»­i thÃ´ng Ä‘iá»‡p â€œEXITâ€� Client vÃ  Server káº¿t thÃºc hoáº¡t Ä‘á»™ng
 * 
 * */

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
public class TCP_Client extends JFrame {

	private JPanel contentPane;

	private static JLabel lbNoiDungNhan;
	private static final String ADDRESS = "127.0.0.1";
	private static final int IP = 3000;
	private static JLabel lblInfo;
	private JTextPane txtNoiDung;
	
	private static Socket socket;
	private static DataInputStream dataIn;
	private static DataOutputStream dataOut;

	/**
	 * Launch the application.
	 */
	public TCP_Client() {
		try {
			socket = new Socket(ADDRESS,IP);
			dataIn = new DataInputStream(socket.getInputStream());
			dataOut = new DataOutputStream (socket.getOutputStream());
		}catch(Exception e) {}
	}
	public static void main(String[] args) {
		try {
			TCP_Client frame = new TCP_Client();
			frame.initFrame();
			frame.setVisible(true);
			
			while(true) {
				String str = dataIn.readUTF();
				if(str.equals("q")) {
					break;
				}
				System.out.println(str);
				lbNoiDungNhan.setText(str);
			}
			
		}catch(Exception e) {
			
		}finally {
			try {
			dataOut.close();
			dataIn.close();
			socket.close();
			}catch(Exception e) {}
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
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblTcpClient = new JLabel("TCP CLIENT");
		GridBagConstraints gbc_lblTcpClient = new GridBagConstraints();
		gbc_lblTcpClient.insets = new Insets(0, 0, 5, 0);
		gbc_lblTcpClient.gridx = 1;
		gbc_lblTcpClient.gridy = 0;
		contentPane.add(lblTcpClient, gbc_lblTcpClient);
		
		JLabel lblNiDungGi = new JLabel("Ná»™i dung gá»­i ");
		GridBagConstraints gbc_lblNiDungGi = new GridBagConstraints();
		gbc_lblNiDungGi.anchor = GridBagConstraints.EAST;
		gbc_lblNiDungGi.insets = new Insets(0, 0, 5, 5);
		gbc_lblNiDungGi.gridx = 0;
		gbc_lblNiDungGi.gridy = 3;
		contentPane.add(lblNiDungGi, gbc_lblNiDungGi);
		
		txtNoiDung = new JTextPane();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridheight = 6;
		gbc_textPane.insets = new Insets(0, 0, 5, 0);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 1;
		gbc_textPane.gridy = 1;
		contentPane.add(txtNoiDung, gbc_textPane);
		
		JButton btnGi = new JButton("Gá»­i");
		btnGi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					dataOut.writeUTF(txtNoiDung.getText());
					dataOut.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		lblInfo = new JLabel("info");
		GridBagConstraints gbc_lblInfo = new GridBagConstraints();
		gbc_lblInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblInfo.gridx = 0;
		gbc_lblInfo.gridy = 4;
		contentPane.add(lblInfo, gbc_lblInfo);
		GridBagConstraints gbc_btnGi = new GridBagConstraints();
		gbc_btnGi.insets = new Insets(0, 0, 5, 0);
		gbc_btnGi.gridx = 1;
		gbc_btnGi.gridy = 7;
		contentPane.add(btnGi, gbc_btnGi);
		
		lbNoiDungNhan = new JLabel("Ná»™i dung nháº­n Ä‘Æ°á»£c: ");
		GridBagConstraints gbc_lblNiDungNhn = new GridBagConstraints();
		gbc_lblNiDungNhn.insets = new Insets(0, 0, 5, 0);
		gbc_lblNiDungNhn.gridx = 1;
		gbc_lblNiDungNhn.gridy = 8;
		contentPane.add(lbNoiDungNhan, gbc_lblNiDungNhn);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 1;
		gbc_label.gridy = 10;
		contentPane.add(label, gbc_label);
	}

}
