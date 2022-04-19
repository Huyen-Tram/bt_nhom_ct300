package shopping_cart;
import java.io.*;
import java.util.ArrayList;
public class read_file {
	
		
		
		public void ghiFile(ArrayList<SanPham> ds_sp) {
			try {
				ObjectOutputStream f = new ObjectOutputStream(
						new FileOutputStream("ds_san_pham.txt"));
	            f.writeObject(ds_sp);
				f.flush();
				f.close();
				System.out.println("ghi file thanh cong");
			}
			catch(FileNotFoundException e) {
				System.out.println("Loi khi mo file");
			}
			catch(IOException e) {
				System.out.println("Loi nhap xuat");
				
			}
		}
		public ArrayList<SanPham> docFile() {
			 ArrayList<SanPham> ds_sp = new ArrayList<SanPham>();
			try {
				ObjectInputStream f = new ObjectInputStream(
									new FileInputStream("ds_san_pham.txt"));
				ds_sp = (ArrayList<SanPham>) f.readObject();
				f.close();
				
				return ds_sp;
			}
			catch(FileNotFoundException e) {
				System.out.println("Loi khi mo file");
			}
			catch(IOException e) {
				System.out.println("Loi nhap xuat");
			}
			catch(ClassNotFoundException e) {
				System.out.println("Khong tim duoc lop Diem");
			}
			return null;
		}
	}
		
	

