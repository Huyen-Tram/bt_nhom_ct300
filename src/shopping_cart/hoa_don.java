package shopping_cart;
import java.util.*;
import java.text.*;

public class hoa_don {
	
	private int id_nguoidung = 1;
	private String ngaylap;
	private int tongtienhoadon;
	private ArrayList<chi_tiet_hoa_don> ds_chitiet;
	
	public hoa_don(ArrayList<chi_tiet_hoa_don> ds) {
		this.id_nguoidung = 1;
		Date date = Calendar.getInstance().getTime(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		this.ngaylap = dateFormat.format(date); 
		for(int i=0;i<ds.size();i++) {
			this.tongtienhoadon += ds.get(i).get_tongtienchitiet();
		}
		this.ds_chitiet = ds;
	}
	public void print() {
		
		for(int i =0;i< ds_chitiet.size();i++) {
			System.out.format("|%-30s|%-30d|%-30d|\n",ds_chitiet.get(i).get_sp().GetTen_sp(),ds_chitiet.get(i).get_sl(),ds_chitiet.get(i).get_tongtienchitiet());
			System.out.println("----------------------------------------------------------------------------------------------");			
		}
		System.out.println("tong so tien can thanh toan:" + tongtienhoadon);
		System.out.println("Cam on ban da mua hang!!!");
	}
}
