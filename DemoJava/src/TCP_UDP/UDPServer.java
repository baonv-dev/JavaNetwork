package TCP_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPServer {
  public static void main(String[] args) throws IOException
  {
	  System.out.println("Đang chờ nhận dữ liệu");
	  //tạo kết nối udp socket
	  
	  DatagramSocket datagramSocket = new DatagramSocket();
	  //InetAddress được sử dụng  để biểu diễn các địa chỉ IP trong một ứng dụng mạng sử dụng Java
	  InetAddress ip = InetAddress.getByName("localhost");
	  //chuỗi dữ liệu gửi tới udp client
	  String str = "Hello";
	  
	  /*
	   * public DatagramPacket(byte[] b, int n, InternetAddress ia, int port)
	   * Phương thức này cho phép tạo một DatagramPacket chứa dữ liệu và cả địa chỉ của máy nhận dữ liệu.
	   * Phương thức trả về một đối tượng thuộc lớp DatagramePacket 
	   * */
	  DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(),str.length(),ip,3000);
	  
	  /*Dùng để gởi một DatagramPacket đi.*/
	  datagramSocket.send(datagramPacket);
	  datagramSocket.close();
  }
}
