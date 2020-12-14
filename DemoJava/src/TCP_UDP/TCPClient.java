package TCP_UDP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {
	public static void main(String[] args) 
	{
		try {
			// Khởi tạo đối tượng socket
			// public Socket(InetAddress host, int port) throws IOException
			Socket socket = new Socket("127.0.0.1",3000);
			
			Scanner sc = new Scanner(System.in);
			
			//Tạo đối tượng DataOutputStream Để gửi dữ liệu
			DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
			
			//Tạo đối tượng DataInputStream Để nhận dữ liệu
			DataInputStream dataIn = new DataInputStream(socket.getInputStream());
			while(true)
			{
				String dataSend = sc.nextLine();
				// Nhận và đẩy dữ liệu
				dataOut.writeUTF(dataSend);
				dataOut.flush();
				//
				if(dataSend.equals("q"))
				{
					break;
				}
				String dataReceived = dataIn.readUTF();
				System.out.println(dataReceived);
			}
			dataIn.close();
			dataOut.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
	}
}
