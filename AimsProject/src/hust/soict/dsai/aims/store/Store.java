package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.DVD;
import hust.soict.dsai.aims.media.Media;

public class Store {
	private int MAX_NUMBER_OF_DVD = 200;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		for(int i=0; i<itemsInStore.size(); i++) {
			if(itemsInStore.contains(media)) {
				System.out.println("Media is existed!");
				break;
			}
			
			itemsInStore.add(media);
			System.out.println("Successfully added!");
		}
	}
	
	public void removeMedia(Media media) {
		for(int i=0; i<itemsInStore.size(); i++) {
			if(itemsInStore.contains(media)) {
				itemsInStore.remove(i);
				System.out.println("Successfully removed!");
				break;
			}
			
			System.out.println("Media is not existed!");
		}
	

	}
	
}
