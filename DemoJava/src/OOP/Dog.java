package OOP;

import java.util.Scanner;

public class Dog extends Animal implements Iinformation{
	public String trangthai;
	public Dog() {
		super();
	}
//	public void capNhapThongTin()
//	{
//		super.capNhapThongTin();
//		System.out.printf("\nNhập trạng thái: ");
//		Scanner sc = new Scanner(System.in);
//		trangthai = sc.nextLine();
//		
//	}
//	public void hienThiThongTin()
//	{
//		super.hienThiThongTin();
//		System.out.printf("\nTrạng thái: %s", trangthai);
//	}
	@Override
	public void printInformation() {
		System.out.print("all done");
	}

}
