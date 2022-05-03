package shopping_cart;
import java.util.*;


public class app_shoppingcart {
	
	public static void main(String[] args) {
		
		controller ctrl = new controller();
		String role ;
		String choice;

		
		ArrayList<chi_tiet_hoa_don> ds_chitiet = new ArrayList<chi_tiet_hoa_don>();

		while(true) {
			choice = ctrl.GetRole();
			System.out.println(choice);
			if(choice.equals("0")) {
				System.out.println("dang thoat chuong trinh.....");
				return;
			}
			else role = choice;
			choice = "0";

			
			// chuc nang admin
			if(role.equals("1")) {
				
				while(true) {
					choice = ctrl.admin();
				    
				    if(choice.equals("0")) {
				    	System.out.println("dang thoat chuong trinh.....");
				        return;
				    }
				    else if (choice.equals("1")) {
				    	System.out.println("ds san pham.....");
				        ctrl.in_ds_sp();
					}
				    else if (choice.equals("2")) {
				    	System.out.println("them san pham.....");
				        ctrl.admin_them();
					}
				    else if (choice.equals("3")) {
				    	System.out.println("sua san pham.....");
				    	ctrl.admin_sua_sp();
					}
				    else if (choice.equals("4")) {
				    	System.out.println("xoa san pham.....");
				    	ctrl.admin_xoa_sp();
					}
				    else if (choice.equals("5")) {
				    	System.out.println("trở về.....");
				    	break;
					}
					
				}
			}
			if(role.equals("2")) {
				
				while(true) {
					choice = ctrl.user();
				    
				    if(choice.equals("0")) {
				    	System.out.println("dang thoat chuong trinh.....");
				        return;
				    }
				    else if (choice.equals("1")) {
				    	System.out.println("ds san pham.....");
				        ctrl.in_ds_sp();
					}
				    else if (choice.equals("2")) {
				    	System.out.println("ds san pham trong gio hang.....");
				        ctrl.xem_giohang(ds_chitiet);
					}
				    else if (choice.equals("3")) {
				    	System.out.println("tim kiem san pham.....");
				        ctrl.tim_kiem();
					}
				    else if (choice.equals("4")) {
				    	System.out.println("them san pham vao gio hang.....");
				    	chi_tiet_hoa_don chitiet = ctrl.them_sp_giohang();
				    	if(chitiet != null) {
				    		ds_chitiet.add(chitiet)  ;
				    	}
				    	ds_chitiet=ctrl.xem_giohang(ds_chitiet);
				    	
					}
				    else if (choice.equals("5")) {
				    	System.out.println("xoa san pham.....");
				    	
				    	ds_chitiet=ctrl.xoa_sp_giohang(ds_chitiet);
					}
				    else if (choice.equals("6")) {
				    	System.out.println("thay doi so luong san pham");
				    	ds_chitiet=ctrl.thaydoisl(ds_chitiet);
					}
				    else if (choice.equals("7")) {
				    	System.out.println("thanh toan hoa don");
				    	ctrl.thanh_toan(ds_chitiet);
				    	ds_chitiet.clear();
					}
				    else if (choice.equals("8")) {
				    	System.out.println("trở về.....");
				    	break;
				}
			}
		}
	}
}
}
	

