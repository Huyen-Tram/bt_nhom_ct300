package shopping_cart;

import java.util.*;


public class controller {

	
	public String GetRole() {
		while(true) {
			System.out.println("chon vai tro:");
			System.out.println("1. admin");
			System.out.println("2. user");
			System.out.println("0. thoat chuong trinh");
			System.out.print("Nhap lua chon cua ban : ");
			
			Scanner sc = new Scanner(System.in);
			String choice =sc.nextLine();
			if(choice.equals("0") || choice.equals("1") || choice.equals("2")) {
				return choice;
			}
			else System.out.println("lua chon sai, vui long chon lai!!!!");
		}
		
	}
	
	public String admin() {
		String choice;
		while(true) {
			System.out.println("==========================");
			System.out.println("trang admin");
			System.out.println("chon chuc nang ban muon:");
			System.out.println("1. xem danh san pham");
			System.out.println("2. them san pham");
			System.out.println("3. sua san pham");
			System.out.println("4. xoa san pham");
			System.out.println("5. tro ve truoc");
			System.out.println("0. thoat chuong trinh");
			System.out.print("Nhap lua chon cua ban : ");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextLine();
			if(choice.equals("0") || choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("5")) {
				return choice;
			}
			else System.out.println("lua chon sai, vui long chon lai!!!!");
		}
		
	}
	public void admin_them() {
		SanPham sp;
		Scanner a = new Scanner(System.in);
		System.out.print("nhap ten san pham: ");
		String ten = a.nextLine();
		System.out.print("nhap so luong san pham: ");
		int so_luong = a.nextInt();
		System.out.print("nhap don gia san pham: ");
		int don_gia = a.nextInt();
		sp = new SanPham(ten,so_luong,don_gia);
		sql_admin ad = new sql_admin();
		ad.add_sp(sp);
	}
	
	public void in_ds_sp() {
		sql_admin ad = new sql_admin();
		ArrayList<SanPham> ds_sp;
		ds_sp = ad.GetallSp();		
		System.out.println("----------------------------------------------------------------------------------------------------------------------------");
		System.out.format("|%-30s|%-30s|%-30s|%-30s|\n","id","ten","soluong ton kho","don gia");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------");
		for(int i=0; i< ds_sp.size();i++) {
			ds_sp.get(i).print();
		}
	}
	public void admin_sua_sp() {
		sql_admin ad = new sql_admin();
		
		System.out.print("nhap id san pham can sua:" );
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		SanPham sp = ad.tim_sp(id);
		
		System.out.println("ten cu cua san pham la:" + sp.GetTen_sp());
		System.out.println("vui long nhap ten moi, neu khong thay doi, nhap -1 de bo qua!");
		sc.nextLine();
		String ten = sc.nextLine();
		if(ten.equals("-1")) {
			ten=sp.GetTen_sp();
		}
		
		System.out.println("so luong cu cua san pham la:" + sp.GetSL());
		System.out.println("vui long nhap ten moi, neu khong thay doi, nhap -1 de bo qua!");
		int so_luong =  sc.nextInt();
		if(so_luong == -1) {
			so_luong=sp.GetSL();
		}
		System.out.println("don gia cu cua san pham la:" + sp.GetDonGia());
		System.out.println("vui long nhap don_gia moi, neu khong thay doi, nhap -1 de bo qua!");
		int don_gia =  sc.nextInt();
		if(don_gia == -1) {
			don_gia=sp.GetDonGia();
		}
		
		SanPham sp_update = new SanPham(id, ten, so_luong, don_gia);
		
		ad.sua_sp(sp_update);
		
	}
	public void admin_xoa_sp() {
		sql_admin ad = new sql_admin();
		
		System.out.print("nhap id san pham can xoa:" );
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		 ad.xoa_sp(id);
	}
	public String user() {
		String choice;
		while(true) {
			System.out.println("==========================");
			System.out.println("trang user");
			System.out.println("chon chuc nang ban muon:");
			System.out.println("1. xem danh san pham");
			System.out.println("2. xem danh san pham trong gio hang");
			System.out.println("3. tim kiem san pham");
			System.out.println("4. them vao gio hang");
			System.out.println("5. xoa khoi gio hang");
			System.out.println("6. thay doi so luong");
			System.out.println("7. thanh toan hoa don");
			System.out.println("8. tro ve truoc");
			System.out.println("0. thoat chuong trinh");
			System.out.print("Nhap lua chon cua ban : ");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextLine();
			if(choice.equals("0") || choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("5") || choice.equals("6") || choice.equals("7") || choice.equals("8")) {
				return choice;
			}
			else System.out.println("lua chon sai, vui long chon lai!!!!");
		}
		
	}
	public void tim_kiem() {
		System.out.print("nhap ten san pham can tim:" );
		Scanner sc = new Scanner(System.in);
		String ten_sp = sc.nextLine();
		sql_user  user = new sql_user();
		
		ArrayList<SanPham> ds_sp = user.tim_sp_ten(ten_sp);
		System.out.println("----------------------------------------------------------------------------------------------------------------------------");
		System.out.format("|%-30s|%-30s|%-30s|%-30s|\n","id","ten","soluong ton kho","don gia");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------");
		for(int i=0; i< ds_sp.size();i++) {
			ds_sp.get(i).print();
		}
		
	}
	
