package shoppingcart;

/** tao class chitiethoadon. */
public class Chitiethoadon {
  private SanPham sp;
  private int soluong;
  private int tongtienchitiet;
  
  /** tao ham chitiethoadon. */
  public Chitiethoadon(SanPham sp, int soLuong, int tongtienchitiet) {
    this.sp = sp;
    this.soluong = soLuong;
    this.tongtienchitiet = tongtienchitiet;
  }
  
  /** tao ham print. */
  public void print() {
    System.out.format("|%-30d|%-30s|%-30d|%-30d|%-30d|\n", sp.getMasp(),
        sp.getTensp(), soluong, sp.getDongia(), tongtienchitiet);
    System.out.print("------------------------------------------------------");
    System.out.print("-------------------------------------");
    System.out.println("-----------------------------------------------------------------");
  }
  
  /** tao ham get_sp. */
  public SanPham get_sp() {
    return this.sp;
  }
  
  /** tao ham set_sl. */
  public void set_sl(int sl) {
    this.soluong += sl;
  }
  
  /** An especially short bit of Javadoc. */
  public int get_sl() {
    return this.soluong;
  }
  
  /** An especially short bit of Javadoc. */
  public void set_tongtienchitiet(int tien) {
    this.tongtienchitiet += tien;

  }
  
  /** An especially short bit of Javadoc. */
  public int get_tongtienchitiet() {
    return this.tongtienchitiet;

  }

  /** An especially short bit of Javadoc. */
  public void set_thaydoi(int sl, int dongia) {
    this.soluong = sl;
    this.tongtienchitiet = sl * dongia;
  }
}
