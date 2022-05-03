package shopping_cart;

public class chi_tiet_hoa_don {
	private SanPham sp;
	private int so_luong;
	private int tongtienchitiet;
	
	public chi_tiet_hoa_don(SanPham sp, int so_luong, int tongtienchitiet) {
		this.sp = sp;
		this.so_luong = so_luong;
		this.tongtienchitiet = tongtienchitiet;
	}
	
	
	public void  print() {
		System.out.format("|%-30d|%-30s|%-30d|%-30d|%-30d|\n",sp.GetMa(),sp.GetTen_sp(),so_luong,sp.GetDonGia(),tongtienchitiet);
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");		
	}
	public SanPham get_sp() {
		return sp;
	}
	public void set_sl(int sl) {
		this.so_luong += sl;
	}
	public int get_sl() {
		return this.so_luong;
	}
	public void set_tongtienchitiet(int tien) {
		this.tongtienchitiet += tien;
		
	}
	public int get_tongtienchitiet() {
		return this.tongtienchitiet;
		
	}
	
	public void set_thaydoi(int sl,int dongia) {
		this.so_luong=sl;
		this.tongtienchitiet=sl*dongia;
	}
}