	public chi_tiet_hoa_don them_sp_giohang() {
		chi_tiet_hoa_don chitiet= null;
		System.out.print("nhap id san pham can them vao gio hang:");
		Scanner sc = new Scanner(System.in);
		int id_sp = sc.nextInt();
		System.out.print("nhap so luong:");
		int sl = sc.nextInt();
		sql_user user = new sql_user();
		SanPham sp = user.tim_sp_id(id_sp);
		if(sp!= null) {
			if(sp.GetSL()< sl) {
				sl = sp.GetSL();
			}
			chitiet = new chi_tiet_hoa_don(sp,sl,sp.GetDonGia()*sl);
		}
		
		return chitiet;	
	}
	public ArrayList<chi_tiet_hoa_don> xem_giohang(ArrayList<chi_tiet_hoa_don> ds_chitiet) {
		if(ds_chitiet.size()>0) {
			if(ds_chitiet.size()>1) {
				for(int i=0;i< ds_chitiet.size()-1;i++) {
					for(int j = i+1; j< ds_chitiet.size();j++) {
						if(ds_chitiet.get(i).get_sp().GetMa() == ds_chitiet.get(j).get_sp().GetMa()) {
							ds_chitiet.get(i).set_sl(ds_chitiet.get(j).get_sl());
							ds_chitiet.get(i).set_tongtienchitiet(ds_chitiet.get(j).get_tongtienchitiet());
							ds_chitiet.remove(j);
							j--;
						}
					}
				}
			}
			
			
			
			
			System.out.println("danh sach gio hang:");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.format("|%-30s|%-30s|%-30s|%-30s|%-30s|\n","id","ten sp","soluong","don gia","tong gia tien");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
			for(int i=0; i< ds_chitiet.size();i++) {
				ds_chitiet.get(i).print();
			}
		}
		else {
			System.out.println("gio hang rong!!!!!");
		}
		return ds_chitiet;
	}
	public ArrayList<chi_tiet_hoa_don> xoa_sp_giohang(ArrayList<chi_tiet_hoa_don> ds) {
		
		System.out.print("nhap id san pham ban muon xoa ra khoi gio hang:");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		int size = ds.size();
		for(int i =0 ; i<ds.size(); i++) {
			if(ds.get(i).get_sp().GetMa()==id) {
				ds.remove(i);
			}
			
		}
		if(size == ds.size()) {
			System.out.println(" gio hang khong co san pham ban can xoa!!!");
		}
		else System.out.println(" da xoa thanh cong san pham co id la: " + id +"!!!");
		return ds;
	}
	public ArrayList<chi_tiet_hoa_don> thaydoisl(ArrayList<chi_tiet_hoa_don> ds) {
		System.out.print("nhap id san pham ban muon thay doi so luong:");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		int dasua= 0;
		for(int i =0 ; i<ds.size(); i++) {
			if(ds.get(i).get_sp().GetMa()==id) {
				System.out.println("so luong cu la:" + ds.get(i).get_sl());
				System.out.println("nhap so luong moi la:");
				int sl = sc.nextInt();
				if(ds.get(i).get_sp().GetSL()< sl) {
					sl = ds.get(i).get_sp().GetSL();
				}
				
				ds.get(i).set_thaydoi(sl,ds.get(i).get_sp().GetDonGia());
				System.out.println("da thay doi so luong thanh:" + sl);
				dasua = 1;
			}
		
		}
		
		if (dasua == 0) {
			System.out.println(" gio hang khong co san pham ban can thay doi so luong!!!");
		}
		return ds;
		
	}
	public void thanh_toan(ArrayList<chi_tiet_hoa_don> thanhtoan) {
		if(thanhtoan.size()>0) {
			hoa_don hoadon = new hoa_don(thanhtoan);
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.format("%-30s%s\n","", "hoa don");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.format("|%-30s|%-30s|%-30s|\n","ten san pham", "so luong", "thanh tien");
		System.out.println("----------------------------------------------------------------------------------------------");
		hoadon.print();
		}
		else System.out.format("gio hang rong khong the thanh toan!!!\n");
			
		
	}
	
}
