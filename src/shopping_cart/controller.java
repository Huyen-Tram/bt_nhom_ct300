package shopping_cart;

import java.util.Scanner;

public class controller {

	
	public int GetRole() {
		System.out.println("chon vai tro:");
		System.out.println("1. admin");
		System.out.println("2. nguoi dung");
		System.out.println("0. thoat chuong trinh");
		System.out.print("Nhap lua chon cua ban : ");
		
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	public int admin() {
		int choice = -1;
		while(true) {
			System.out.println("==========================");
			System.out.println("trang admin");
			System.out.println("chon chuc nang ban muon:");
			System.out.println("1. xem danh san pham");
			System.out.println("2. them san pham");
			System.out.println("3. sua san pham");
			System.out.println("4. xoa san pham");
			System.out.println("5. tro ve truoc");
			System.out.println("0. thoat chuong trinh");
			System.out.print("Nhap lua chon cua ban : ");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			if(choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 0) {
				return choice;
			}
			else System.out.println("lua chon sai, vui long chon lai!!!!");
		}
	}
}
