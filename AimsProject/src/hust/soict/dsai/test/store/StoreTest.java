package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DVD;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		Store store= new Store();
		
		DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);
		
		DVD dvd2 = new DVD("Star Wars", "Science FIction", "George Lucas", 87, 24.95f);
		store.addMedia(dvd2);
		
		DVD dvd3 = new DVD("Aladin", "Animation", 18.99f);
		store.addMedia(dvd3);
		
		store.removeMedia(dvd2);
		
//		System.out.println(store.getItemsInStore().length);
	}

}
