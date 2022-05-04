package shoppingcart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.util.Random;
class SqladminTest {

  @Test
  void tim_sp() {
    Sqladmin test = new Sqladmin();
    SanPham sp = test.tim_sp(4);
    assertEquals(4, sp.getMa());
    assertEquals("non", sp.getTen_sp());
    assertEquals(15, sp.getSl());
    assertEquals(100000, sp.getDongia());
  }
  
  @Test
  void tim_spException() {
    Sqladmin test = new Sqladmin();
    SanPham sp = test.tim_sp(-5);
    assertEquals(null, sp);
    
  }
  @Test 
  void sua_sp() {
    Random r = new  Random();
    int soluong = r.nextInt() % 100;
    Random r2 = new  Random();
    int dongia = r2.nextInt() % 1000000;
    if(soluong < 0) {
      soluong *= -1;
    }
    if(dongia < 0) {
      dongia *= -1;
    }
    Sqladmin test = new Sqladmin();
    SanPham sp = new SanPham(5,"den",soluong,dongia);
    test.sua_sp(sp);
    SanPham sp2 = test.tim_sp(5);
    assertEquals(5, sp2.getMa());
    assertEquals("den", sp2.getTen_sp());
    assertEquals(soluong, sp2.getSl());
    assertEquals(dongia, sp2.getDongia());
  };
  @Test
  void xoa_sp() {
    Sqladmin test = new Sqladmin();
    assertEquals(1,test.xoa_sp(10));
    
  }
  
  @Test
  void xoa_sp2() {
    Sqladmin test = new Sqladmin();
    assertEquals(0,test.xoa_sp(10));
    
  }
  
  @Test
  void add_sp( ) {
    Sqladmin test = new Sqladmin();
    SanPham sp = new SanPham("san pham 100", 100, 100000);
    assertEquals(1,test.add_sp(sp));
  }
  @Test
  void get_sp() {
    Sqladmin test =  new Sqladmin();
    assertNotEquals(0, test.getallSp().size());
    
  }
}
