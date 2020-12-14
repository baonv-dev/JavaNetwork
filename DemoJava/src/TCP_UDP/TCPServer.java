package TCP_UDP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
	public static void main(String[] args)
	{
			try {
				System.out.print("Start Server");
				//public ServerSocket(int port) throws IOException
				//Tạo socket server, chờ tại cổng '6543'
				ServerSocket serverSocket = new ServerSocket(3000);
				 //chờ yêu cầu từ client
				Socket socket = serverSocket.accept();
				Scanner sc = new Scanner(System.in);
				
			    //Tạo DataoutputStream, nối tới socket
				DataOutputStream dataOut = new DataOutputStream (socket.getOutputStream());
				DataInputStream dataIn = new DataInputStream(socket.getInputStream());
				while(true)
				{
					// Đọc thông tin từ socket trả về
					String str = dataIn.readUTF();
					if(str.equals("q"))
					{
						break;
					}
					System.out.println(str);
					String dataSend = sc.nextLine();
					
					dataOut.writeUTF(dataSend);
					dataOut.flush();
				}
				// Đóng các kết nối tới socket
				dataOut.close();
				dataIn.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
