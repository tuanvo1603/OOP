package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DVD;

public class CartTest {
	public static void main(String[] args) {
	Cart cart = new Cart();
	
	DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
	cart.addDVD(dvd1);
	
	DVD dvd2 = new DVD("Star Wars", "Science FIction", "George Lucas", 87, 24.95f);
	cart.addDVD(dvd2);
	
	DVD dvd3 = new DVD("Aladin", "Animation", 18.99f);
	cart.addDVD(dvd3);
	
	cart.showOrder();
	
	System.out.println(cart.isMatch("Aladin"));
	}
}
