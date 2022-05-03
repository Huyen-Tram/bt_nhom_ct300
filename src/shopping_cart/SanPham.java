package shopping_cart;
import java.util.*;
import java.io.Serializable;

public class SanPham implements Serializable {
	private int masp;
	private String tensp;
	private int sltonkho;
	private int dongia;
	
	public  SanPham(int masp, String tensp, int sltonkho, int dongia) {
		this.masp = masp;
		this.tensp = tensp;
		this.dongia = dongia;
		this.sltonkho = sltonkho;
		
	
	}
	
	
	
	public  SanPham(String tensp, int sltonkho, int dongia) {
		
		this.tensp = tensp;
		this.dongia = dongia;
		this.sltonkho = sltonkho;
		
	
	}
	public void print() {
		System.out.format("|%-30d|%-30s|%-30d|%-30d|\n",masp,tensp,sltonkho,dongia);
		System.out.println("----------------------------------------------------------------------------------------------------------------------------");

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

	
	public int GetDonGia() {
		return this.dongia;
	}

}
