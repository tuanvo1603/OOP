package hust.soict.dsai.aism.helper;

import java.util.Scanner;

public class Helper {
	Scanner scanner = new Scanner(System.in);
	public int getInt() {
		int x;
		while (true) {
	         try {
	            x = scanner.nextInt();
	            if (x <= 0) {
	               throw new Exception();
	            }
	            break;
	         }
	         catch (Exception e) {
	            System.out.println("Invalid input.");
	            scanner.nextLine(); // clear input buffer
	         }
	      }
		return x;
	}
	public float getFloat() {
		float x;
		while (true) {
	         try {
	            x = scanner.nextInt();
	            if (x <= 0) {
	               throw new Exception();
	            }
	            break;
	         }
	         catch (Exception e) {
	            System.out.println("Invalid input.");
	            scanner.nextLine(); // clear input buffer
	         }
	      }
		return x;
	}
	public int getOption() {
		int x;
		while (true) {
	         try {
	            x = scanner.nextInt();
	            if (x < 0) {
	               throw new Exception();
	            }
	            break;
	         }
	         catch (Exception e) {
	            System.out.println("Invalid input.");
	            scanner.nextLine(); // clear input buffer
	         }
	      }
		return x;
	}
	

	
}
