package week_2;

public class Cart {
	private static final int MAX_NUMBERS_ORDERED = 20;
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
}
