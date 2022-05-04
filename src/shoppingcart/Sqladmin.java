package shoppingcart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/** tao ham chitiethoadon. */
public class Sqladmin {
  private Mysqlconnect connect = new Mysqlconnect();
  private Connection conn = connect.getConnection();
  private Statement stmt = null;
  private ResultSet rs = null;

  /** tao ham chitiethoadon. */
  public ArrayList<SanPham> getallSp() {
    ArrayList<SanPham> dssp = new ArrayList<SanPham>();
    try {
      // dùng phương thức executeQuery để yêu cầu thực hiện lệnh SQL
      stmt = conn.createStatement();
      rs = stmt.executeQuery("SELECT * FROM sanpham where DAXOA is null");
      while (rs.next()) {

        SanPham sp = new SanPham(rs.getInt("id_sp"), rs.getString("tenSp"),
            rs.getInt("SO_LUONG_TON_KHO"), rs.getInt("DON_GIA"));
        dssp.add(sp);
      }

      // thao tác trên tập kết quả trả v�? rs....
    } catch (SQLException ex) { // xử lý ngoại lệ
      System.out.println("GetallSp: " + ex.getMessage());
    }

    return dssp;
  }
  
  /** tao ham chitiethoadon. */
  public SanPham tim_sp(int id) {
    SanPham sp = null;

    try {
      // dùng phương thức executeQuery để yêu cầu thực hiện lệnh SQL
      stmt = conn.createStatement();
      rs = stmt.executeQuery("SELECT * FROM sanpham where DAXOA is null and id_sp=" + id);
      while (rs.next()) {

        sp = new SanPham(rs.getInt("id_sp"), rs.getString("tenSp"),
            rs.getInt("SO_LUONG_TON_KHO"), rs.getInt("DON_GIA"));

      }

      // thao tác trên tập kết quả trả v�? rs....
    } catch (SQLException ex) { // xử lý ngoại lệ
      System.out.println("tim sp: " + ex.getMessage());
    }

    return sp;
  }
  
  /** tao ham chitiethoadon. */
  public int add_sp(SanPham sp) {
    try {
      stmt = conn.createStatement();
      int seccess = stmt.executeUpdate(
          "insert sanpham (tensp, so_luong_ton_kho, don_gia) value ('"
              + sp.getTen_sp() + "','" + sp.getSl() + "','" + sp.getDongia()
              + "');");
      if(seccess == 1) {
        System.out.println("da them sp thanh cong!!!!!!!!");
        return seccess;
      }
      else {
        System.out.println("da them sp that bai!!!!!!!!");
        return 0;
      }
      
    } catch (SQLException ex) { // xử lý ngoại lệ
      System.out.println("add_sp: " + ex.getMessage());
      return 0;
    }

  }
  
  /** tao ham chitiethoadon. */
  public void sua_sp(SanPham sp) {
    try {
      stmt = conn.createStatement();
      // Update
      String sqlUpdate = "UPDATE SanPham SET TENSP='" + sp.getTen_sp()
          + "', SO_LUONG_TON_KHO='" + sp.getSl() + "', DON_GIA='"
          + sp.getDongia() + "' where ID_SP=" + sp.getMa() + ";";
      stmt.executeUpdate(sqlUpdate);

      System.out.println("da sua sp thanh cong san pham co id la: " + sp.getMa());

    } catch (SQLException ex) {
      System.out.println("sua_sp: " + ex.getMessage());
    }
  }
  
  /** tao ham chitiethoadon. */
  public int xoa_sp(int idXoa) {
    try {
      stmt = conn.createStatement();
      // Update
      String sqlUpdate = "UPDATE SanPham SET DAXOA=" + true + " where DAXOA is null and ID_SP="
          + idXoa + ";";
      int success = stmt.executeUpdate(sqlUpdate);
      if(success == 1) {
        System.out.println("da xoa sp thanh cong, san pham co id la: " + idXoa);
        return 1;
      }
      else {
        System.out.println("xoa sp co id la: " + idXoa + " that bai!!!!");
        return 0;
      }
    } catch (SQLException ex) { // xử lý ngoại lệ
        System.out.println("xoa_sp: " + ex.getMessage());
        return 0;
    }
  }
}
