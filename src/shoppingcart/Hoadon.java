package shoppingcart;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

/** tao ham chitiethoadon. */
public class Hoadon {



  /** tao ham chitiethoadon. */
  private int idnguoidung = 1;
  /** tao ham chitiethoadon. */
  private String ngaylap;
  /** tao ham chitiethoadon. */
  private int tongtienhoadon;
  /** tao ham chitiethoadon. */
  private List<Chitiethoadon> dschitiet;
  
  /** tao ham chitiethoadon. */
  public Hoadon(final List<Chitiethoadon> danhsach) {
    this.idnguoidung = 1;
    final Date date = new Date();
    final DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    
    this.ngaylap = dateFormat.format(date);
    for (int i = 0; i < danhsach.size(); i++) {
      this.tongtienhoadon += danhsach.get(i).get_tongtienchitiet();
    }
    this.dschitiet = danhsach;
  }
  
  /** tao ham chitiethoadon. */
  public void print() {
    for(final Chitiethoadon cthd : dschitiet) {
      System.out.format("|%-30s|%-30d|%-30d|\n",
           cthd.get_sp().getTensp(),
           cthd.get_sl(),
           cthd.get_tongtienchitiet()
          );
    }
    System.out.println("tong so tien can thanh toan:" + tongtienhoadon);
    System.out.println("Cam on ban da mua hang!!!");
  }

  public int getTongtienhoadon() {
    return this.tongtienhoadon;
  }
  public void setTongtienhoadon(final int tongtienhoadon) {
    this.tongtienhoadon = tongtienhoadon;
  }
  public List<Chitiethoadon> getDschitiet() {
    return this.dschitiet;
  }
  public void setDschitiet( List<Chitiethoadon> dschitiet) {
    this.dschitiet = dschitiet ;
  }
}