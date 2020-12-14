package OOP;

import java.util.Scanner;

public class Animal {
	private String ten;
	private String loai;
	private String sochan;
	private String khanang;
	private String mota;
	public Animal()
	{
		
	}
	public Animal(String ten, String loai, String sochan, String khanang, String mota) {
		super();
		this.ten = ten;
		this.loai = loai;
		this.sochan = sochan;
		this.khanang = khanang;
		this.mota = mota;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public String getSochan() {
		return sochan;
	}
	public void setSochan(String sochan) {
		this.sochan = sochan;
	}
	public String getKhanang() {
		return khanang;
	}
	public void setKhanang(String khanang) {
		this.khanang = khanang;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public void capNhapThongTin()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tên loài vật: ");
		setTen(sc.nextLine());
		System.out.println("Nhập số chân: ");
		setSochan(sc.nextLine());
		System.out.println("Nhập khả năng: ");
		setKhanang(sc.nextLine());
		System.out.println("Nhập mô tả: ");
		setMota(sc.nextLine());
	}
	/* OverLoad Example  */
	public void hienThiThongTin()
	{
		System.out.printf("\nTên loài vật: %s", getTen());
		System.out.printf("\nSố chân: %s", getSochan());
		System.out.printf("\nKhả năng: %s", getKhanang());
		System.out.printf("\nMô tả: %s", getMota());
	}
	public void hienThiThongTin(String sochan)
	{
		System.out.printf("\nSố chân: %s", sochan);	
	}
	public void hienThiThongTin(String tenloai, String sochan)
	{
		System.out.printf("\nTên loại %s Số chân: %s",tenloai,sochan);	
	}
	
}

