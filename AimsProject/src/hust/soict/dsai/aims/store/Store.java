package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DVD;

public class Store {
	private int MAX_NUMBER_OF_DVD = 200;
	private DVD itemsInStore[] = new DVD[MAX_NUMBER_OF_DVD];
	
	public void addDVD(DVD disc) {
		if(MAX_NUMBER_OF_DVD > itemsInStore.length) {
			int k = itemsInStore.length;
			itemsInStore[k] = disc;
			System.out.println("Adding DVD successflly.");
		}
	}
	
	public void removeDVD(DVD disc) {
		boolean check = true;
		
		for(int i=0; i<itemsInStore.length; i++) {
			if(itemsInStore[i] == disc) {
				for(int j=i; j<itemsInStore.length; j++) {
					itemsInStore[j] = itemsInStore[j+1];
				}
				System.out.println("Removing DVD successfully.");
				check = true;	
			}
		}
		
		if(check == false) {
			System.out.println("DVD is not in store.");
		}
	}

	public DVD[] getItemsInStore() {
		return itemsInStore;
	}
	
}
