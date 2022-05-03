package shopping_cart;
import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sql_user {
		private mysqlconnect c = new mysqlconnect();
		private Connection conn = c.getConnection();
		private Statement stmt = null;
		private ResultSet rs = null;
		
		public ArrayList<SanPham> GetallSp(){
			ArrayList<SanPham> ds_sp = new ArrayList<SanPham>();
			try {
				//dùng phương thức executeQuery để yêu cầu thực hiện lệnh SQL
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT * FROM sanpham where DAXOA is null");
				while(rs.next()) {
					
					SanPham sp = new SanPham(
							rs.getInt("id_sp"), 
							rs.getString("tenSp"),
							rs.getInt("SO_LUONG_TON_KHO"),
							rs.getInt("DON_GIA")
						);
					ds_sp.add(sp);	
				}

			
			//thao tác trên tập kết quả trả về rs....
			}
			catch (SQLException ex){ //xử lý ngoại lệ
				System.out.println("GetallSp: " + ex.getMessage());
			}
			
			
			
			return ds_sp;
		}
		
		public ArrayList<SanPham> tim_sp_ten(String tensp){
			SanPham sp = null;
			ArrayList<SanPham> ds_sp = new ArrayList<SanPham>();
			
			try {
				//dùng phương thức executeQuery để yêu cầu thực hiện lệnh SQL
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select * from sanpham where tensp like \"%"+ tensp +"%\";");
				while(rs.next()) {
					
					 sp = new SanPham(
							rs.getInt("id_sp"), 
							rs.getString("tenSp"),
							rs.getInt("SO_LUONG_TON_KHO"),
							rs.getInt("DON_GIA")
						);
					 
					ds_sp.add(sp);
				} 

					
			//thao tác trên tập kết quả trả về rs....
			}
			catch (SQLException ex){ //xử lý ngoại lệ
				System.out.println("tim sp: " + ex.getMessage());
			}
			
			
			
			return ds_sp;
		}
		
		public void xoa_sp(int id_xoa) {
			try {
				stmt = conn.createStatement();
				// Update
	            String sqlUpdate = "UPDATE SanPham SET DAXOA=" + true +" where ID_SP=" + id_xoa + ";";
	            int id = stmt.executeUpdate(sqlUpdate);
	            
	 
				System.out.println("da xoa sp thanh cong, san pham co id la: " + id );
				
			}
			catch (SQLException ex){ //xử lý ngoại lệ
				System.out.println("xoa_sp: " + ex.getMessage());
			}
		}
		public void sua_sp(SanPham sp) {
			try {
				stmt = conn.createStatement();
				// Update
	            String sqlUpdate = "UPDATE SanPham SET TENSP='" + sp.GetTen_sp() + "', SO_LUONG_TON_KHO='" + sp.GetSL() + "', DON_GIA='" + sp.GetDonGia() + "' where ID_SP=" + sp.GetMa() + ";";
	            int id = stmt.executeUpdate(sqlUpdate);
	            
	 
				System.out.println("da sua sp thanh cong san pham co id la: " + id );
				
			}
			catch (SQLException ex){ //xử lý ngoại lệ
				System.out.println("sua_sp: " + ex.getMessage());
			}
		}
		public SanPham tim_sp_id(int id){
			SanPham sp = null;
			
			try {
				//dùng phương thức executeQuery để yêu cầu thực hiện lệnh SQL
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT * FROM sanpham where id_sp="+ id);
				while(rs.next()) {
					
					 sp = new SanPham(
							rs.getInt("id_sp"), 
							rs.getString("tenSp"),
							rs.getInt("SO_LUONG_TON_KHO"),
							rs.getInt("DON_GIA")
						);
					
				}

					
			//thao tác trên tập kết quả trả về rs....
			}
			catch (SQLException ex){ //xử lý ngoại lệ
				System.out.println("tim sp: " + ex.getMessage());
			}
			
			
			
			return sp;
		}
		
}
