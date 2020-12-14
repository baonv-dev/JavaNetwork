package Bai1;

public class Animal extends Test implements Iinfo{
	private String hoten;

	public String getHoten() {
		return "Bảo";
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	
	@Override
	public void Hien()
	{
		System.out.printf("\nHọ tên %s", getHoten());
	}
	
	public void Hien(String ten)
	{
		System.out.printf("\nXin chào %s", ten);
	}

	@Override
	public void hienthongtin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hienthong() {
		// TODO Auto-generated method stub
		
	}
}
