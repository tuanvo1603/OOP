package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Media;

public class Cart {
	private static final int MAX_NUMBERS_ORDERED = 20;
	private static final boolean TRUE = false;
	private ArrayList<Media> itemOrdered = new ArrayList<Media>();
	
	
	
//	public void addDVD(DVD[] DVDlist ) {
//		for(DVD dvd: DVDlist) {
//			addDVD(dvd);
//		}
//	}
	
	public float totalCost() {
		float total = 0;
		for (int i = 0; i < itemOrdered.size(); i++) {
			total = total + itemOrdered.get(i).cost;
		}
		return total;
	}
	
	public void showOrder() {
		System.out.println("*********************CART**********************");
		System.out.println("Odered Items:");
		for(int i=0; i<itemOrdered.size(); i++) {
			System.out.println((i+1) + "." + itemOrdered.get(i).title + "-" + itemOrdered.get(i).category +"-" + itemOrdered.get(i).cost);
		}
		System.out.println("Total cost:" + totalCost());
		System.out.println("************************************************");
	}
	
	public boolean isMatch(String title) {
		for(int i=0; i<itemOrdered.size(); i++) {
			if(itemOrdered.get(i).equals(title)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isMatch(int id) {
		for(int i=0; i<itemOrdered.size(); i++) {
			if(itemOrdered.get(i).id == id) {
				return true;
			}
		}
		return false;
	}
	
	public void addMedia(Media media) {
		for(int i=0; i<itemOrdered.size(); i++) {
			if(itemOrdered.contains(media)) {
				System.out.println("Media is existed!");
				break;
			}
			
			itemOrdered.add(media);
			System.out.println("Successfully added!");
		}
	}
	
	public void removeMedia(Media media) {
		for(int i=0; i<itemOrdered.size(); i++) {
			if(itemOrdered.contains(media)) {
				itemOrdered.remove(i);
				System.out.println("Successfully removed!");
				break;
			}
			
			System.out.println("Media is not existed!");
		}
	}

	public ArrayList<Media> getItemOrdered() {
		return itemOrdered;
	}

	public List<Media> getListItemOrdered() {
		return (List) itemOrdered;
	}
	
	
	
}


