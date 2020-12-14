/*
 * 1. Sử dụng kỹ thuật lập trình TCP Socket viết chương trình trao đổi dữ liệu giữa 2 máy Server và Client 
 * thực hiện công việc sau: 
 * - Thiết lập kết nối giữa 2 máy tính trên địa chỉ 192.168.0.1 sử dụng cổng 2015. 
 * - Khi Client kết nối với Server màn hình Server hiện thông báo “CLIENT CONNECTED”, 
 * màn hình Client hiện thông báo “CONNECTED TO SERVER” - Thực hiện trao đổi dữ liệu giữa Client và Server như sau: Client gửi thông điệp bất kỳ, màn hình Server hiển thị “CLIENT: ”, Server gửi lại thông điệp đã nhận được cho Client dưới dạng ký tự hoa, nàm hình Client hiển thị “SEREVER: ” 
 * - Khi Client gửi thông điệp “EXIT” Client và Server kết thúc hoạt động
 * 
 * */
package TCP_Socket;
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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.JTextPane;
public class TCP_Client extends JFrame {

	private JPanel contentPane;
	private static Socket socket;
	private static JLabel lbNoiDungNhan;
	private static final String ADDRESS = "127.0.0.1";
	private static final int IP = 3000;
	private static JLabel lblInfo;
	private JTextPane txtNoiDung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					TCP_Client frame = new TCP_Client();
					frame.setVisible(true);
					Socket socket = new Socket(ADDRESS,IP);
					lblInfo.setText(ADDRESS+":"+IP);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				} 				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TCP_Client() {
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
		
		JLabel lblNiDungGi = new JLabel("Nội dung gửi ");
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
		
		JButton btnGi = new JButton("Gửi");
		btnGi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
					dataOut.writeUTF(txtNoiDung.getText());
					dataOut.flush();
					dataOut.close();
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
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
		
		lbNoiDungNhan = new JLabel("Nội dung nhận được ");
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
