package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DVD;

public class Cart {
	private static final int MAX_NUMBERS_ORDERED = 20;
	private static final boolean TRUE = false;
	private int qtyOrdered = 0;
	private DVD itemsOrdered[] = new DVD[MAX_NUMBERS_ORDERED];

	public void addDVD(DVD disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("Your cart is full.");
		} else {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered += 1;
			System.out.println("The disc " + disc.getTitle() + " has been added.");
		}
	}
	
//	public void addDVD(DVD[] DVDlist ) {
//		for(DVD dvd: DVDlist) {
//			addDVD(dvd);
//		}
//	}
	
	public void addDVD(DVD... disc) {
		addDVD(disc);
	}
	
	public void addDVD(DVD disc1, DVD disc2) {
		if(MAX_NUMBERS_ORDERED - qtyOrdered >= 2) {
			itemsOrdered[qtyOrdered] = disc1;
			qtyOrdered += 1;
			itemsOrdered[qtyOrdered + 1] = disc2;
			System.out.println("The disc " + disc1.getTitle() + disc2.getTitle() + "has been added");
		}else {
			if(MAX_NUMBERS_ORDERED - qtyOrdered == 1) System.out.println("Failture for adding. You only have 1 place in your cart");
			else System.out.println("Failture for adding. Your cart is full");
		}
	}

	public void removeDVD(DVD disc) {
		boolean check = false;

		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i] == disc) {
				for (int j = i; j < qtyOrdered; j++) {
					itemsOrdered[j] = itemsOrdered[j + 1];
				}
				qtyOrdered -= 1;
				System.out.println("The disc " + disc.getTitle() + " has been deleted.");
				check = true;
				break;
			}
		}
		if (!check) {
			System.out.println("The disc " + disc.getTitle() + " has been found in your cart.");
		}
	}

	public float totalCost() {
		float total = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			total = total + itemsOrdered[i].getCost();
		}
		return total;
	}
	
	public void showOrder() {
		System.out.println("*********************CART**********************");
		System.out.println("Odered Items:");
		for(int i=0; i<qtyOrdered; i++) {
			System.out.println((i+1) + "." + itemsOrdered[i].getTitle() + "-" + itemsOrdered[i].getCategory() +"-" + itemsOrdered[i].getDirector() + "-" + itemsOrdered[i].getLength() + "-" + itemsOrdered[i].getCost());
		}
		System.out.println("Total cost:" + totalCost());
		System.out.println("************************************************");
	}
	
	public boolean isMatch(String title) {
		for(int i=0; i<qtyOrdered; i++) {
			if(itemsOrdered[i].getTitle().equals(title)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isMatch(int id) {
		for(int i=0; i<qtyOrdered; i++) {
			if(itemsOrdered[i].getId() == id) {
				return true;
			}
		}
		return false;
	}
}


