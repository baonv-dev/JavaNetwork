package TCP_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	 public static void main(String[] args) throws IOException
	  {
		 /*  
	         * 1. Tạo socket 
	         * 2. Gửi gói tin đến địa chỉ của server
	         * 3. Nhận gói tin đã xử lý từ server
	         * 4. Đóng socket
	         */
		 
		 System.out.println("Đang chờ nhận dữ liệu");
		  //InetAddress  được sử dụng  để biểu diễn các địa chỉ IP trong một ứng dụng mạng sử dụng Java
		  InetAddress ip = InetAddress.getByName("localhost");
		  System.out.println(ip);
		  DatagramSocket socket = new DatagramSocket(3000, ip);
		  
          //tạo các chuỗi byte
		  byte[] buf = new byte[1024];
		  
		  DatagramPacket datagramPacket = new DatagramPacket(buf,buf.length);
		  
		  //Chờ nhận một DatagramPacket. Quá trình sẽ bị nghẽn cho đến khi có dữ liệu đến.
		  socket.receive(datagramPacket);
		  
		  String str = new String(datagramPacket.getData(),0,buf.length);
		  /* datagram packet
		   * InternetAddress getAddress() : Địa chỉ máy gởi
		   * int getPort() : Cổng của quá trình gởi
		   * getData() : Dữ liệu từ gói tin
		   * int getLength() : Chiều dài của dữ liệu trong gói tin
		   */
		  System.out.println(str);
		  socket.close();
	  }
}
