package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aism.helper.Helper;

public class Cart {
    public static final int MAXIMUM_DVDS = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    private Helper helper = new Helper();
    private Scanner scanner = new Scanner(System.in);
    public void printCart() {
    	if(!itemsOrdered.isEmpty()) {
	    	double totalCost = 0;
	    	System.out.println("***********************CART***********************");
	    	System.out.println("Ordered items:");
	    	for(int i = 0; i < itemsOrdered.size(); i++) {
	    		System.out.println(toString(itemsOrdered.get(i)));
	    		totalCost += itemsOrdered.get(i).getCost();
	    	}
	    	System.out.println("Total cost "+ totalCost);
	    	System.out.println("***************************************************");
    	}else System.out.println("Cart is empty");
    }
    public String toString(Media m) {
    	return "DVD" + " " + 
    			m.getTitle() + " " +
    			m.getCategory() + " " +
    			m.getCost();
    }
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            total += itemsOrdered.get(i).getCost();
        }
        return total;
    }
	public void addMedia(Media media) {
		if(!itemsOrdered.contains(media)) {
			itemsOrdered.add(media);
		}
	}
	public void placeOrder() {
		System.out.println("An order is created");
		itemsOrdered.clear();
	}
	public void removeByID() {
		System.out.println("Enter ID of media:");
		int id = helper.getInt();
		for(Media m : itemsOrdered) {
			if(m.getId() == id) itemsOrdered.remove(m);
			System.out.println("item is removed");
			break;
		}
		System.out.println("item does not exist");
	}
	public void removeByTitle() {
		System.out.println("Enter title of media:");
		String title = scanner.next();
		for(Media m : itemsOrdered) {
			if(m.getTitle().equals(title)) itemsOrdered.remove(m);
			System.out.println("item is removed");
			break;
		}
		System.out.println("item does not exist");	
	}
	public void displayByTitle() {
		System.out.println("Enter title:");
		String title = scanner.next();
		for(Media m : itemsOrdered) {
			if(m.getTitle().equals(title)) System.out.println(m.toString());
		}
	}
	public void displayById() {
		System.out.println("Enter id:");
		int id = helper.getInt();
		for(Media m : itemsOrdered) {
			if(m.getId() == id) System.out.println(m.toString());
		}
	}
	public void sortCartByCostTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
		this.printCart();
	}
	public void sortCartByTitleCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
		this.printCart();
	}
	public Media scanMedia() {
		System.out.println("Enter the title of the media:");
    	String title = scanner.next();
		for(Media m : itemsOrdered) {
			if(m.getTitle().equals(title)) return m;
		}
		System.out.println("item does not exist");
		return null;
	}
    
}