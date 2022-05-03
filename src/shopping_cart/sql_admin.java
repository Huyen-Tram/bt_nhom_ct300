package shopping_cart;
import java.sql.*;
import java.util.ArrayList;

public class sql_admin {
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
	
	
	public SanPham tim_sp(int id){
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
	
	public void add_sp(SanPham sp) {
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("insert sanpham (tensp, so_luong_ton_kho, don_gia) value ('" + sp.GetTen_sp() + "','" + sp.GetSL() + "','" + sp.GetDonGia() + "');");
			System.out.println("da them sp thanh cong!!!!!!!!");
		}
		catch (SQLException ex){ //xử lý ngoại lệ
			System.out.println("add_sp: " + ex.getMessage());
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
	public void xoa_sp(int id_xoa) {
		try {
			stmt = conn.createStatement();
			// Update
            String sqlUpdate = "UPDATE SanPham SET DAXOA=" + true +" where ID_SP=" + id_xoa + ";";
            stmt.executeUpdate(sqlUpdate);
            
 
			System.out.println("da xoa sp thanh cong, san pham co id la: " + id_xoa );
			
		}
		catch (SQLException ex){ //xử lý ngoại lệ
			System.out.println("xoa_sp: " + ex.getMessage());
		}
	}
}
