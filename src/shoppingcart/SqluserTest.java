package shoppingcart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SqluserTest {

  @Test
  void get_sp() {
    Sqluser test =  new Sqluser();
    assertNotEquals(0, test.getAllSp().size());
    
  }
  @Test
  void Tim_sp_ten() {
    Sqluser test =  new Sqluser();
    ArrayList<SanPham> sp = test.tim_sp_ten("a");
    assertNotEquals(0,sp.size());
  }
  
  @Test
  void Tim_sp_ten2() {
    Sqluser test =  new Sqluser();
    ArrayList<SanPham> sp = test.tim_sp_ten("8");
    assertEquals(0,sp.size());
  }

}
