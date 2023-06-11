package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DVD;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;

public class Aims {

	public static void main(String[] args) {
		Store store = new Store();
		Cart order1 = new Cart();
		Scanner scanner = new Scanner(System.in);
		List<Media> collection = new ArrayList<>();
		Collections.sort(collection, Media.Compare_By_Title_Cost);

		DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		order1.addMedia(dvd1);

		DVD dvd2 = new DVD("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		order1.addMedia(dvd2);

		DVD dvd3 = new DVD("Aladin", "Animation", 18.99f);
		order1.addMedia(dvd3);

		while(true) {
			showMenu();
			int choice = scanner.nextInt();
			
			if(choice == 1) {
				showMenu();
				int choice11 = scanner.nextInt();
				if(choice11 == 1) {
					System.out.println("Enter the title:");
					String title = scanner.next();
					Media e = seeAMediaDetail(collection, title);
					mediaDetailsMenu();
					int choice111 = scanner.nextInt();
					if(choice111 == 1) {
						order1.addMedia(e);
					}
					if(choice111 == 2) {
						if(e instanceof DVD) {
							DVD ee = (DVD) e;
							ee.play();
						}
						if(e instanceof CompactDisc) {
							CompactDisc ee = (CompactDisc) e;
							ee.play();
						}
					}
					if(choice111 == 0) continue;
					
				}
				if(choice11 == 2) {
					showMediaInStore(collection);
					System.out.println("Enter the Id of your media you want to add: ");
					int id = scanner.nextInt();
					order1.addMedia(collection.get(id));
					continue;
				}
				if(choice11 == 3) {
					showMediaInStore(collection);
					System.out.println("Enter the Id of your media you want to play: ");
					int id = scanner.nextInt();
					if(collection.get(id) instanceof Book) {
						System.out.println("Your choice is a book!");
					}else if(collection.get(id) instanceof DVD) {
						DVD ee = (DVD) collection.get(id);
						ee.play();
					}else if(collection.get(id) instanceof CompactDisc) {
						CompactDisc ee = (CompactDisc) collection.get(id);
						ee.play();
					}
				}
				if(choice11 == 4) {
					order1.showOrder();
					cartMenu();
				}
				if(choice11 == 0) continue;
				continue;
			}
			
			if(choice == 2) {
				System.out.println("Options: ");
				System.out.println("1.Add a media to store");
				System.out.println("2.Remove a media to store");
				System.out.println("0.Back");
				int choice2 = scanner.nextInt();
				if(choice2 == 1) {
					System.out.println("Enter the Title: ");
					String title = scanner.next();
					System.out.println("Enter the Category: ");
					String category = scanner.next();
					System.out.println("Enter the Cost: ");
					float cost = scanner.nextFloat();
					System.out.println("Enter the ID: ");
					int id = scanner.nextInt();
					System.out.println("Enter the type of the media: ");
					String type = scanner.next();
					if("DVD".equalsIgnoreCase(type)) {
						DVD dvd = new DVD(title, category, cost);
						store.addMedia(dvd);
					}
					if("CompactDisc".equalsIgnoreCase(type)) {
						CompactDisc cd = new CompactDisc(title, category, cost);
						store.addMedia(cd);
					}
					if("Book".equalsIgnoreCase(type)) {
						Book book = new Book(title, category, cost);
						store.addMedia(book);
					}
				}
				if(choice2 == 2) {
					System.out.println("Enter the Title: ");
					String title = scanner.next();
					for(Media media: collection) {
						if(media.title.compareTo(title) == 0) {
							store.removeMedia(media);
							break;
						}
					System.out.println("The media is not in the store!");
					}
				}
				if(choice2 == 0) continue;
				continue;
			}
			if(choice == 3) {
				order1.showOrder();
				cartMenu();
				int choice3 = scanner.nextInt();
				if(choice3 == 1) {
					
				}
				if(choice3 == 2 ) {
					System.out.println("Options: ");
					System.out.println("1.Sort by title");
					System.out.println("2.Sort by cost");
					System.out.println("0.Back");
					int choice31 = scanner.nextInt();
					if(choice31 == 1) {
						Collections.sort(order1.getItemOrdered(), Media.Compare_By_Title_Cost);
					}
					if(choice31 == 2) {
						Collections.sort(order1.getItemOrdered(), Media.Compare_By_Cost_Title);
					}
					if(choice31 == 0) continue;
				}
				if(choice3 == 3) {
					System.out.println("Enter the title: ");
					String title = scanner.next();
					for(Media media: order1.getItemOrdered()) {
						if(title.equalsIgnoreCase(media.title)) {
							order1.removeMedia(media);
							break;
						}
						System.out.println("The media is not in the cart!");
					}
				}
				if(choice3 == 4) {
					showMediaInStore(order1.getListItemOrdered());
					System.out.println("Enter the Id of your media you want to play: ");
					int id = scanner.nextInt();
					if(collection.get(id) instanceof Book) {
						System.out.println("Your choice is a book!");
					}else if(collection.get(id) instanceof DVD) {
						DVD ee = (DVD) collection.get(id);
						ee.play();
					}else if(collection.get(id) instanceof CompactDisc) {
						CompactDisc ee = (CompactDisc) collection.get(id);
						ee.play();
					}
				}
				if(choice3 == 5) {
					System.out.println("Successfully placed order!");
					order1 = null;
				}
				if(choice3 == 0) continue;
				continue;
			}
			
			if(choice == 0) continue;
			continue;
			
			
		}

		
	}
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		}
	
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		}
	
	public static Media seeAMediaDetail(List<Media> collection, String title) {
		for(Media media: collection) {
			if(title.compareTo(media.title) == 1) {
				System.out.println("Title: " + media.title);
				System.out.println("Category: " + media.category);
				System.out.println("Cost: " + media.cost);
				System.out.println("ID: " + media.id);
			}
			return media;
		}
		System.out.println("The media is not in the store!");
		return null;
	}
	
	public static void showMediaInStore(List<Media> collection) {
		System.out.println("All medias in the store:");
		for(Media media: collection) {
			System.out.println("----------------------------------------");
			System.out.println("Title: " + media.title);
			System.out.println("Category: " + media.category);
			System.out.println("Cost: " + media.cost);
			System.out.println("ID: " + media.id);
			System.out.println("-----------------------------------------");
		}
	}
}
