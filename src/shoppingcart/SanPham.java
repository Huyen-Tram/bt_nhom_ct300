package shoppingcart;



/** tao tao class sanpham. */
public class SanPham {
  
  /** tao tao class sanpham. */
  private int masp;
  /** tao tao class sanpham. */
  private int sltonkho;
  /** tao tao class sanpham. */
  private int dongia;
  /** tao tao class sanpham. */
  private String tensp;
  
  /** tao ham xay dung. */
  public SanPham(final int masp, final String tensp, final int sltonkho, final int dongia) {
    this.masp = masp;
    this.tensp = tensp;
    this.dongia = dongia;
    this.sltonkho = sltonkho;

  }
  
  /** tao ham xay dung. */
  public SanPham( final String tensp, final int sltonkho, final int dongia) {
    this.tensp = tensp;
    this.dongia = dongia;
    this.sltonkho = sltonkho;

  }
  
  /** tao ham print. */
  public void print() {
    
    System.out.format("|%-30d|%-30s|%-30d|%-30d|\n", masp, tensp, sltonkho,dongia);
    System.out.print("------------------------------------------------------");
    System.out.println("----------------------------------------------------------------------");

  }

  public int getMasp() {
    return this.masp;
  }
  public void setMasp(final int masp) {
    this.masp = masp;
  }
  
  public int getSltonkho() {
    return this.sltonkho;
  }
  public void setSltonkho(final int sltonkho) {
    this.sltonkho = sltonkho;
  }

  public String getTensp() {
    return this.tensp;
  }
  public void setTensp(final String tensp) {
    this.tensp = tensp;
  }


  public int getDongia() {
    return this.dongia;
  }
  public void setDongia(final int dongia) {
    this.dongia = dongia;
  }


}
