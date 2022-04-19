package shopping_cart;

import java.util.ArrayList;
import java.util.Scanner;

public class app_shoppingcart {
	
	public static void main(String[] args) {
		read_file f = new read_file();
		ArrayList<SanPham> ds_sp = new ArrayList<SanPham>();
		SanPham sp;
		for(int i = 0; i < 5; i++) {
			sp = new SanPham(i,"sach","quyen",100,100000);
			ds_sp.add(sp);
		}
		f.ghiFile(ds_sp);
		
		ArrayList<SanPham> ds_sp2 = new ArrayList<SanPham>() ;
		ds_sp2 = f.docFile();
//		for(int i = 0; i < ds_sp2.size(); i++) {
//			ds_sp2.get(i).print();
//		}
//		
		controller ctrl = new controller();
		int role;
		int choice;

		Scanner sc = new Scanner(System.in);
		while(true) {
			choice = ctrl.GetRole();
			if(choice == 0) {
				System.out.println("dang thoat chuong trinh.....");
				return;
			}
			else role = choice;
			choice = 0;
			
			
			// chuc nang admin
			if(role == 1) {
				while(true) {
					choice = ctrl.admin();
					
					switch ( choice ) {
				    case  0:
				    	System.out.println("dang thoat chuong trinh.....");
				        return;
				    case  1:
				        System.out.println("ds san pham.....");
				        break;
				    case  2:
				        System.out.println("them san pham.....");
				        break;
				    case  3:
				        System.out.println("sua san pham.....");
				        break;
				    case  4:
				        System.out.println("xoa san pham.....");
				        break;
				    case  5:
				        System.out.println("tro ve truoc.....");
				        break;
				    
				    default:
				    	
					}
					
					
				}
			}
		}
	}
}
	

