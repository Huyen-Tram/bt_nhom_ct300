package shopping_cart;

import java.io.Serializable;

public class SanPham implements Serializable {
	private int masp;
	private String tensp;
	private String donvitinh;
	private int sltonkho;
	private double dongia;
	
	public  SanPham(int masp, String tensp, String donvitinh, int sltonkho, double dongia) {
		this.masp = masp;
		this.tensp = tensp;
		this.dongia = dongia;
		this.donvitinh = donvitinh;
		this.sltonkho = sltonkho;
		
	
	}
	public void print() {
		System.out.println("---------------------------");
		System.out.println(masp);
		System.out.println(tensp);
		System.out.println(donvitinh);
		System.out.println(sltonkho);
		System.out.println(dongia);
		
	}
	
	public int GetMa() {
		return this.masp;
	}
	
	public String GetTen_sp() {
		return this.tensp;
	}
	
	public int GetSL() {
		return this.sltonkho;
	}
	
	public String GetDonViTinh() {
		return this.donvitinh;
	}
	
	public double GetDonGia() {
		return this.dongia;
	}

}
