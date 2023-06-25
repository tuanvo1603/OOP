package hust.soict.dsai.aims;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aism.helper.Helper;

public class Aims {
        public static Store store = new Store();
        public static Cart cart = new Cart();
        public static Scanner scanner = new Scanner(System.in);
        public static Helper helper = new Helper();
        public static void showMenu() {
                System.out.println("\nAIMS: ");
                System.out.println("-----------------------------------------------------------------");
                System.out.println("1.View Store");
                System.out.println("2.Update Store");
                System.out.println("3.See current cart");
                System.out.println("0.Exit");
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Please choose number: 0-1-2-3");
                int option = helper.getOption();
                switch(option) {
                	case 1: store.display();
                			storeMenu();
                			break;
                	case 2: updateMenu();
                			break;
                	case 3: cart.printCart();
                			cartMenu();
                			break;
                	case 0: System.exit(0);
                			break;
                }
        }
        public static void storeMenu() {
            System.out.println("\nSTORE MENU: ");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("1.See a Media's details");
            System.out.println("2.Add a Media to Cart");
            System.out.println("3.Play a Media");
            System.out.println("4.See current cart");
            System.out.println("0.Back");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Please choose number: 0-1-2-3-4");
            int option = helper.getOption();
            switch(option) {
            	case 1: mediaDetailsMenu();
            			break;
            	case 2: if(store.scanMedia() != null) cart.addMedia(store.scanMedia());
            			storeMenu();
            			break;
            	case 3: if(store.scanMedia() != null) store.scanMedia().play();
            			storeMenu();
            			break;
            	case 4: cart.printCart();
            			cartMenu();
            			break;
            	case 0: showMenu();
            			break;
            }
    }	
        public static void mediaDetailsMenu() {
        	Media media = store.scanMedia();
        	if(media != null) {
        		System.out.println(media.toString());
        		System.out.println("Options: ");
            	System.out.println("--------------------------------");
            	System.out.println("1. Add to cart");
            	System.out.println("2. Play");
            	System.out.println("0. Back");
            	System.out.println("--------------------------------");
            	System.out.println("Please choose a number: 0-1-2");
            	int option = helper.getOption();
            	switch(option) {
            		case 1: cart.addMedia(media);
            				System.out.println("item is added");
            				showMenu();
            				break;
            		case 2: media.play();
            				mediaDetailsMenu();
    						break;
            		case 3: storeMenu();
    						break;
            	}
        	}else	storeMenu();
        	
    	
        }
        public static void updateMenu() {
                System.out.println("\nUPDATE STORE MENU:");
                System.out.println("---------------------------------------------------------------------");
                System.out.println("1.Add a Media");
                System.out.println("2.Remove a Media");
                System.out.println("0.Back");
                System.out.println("---------------------------------------------------------------------");
                System.out.println("Please choose number: 0-1-2");
                int option = helper.getOption();
                switch(option) {
                	case 1: addMediaMenu();
                			break;
                	case 2: removeMediaMenu();
                			break;
                	case 0: showMenu();
                			break;
                			
                }
        }
        public static void addMediaMenu() {
            System.out.println("\nADD MEDIA MENU");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("1.Add DVD");
            System.out.println("2.Add Book");
            System.out.println("3.Add CD");
            System.out.println("0.Back");
            System.out.println("---------------------------------------------------------------------");
            int option = helper.getOption();
            switch (option) {
                    case 1:
                            store.addDVD();
                            addMediaMenu();
                            break;
                    case 2:
                            store.addBook();
                            addMediaMenu();
                            break;
                    case 3:
                            store.addCD();
                            addMediaMenu();
                            break;
                    case 0:
                            updateMenu();
                            break;
            }
    }
        public static void removeMediaMenu() {
                System.out.println("\nOptions:");
                System.out.println("---------------------------------------------------------------------");
                System.out.println("1.Remove By ID");
                System.out.println("2.Remove By Title");
                System.out.println("0.Back");
                int option = helper.getOption();
                switch (option) {
                        case 1:
                                store.removeByID();
                                removeMediaMenu();
                                break;
                        case 2:
                                store.removeByTitle();
                                removeMediaMenu();
                                break;
                        case 0:
                                updateMenu();
                                break;
                }
        }

        public static void cartMenu() {
                System.out.println("Options:");
                System.out.println("--------------------------------");
                System.out.println("1. Filter medias in cart");
                System.out.println("2. Sort medias in cart");
                System.out.println("3. Remove media from cart");
                System.out.println("4. Play a media");
                System.out.println("5. Place order");
                System.out.println("0. Back");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number: 0-1-2-3-4-5");
                int option = helper.getOption();
                switch (option) {
                case 1:
                        filterMediaInCartMenu();
                        break;
                case 2:
                        sortMediasInCartMenu();
                        break;
                case 3:
                        removeMediaFromCartMenu();
                        break;
                case 4: if(cart.scanMedia() != null) cart.scanMedia().play();
                		cartMenu();
                		break;
                case 5: cart.placeOrder();
                		showMenu();
                		break;
                case 0: showMenu();
                		break;
        }

        }
        public static void removeMediaFromCartMenu() {
                System.out.println("\n REMOVE MEDIA FROM CART MENU:");
                System.out.println("---------------------------------------------------------------------");
                System.out.println("1.Remove By ID");
                System.out.println("2.Remove By Title");
                System.out.println("0.Back");
                int option = helper.getOption();
                switch (option) {
                case 1:
                        cart.removeByID();
                        removeMediaFromCartMenu();
                        break;
                case 2:
                        cart.removeByTitle();
                        removeMediaFromCartMenu();
                        break;
                case 0:
                        cartMenu();
                        break;
        }
        }

        public static void filterMediaInCartMenu() {
                System.out.println("\nFILTER MEDIA IN CART MENU");
                System.out.println("---------------------------------------");
                System.out.println("1. Filter by title");
                System.out.println("2. Filter by ID");
                System.out.println("0. Back");
                int option = helper.getOption();
                switch (option) {
                case 1:
                        cart.displayByTitle();
                        filterMediaInCartMenu();
                        break;
                case 2:
                		cart.displayById();
                        filterMediaInCartMenu();
                        break;
                case 0:
                        cartMenu();
                        break;
        }
        }

        public static void sortMediasInCartMenu() {
                System.out.println("\nSORT MEDIA IN CART MENU:");
                System.out.println("-----------------------");
                System.out.println("1.Sort by Title");
                System.out.println("2.Sort by Cost");
                System.out.println("0.Back");
                System.out.println("Please enter option: 0-1-2");
                int option = helper.getOption();
                switch (option) {
                        case 1:
                                cart.sortCartByCostTitle();
                                sortMediasInCartMenu();
                                break;
                        case 2:
                        		cart.sortCartByTitleCost();
                                sortMediasInCartMenu();
                                break;
                        case 0:
                                cartMenu();
                                break;
                }
               
        }

        public static void main(String[] args) {
                showMenu();
                scanner.close();
        }
}