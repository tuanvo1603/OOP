package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aism.helper.Helper;

public class Store{
	private ArrayList<Media> items = new ArrayList<>(); 
	private static Scanner scanner = new Scanner(System.in);
	private static Helper helper = new Helper();
	  @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        if (items.isEmpty()) {
	            sb.append("The store is empty!");
	        } else {
	            for (int i = 0; i < items.size(); i++) {
	                Media media = items.get(i);
	                sb.append((i + 1) + ". ID:" + media.getId() + ": "
	                        + media.getTitle() + "-"
	                        + media.getCategory() + "-" + media.getCost() + "$\n");
	            }
	        }
	        return sb.toString();
	    }
	public void display() {
		System.out.println(this.toString());
	}
	public void addDVD() {
		System.out.println("Title:");String title = scanner.next();
		System.out.println("Category:");String category = scanner.next();
		System.out.println("Director:");String director = scanner.next();
		System.out.println("Length:");int length = helper.getInt();
		System.out.println("Cost:");float cost  = helper.getFloat();
		items.add(new DigitalVideoDisc(title, category, director, length, cost));
		System.out.println(title+" is added");
	}
	public void addBook() {
		// TODO Auto-generated method stub
		System.out.println("Title:");String title = scanner.next();
		System.out.println("Category:");String category = scanner.next();
		System.out.println("Director:");String director = scanner.next();
		System.out.println("Cost:");float cost  = helper.getFloat();
		System.out.println("Number of authors:");
		int authors = scanner.nextInt();
		List<String> authorList = new ArrayList<>();
		for(int i = 0; i < authors; i++) {
			authorList.add(scanner.next());
		}
		items.add(new Book(title, category, director, cost, authorList));
		System.out.println(title+" is added");
	}
	public void addCD() {
		// TODO Auto-generated method stub
		System.out.println("Title:");String title = scanner.next();
		System.out.println("Category:");String category = scanner.next();
		System.out.println("Cost:");float cost  = helper.getFloat();
		System.out.println("Aritst:");String artist = scanner.next();
		ArrayList<Track> tracks = new ArrayList<>();
		System.out.println("Number of tracks:");int track = helper.getInt();
		for(int i = 0; i < track; i++) {
			System.out.println("Track title:");String trackTitle = scanner.next();
			System.out.println("Track length:"); int length = helper.getInt();
			tracks.add(new Track(trackTitle, length));
		}
		
		items.add(new CompactDisc(title,category, cost, artist, tracks));
		System.out.println(title+" is added");
	}
	public void removeByTitle() {
		System.out.println("Enter title of media:");
		String title = scanner.next();
		for(Media m : items) {
			if(m.getTitle().equals(title)) items.remove(m);
			System.out.println("item is removed");
			break;
		}
		System.out.println("item does not exist");	
	}
	public void removeByID() {
		System.out.println("Enter ID of media:");
		int id = helper.getInt();
		for(Media m : items) {
			if(m.getId() == id) items.remove(m);
			System.out.println("item is removed");
			break;
		}
		System.out.println("item does not exist");
	}
	public Media scanMedia() {
		System.out.println("Enter the title of the media:");
    	String title = scanner.next();
		for(Media m : items) {
			if(m.getTitle().equals(title)) return m;
		}
		System.out.println("item does not exist");
		return null;
		// TODO Auto-generated method stub
		
	}
}
